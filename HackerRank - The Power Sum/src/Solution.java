import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int resultGlobal=0;
    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        int[] mass = new int[(int)(Math.pow(X, 1D/N))];
        for (int i = 0; i < mass.length; i++) {
            mass[i]=i+1;
        }

        int temp=0;
        powerSumRecurseCall(X, N, 0, mass, temp);




        return resultGlobal;
    }

    static void powerSumRecurseCall(int X, int N, int iterator, int[] mass, int temp){
        if(temp>X)
            return;
        int temp1;
        for (; iterator < mass.length; iterator++) {
            temp1=temp;
            //powerSumRecurseCall(X, N, iterator+1, mass, temp);
            temp1+=(int)Math.pow(mass[iterator], N);
            if(X-temp1==0){
                resultGlobal++;
            }
            else if(temp1>X){
                return;
            }
            else{
                powerSumRecurseCall(X, N, iterator+1, mass, temp1);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);
        System.out.println(result);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
