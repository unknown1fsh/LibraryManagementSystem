import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {


        class ConvertArrayToList {
            public static void main(String[] args) {
                String[] stringArray = {"item 1", "item 2", "item 3", "item 4"};
                List<String> stringList = new ArrayList(Arrays.asList(stringArray));

                for (String listItem : stringList) {
                    System.out.println(listItem);
                }
            }
        }
    }
}
