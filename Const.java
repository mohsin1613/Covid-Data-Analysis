import java.util.ArrayList;
import java.util.List;

public class Const {

    static List<String> mGetMenu1(){
        List<String> menu1 = new ArrayList<>();
        String[] s = {"All countries", "Countries in South America", "Countries in North America", "Countries in Oceania", "Countries in Asia", "Countries in Africa", "Countries in Europe", "Enter a Country", "Enter a Date"};

        for (int i = 0; i < s.length; i++) {
            menu1.add(s[i]);
        }

        return menu1;
    }
    
    static List<String> mGetMenu2(){
        List<String> menu2 = new ArrayList<>();
        String[] s = {"Total number of cumulatively positive cases", "Total number of cumulatively deceased cases", "Total number of cumulatively recovered cases", "Average daily number of currently positive cases", "Number and percentage of cumulatively positive cases recovered", "Number and percentage of cumulatively positive cases deceased", "All of the above statistics"};

        for (int i = 0; i < s.length; i++) {
            menu2.add(s[i]);
        }

        return menu2;
    }
}
