package binary_search;

public class MemoryTest {

    public static void main(String[] args) {
        long before = Runtime.getRuntime().freeMemory();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2800000; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());

        long after = Runtime.getRuntime().totalMemory();
        System.out.println("free memory : " + before /1024/1024);
        System.out.println("after memory : " + after /1024/1024);
        System.out.println("used memory : " + (after - before)/1024/1024);
    }
}
