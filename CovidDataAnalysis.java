import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.transform.Source;

public class CovidDataAnalysis {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        int menu1SelcetionNum;

        String file = "/home/forhad/Desktop/dataset.csv";
        // String file = "/home/forhad/VsCode/Java
        // Project/My_java/Covid_data_analysis/src/dataset.csv";
        BufferedReader reader = null;

        String line = "";
        String delemeter = ",";
        List<CovidRecord> covidRecords = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        Country country;

        try {
            reader = new BufferedReader(new FileReader(file));
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(delemeter);
                countries.add(new Country(data[1], data[2], data[3], data[12], data[4], data[5]));
                country = countries.get(i++);
                covidRecords
                        .add(new CovidRecord(data[0], data[6], data[7], data[8], data[9], data[10], data[11], country));
            }
            // CovidRecord covidRecord = covidRecords.get(1);
            /*
             * Country country = countries.get(1783);
             * System.out.println(country.iso3);
             */

            // uniqCountry(countries);

            // shwo 1st Menu
            mShowMenu1();

            // Select menu item
            System.out.print("Enter Selection Number: ");
            menu1SelcetionNum = scanner.nextInt();

            // take action according to selection
            mExecuteSelection1(menu1SelcetionNum, countries, covidRecords);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void mExecuteSelection1(int menu1SelcetionNum, List<Country> countries,
            List<CovidRecord> covidRecords) {
        switch (menu1SelcetionNum) {
            case 0:
                List<String> allCountries = uniqCountry(covidRecords);
                mAnalysisData(covidRecords, allCountries);
                break;
            case 1:
                List<String> allSACountries = mGetParticularContries(countries, "SA");
                mAnalysisData(covidRecords, allSACountries);
                break;
            case 2:
                List<String> allNACountries = mGetParticularContries(countries, "NA");
                mAnalysisData(covidRecords, allNACountries);
                break;
            case 3:
                List<String> allOceniaCountries = mGetParticularContries(countries, "OC");
                mAnalysisData(covidRecords, allOceniaCountries);
                break;
            case 4:
                List<String> allAsiaCountries = mGetParticularContries(countries, "AS");
                mAnalysisData(covidRecords, allAsiaCountries);
                break;
            case 5:
                List<String> allAfricaCountries = mGetParticularContries(countries, "AF");
                mAnalysisData(covidRecords, allAfricaCountries);
                break;
            case 6:
                List<String> allEuropeCountries = mGetParticularContries(countries, "EU");
                mAnalysisData(covidRecords, allEuropeCountries);
                break;
            case 7:
                Scanner scanner = new Scanner(System.in);
                String countryName;
                System.out.print("Enter a country name: ");
                countryName = scanner.next();

                mAnalysisDataForOneCountry(covidRecords, countryName);
                break;
            case 8:
                Scanner scanner1 = new Scanner(System.in);
                String date;
                System.out.print("Enter a date: ");
                date = scanner1.next();
                mAnalysisDataForOneDate(covidRecords, date);
                break;
            default:
                break;
        }
    }

    private static void mAnalysisDataForOneDate(List<CovidRecord> covidRecords, String date) {
        List<String> numOfSameDateCountry = new ArrayList<>();

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.getCountry();
            if (covidRecord.getDate().equalsIgnoreCase(date)) {
                numOfSameDateCountry.add(country.getCountryName());

            }
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int menu2SelectionNum;

        mShowMenu2();

        System.out.print("Enter Selection Number: ");
        menu2SelectionNum = scanner.nextInt();

        mExecuteSelection2(menu2SelectionNum, covidRecords, numOfSameDateCountry);

    }

    private static void mAnalysisDataForOneCountry(List<CovidRecord> covidRecords,
            String countryName) {
        List<String> numberOfthisCountry = new ArrayList<>();

        for (int i = 0; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.country;

            if (country.getCountryName().equalsIgnoreCase((countryName))) {
                numberOfthisCountry.add(countryName);
            }
        }

        for (int i = 0; i < numberOfthisCountry.size(); i++) {
            System.out.println(numberOfthisCountry.get(i));

        }

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int menu2SelectionNum;

        mShowMenu2();

        System.out.print("Enter Selection Number: ");
        menu2SelectionNum = scanner.nextInt();

        mExecuteSelection2(menu2SelectionNum, covidRecords, numberOfthisCountry);

    }

    private static List<String> mGetParticularContries(List<Country> countries, String continent) {
        List<String> validCountries = new ArrayList<>();

        Country country;
        for (int i = 1; i < countries.size(); i++) {
            country = countries.get(i);
            if (country.getContinent().equals(continent)) {
                if (!validCountries.contains(country.countryName)) {
                    validCountries.add(country.countryName);
                }
            }
        }

        for (int i = 0; i < validCountries.size(); i++) {
            System.out.println(validCountries.get(i));
        }
        System.out.println();
        System.out.println(continent + " Countries : " + validCountries.size());

        return validCountries;
    }

    private static void mAnalysisData(List<CovidRecord> covidRecords, List<String> particularCountries) {
        Scanner scanner = new Scanner(System.in);
        int menu2SelectionNum;

        mShowMenu2();

        System.out.print("Enter Selection Number: ");
        menu2SelectionNum = scanner.nextInt();

        mExecuteSelection2(menu2SelectionNum, covidRecords, particularCountries);

    }

    private static void mExecuteSelection2(int menu2SelectionNum, List<CovidRecord> covidRecords,
            List<String> particularCountries) {
        switch (menu2SelectionNum) {
            case 0:

                mTotalCumPos(covidRecords, particularCountries);
                break;
            case 1:
                mTotalCumDecease(covidRecords, particularCountries);

                break;
            case 2:
                mTotalRecover(covidRecords, particularCountries);

                break;
            case 3:
                mAverageDailyPosCase(covidRecords, particularCountries);

                break;
            case 4:
                mPercentageOfRecover(covidRecords, particularCountries);

                break;
            case 5:
                mPercentageOfDeceases(covidRecords, particularCountries);

                break;
            case 6:
                mAllStatistics(covidRecords, particularCountries);

                break;

            default:
                break;
        }
    }

    private static void mAllStatistics(List<CovidRecord> covidRecords, List<String> particularCountries) {
        mTotalCumPos(covidRecords, particularCountries);
        mTotalCumDecease(covidRecords, particularCountries);
        mTotalRecover(covidRecords, particularCountries);
        mAverageDailyPosCase(covidRecords, particularCountries);
        mPercentageOfRecover(covidRecords, particularCountries);
        mPercentageOfDeceases(covidRecords, particularCountries);

    }

    private static void mPercentageOfDeceases(List<CovidRecord> covidRecords, List<String> particularCountries) {
        long totalCumPos = 0;
        long totalCumDecease = 0;
        double percantage;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.getCountry();

            if (particularCountries.contains(country.getCountryName())) {
                totalCumPos += Long.parseLong(covidRecord.getCumulativePositive());
                totalCumDecease += Long.parseLong(covidRecord.getCumulativeDeceased());
            }

        }

       if (totalCumPos > 0 ) {
        percantage = (totalCumDecease * 100) / totalCumPos;
        System.out.println();

        System.out.println("Number and percentage of cumulatively positive cases deceases: " + percantage + "%");

       }

    }

    private static void mPercentageOfRecover(List<CovidRecord> covidRecords, List<String> particularCountries) {
        long totalCumPos = 0;
        long totalCumRecover = 0;
        double percantage;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.getCountry();

            if (particularCountries.contains(country.getCountryName())) {
                totalCumPos += Long.parseLong(covidRecord.getCumulativePositive());
                totalCumRecover += Long.parseLong(covidRecord.getCumulativeRecoverd());
            }

        }

       if (totalCumPos > 0 ) {
        percantage = (totalCumRecover * 100) / totalCumPos;
        System.out.println();

        System.out.println("Number and percentage of cumulatively positive cases recovered: " + percantage + "%");

       }


    }

    private static void mAverageDailyPosCase(List<CovidRecord> covidRecords, List<String> particularCountries) {
        double averageTotCurrentPos = 0;
        int count = 0;
        List<String> dayList = new ArrayList<>();
        int totalCurrentPos = 0;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.getCountry();
            if (particularCountries.contains(country.getCountryName())) {
                 if (!dayList.contains(covidRecord.getDate())) {
                    totalCurrentPos += Integer.parseInt(covidRecord.getCurrentlyPositive());

                dayList.add(covidRecord.getDate());
                count++;
            }
            }
           

        }
        if (count > 0) {
                    averageTotCurrentPos = totalCurrentPos / count;
    DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println();

        System.out.println("Average Total Curren positive: " + df.format(averageTotCurrentPos));
            
        }
  
    
    }

    private static void mTotalRecover(List<CovidRecord> covidRecords, List<String> particularCountries) {
        long totalCumRecover = 0;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.country;

            if (particularCountries.contains(country.countryName)) {
                totalCumRecover += Long.parseLong(covidRecord.cumulativeRecoverd);
            }
        }
        System.out.println();
        System.out.println("Total Cumalitive Recover Cases : " + totalCumRecover);

    }

    private static void mTotalCumDecease(List<CovidRecord> covidRecords, List<String> particularCountries) {
        long totalCumDecease = 0;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.country;

            if (particularCountries.contains(country.countryName)) {
                totalCumDecease += Long.parseLong(covidRecord.cumulativeDeceased);
            }
        }
        System.out.println();
        System.out.println("Total Cumalitive Decease Cases : " + totalCumDecease);
        // System.out.println();

    }

    private static void mTotalCumPos(List<CovidRecord> covidRecords, List<String> particularCountries) {
        long totalCumPos = 0;

        for (int i = 1; i < covidRecords.size(); i++) {
            CovidRecord covidRecord = covidRecords.get(i);
            Country country = covidRecord.country;

            if (particularCountries.contains(country.countryName)) {
                totalCumPos += Long.parseLong(covidRecord.cumulativePositive);
            }
        }
        System.out.println();
        System.out.println("Total Cumalitive positive Cases: " + totalCumPos);
        // System.out.println();

    }

    private static void mShowMenu1() {
        List<String> menuItems = Const.mGetMenu1();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println("> " + i + " " + menuItems.get(i));
        }
        System.out.println();
    }

    private static void mShowMenu2() {
        List<String> menuItems = Const.mGetMenu2();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println("> " + i + " " + menuItems.get(i));
        }
        System.out.println();

    }

    public static List<String> uniqCountry(List<CovidRecord> covidRecords) {

        List<String> list1 = new ArrayList<>();

        for (int index = 1; index < covidRecords.size(); index++) {
            CovidRecord covidRecord = covidRecords.get(index);
            Country country = covidRecord.country;
            if (!list1.contains(country.countryName)) {
                list1.add(country.countryName);

                // System.out.println(list1.get(0));
            }
        }
        /*
         * for (int index = 1; index < countries.size(); index++) {
         * Country country = countries.get(index);
         * if (!list1.contains(country.countryName)) {
         * list1.add(country.countryName);
         * // System.out.println(list1.get(0));
         * }
         * }
         */
        /*
         * for (int i = 0; i < list1.size(); i++) {
         * System.out.println(list1.get(i));
         * }
         */

        System.out.println();
        return list1;

    }

}