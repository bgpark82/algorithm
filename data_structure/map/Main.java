import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("age", 1);
        map.compute("age", (key, value) -> (value == null) ? 1 : value + 1);

        System.out.println(map);

        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println(entry.getKey());
            }
        }
    }

}
