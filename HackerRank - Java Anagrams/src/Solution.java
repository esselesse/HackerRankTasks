import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        int aLength = a.length(), bLength = b.length();
        if(aLength!=bLength){
            return false;
        }

        java.util.Map<Character, Integer>[] anagramMap = new java.util.Map[2];
        anagramMap[0] = new java.util.HashMap<Character, Integer>();
        anagramMap[1] = new java.util.HashMap<Character, Integer>();
        for (int i = 0; i < aLength ; i++) {
            anagramMap[0].merge(Character.toLowerCase(a.charAt(i)), 1, (m, n) -> m + n);
            anagramMap[1].merge(Character.toLowerCase(b.charAt(i)), 1, (m, n) -> m + n);
        }

        aLength = anagramMap[0].size();
        bLength = anagramMap[1].size();


        if (aLength!=bLength){
            return false;
        }

        bLength = a.length();

        for (int i = 0; i < bLength; i++) {
            if(!(anagramMap[0].containsKey(Character.toLowerCase(a.charAt(i)))
                    && anagramMap[1].containsKey(Character.toLowerCase(a.charAt(i)))
                    && anagramMap[0].get(Character.toLowerCase(a.charAt(i))).equals(anagramMap[1].get(Character.toLowerCase(a.charAt(i)))))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}