import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            freqMap.merge(s.charAt(i), 1, (m, n) -> m+n);
        }
        
        Map<Integer, Integer> countList = new HashMap<Integer, Integer>();

        Iterator<Integer> iter = freqMap.values().iterator();

        while (iter.hasNext())
            countList.merge(iter.next(), 1, (m, n) -> m+n);

        if(countList.values().size()>2)
            return "NO";
        else if(countList.values().size()==2){
            iter = countList.keySet().iterator();
            int key1 = iter.next();
            int key2 = iter.next();

            if(countList.get(key1)>1 && countList.get(key2)>1)
                return "NO";

            if ((key1==1 && countList.get(key1)==1) || (countList.get(key2)==1 && key2==1))
                return "YES";

            if (key2-key1==1){
                if(countList.get(key2)==1)
                    return "YES";
                else
                    return "NO";
            }

            if (key1-key2==1){
                if(countList.get(key1)==1)
                    return "YES";
                else
                    return "NO";
            }


            return "NO";
        }

        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String s = scanner.nextLine();

        String result = isValid(s);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
