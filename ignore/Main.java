import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String[], Double> hashMap = new HashMap<String[], Double>();
        String[] arguments = {"FIRE", "WATER"};
        hashMap.put(arguments, 0.5);
        System.out.println(hashMap.get(arguments));
    }
}
