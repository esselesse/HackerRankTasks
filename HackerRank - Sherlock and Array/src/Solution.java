import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {

        int len = arr.size();

        int sumLow = 0;
        int sumHigh = 0;


        int iteratorHigh = len-1;
        int iteratorLow = 0;

//1 1 0 2 1 1

        while (iteratorHigh>iteratorLow) {
            if(sumHigh+arr.get(iteratorHigh)<=sumLow){
                sumHigh+=arr.get(iteratorHigh--);
                continue;
            }else if(sumHigh+arr.get(iteratorHigh)>sumLow+arr.get(iteratorLow)){
                sumLow+=arr.get(iteratorLow);
                iteratorLow++;
                continue;
            }
            sumHigh+=arr.get(iteratorHigh--);

        }

        if(sumHigh==sumLow)
            return "YES";

        return "NO";


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
