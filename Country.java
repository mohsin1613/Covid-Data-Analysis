import java.util.ArrayList;

public class Country {

    public static int i;
    String iso3;
    String continent;
    String countryName;
    String nuts;
    String lat;
    String longg;

    Country (String iso3, String continent, String countryName, String nuts, 
    String lat, String longg){
        this.iso3 = iso3;
        this.continent = continent;
        this.countryName = countryName;
        this.nuts = nuts;
        this.lat = lat;
        this.longg = longg;
    }

    public String getContinent() {
        return continent;
    }
    public String getCountryName() {
        return countryName;
    }public static int getI() {
        return i;
    }public String getIso3() {
        return iso3;
    }public String getLat() {
        return lat;
    }public String getLongg() {
        return longg;
    }public String getNuts() {
        return nuts;
    }

    public void uniqIso3(String[] Iso3) {

        ArrayList<String> list1 = new ArrayList<>();

        for (String str1 : Iso3) {
            if (!list1.contains(str1)) {
                list1.add(str1);
            }

        }

        for (String str1 : list1) {
            System.out.println(str1);
        }

    }

    public void uniContinent(String[] Continent) {

        ArrayList<String> list2 = new ArrayList<>();

        for (String str1 : Continent) {
            if (!list2.contains(str1)) {
                list2.add(str1);
            }

        }

        for (String str1 : list2) {
            System.out.println(str1);
        }

    }


    

    public void uniqNuts(String[] nuts) {

         ArrayList<String>list1=new ArrayList<>();
      
          
        for (String str1 : nuts) {
            if (!list1.contains(str1)) {
                list1.add(str1);
            }
           
        }
        
        for(String str1:list1){
            System.out.println(str1);
        }
        
        
    }
    
    
    
    

}