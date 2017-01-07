/**
 * Created by david on 12/24/2016.
 */
public class StringRotation_1_8 {

    public static void main(String[] args) {
        System.out.println(isStringRotation("war", "raw"));
    }

    static boolean isStringRotation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String doubles1 = s1 + s1;
            return doubles1.contains(s2);
        } else {
            return false;
        }
    }
}
