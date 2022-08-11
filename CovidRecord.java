import java.util.ArrayList;

public class CovidRecord {
    
    String date;
    String cumulativePositive;
    String cumulativeDeceased;
    String cumulativeRecoverd;
    String currentlyPositive;

    String hospitalized;
    String intensiveCare;
    Country country; 

    CovidRecord(String date, String cumulativePositive, String cumulativeDeceased, String cumulativeRecoverd,
    String currentlyPositive, String hospitalized, String intensiveCare, Country country) {
                this.date = date;
                this.cumulativePositive = cumulativePositive;
                this.cumulativeDeceased = cumulativeDeceased;
                this.cumulativeRecoverd = cumulativeRecoverd;
                this.currentlyPositive = currentlyPositive;
                this.hospitalized = hospitalized;
                this.intensiveCare = intensiveCare;
                this.country = country;
    }

    public String getDate() {
        return date;
    }
    public String getCumulativePositive() {
        return cumulativePositive;
    }
    public String getCumulativeRecoverd() {
        return cumulativeRecoverd;
    }
    public String getCurrentlyPositive() {
        return currentlyPositive;
    }
    public String getCumulativeDeceased() {
        return cumulativeDeceased;
    }
    public Country getCountry() {
        return country;
    }

    public void uniqDate(String[] Date) {

        ArrayList<String> list1 = new ArrayList<>();

        for (String str1 : Date) {
            if (!list1.contains(str1)) {
                list1.add(str1);
            }

        }

        for (String str1 : list1) {
            System.out.println(str1);
        }

    }

}