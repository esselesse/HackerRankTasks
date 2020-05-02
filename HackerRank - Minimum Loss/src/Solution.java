import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void quickSort(long[] mass, int a, int b){
        if(a>=b) return;

        int index = partition(mass, a, b);
        quickSort(mass, a, index);
        quickSort(mass,index+1, b);
    }

    public static int partition(long[] mass, int a, int b){
        int tempIndex = a+(b-a+1)/2;
        long mid = mass[tempIndex];
        int i = a, j = b;
        while (i<=j){
            while(mass[i]<mid) {
                i++;
            }
            while(mass[j]>mid) {
                j--;
            }
            if(i<=j) {
                swap(mass, i++, j--);
            }
        }
        return j;
    }

    private static void swap(long[] mass, int j, int i) {
        long temp = mass[j];
        mass[j]=mass[i];
        mass[i]=temp;
    }

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {
        int len = price.length;
        Map<Long, Integer> indexer = new HashMap<Long, Integer>();
        for (int i = 0; i < len; i++) {
            indexer.put(price[i], i);
        }
        quickSort(price, 0, len-1);
        long diff=price[1]-price[0];

        for (int i = 2; i < len; i++) {
            if(indexer.get(price[i])-indexer.get(price[i-1])>0) {
                if (diff > price[i-1] - price[i] && price[i-1] - price[i] >= 0) {
                    diff = price[i-1] - price[i];
                }
            }
            else {
                if (diff > price[i] - price[i-1] && price[i] - price[i-1] >= 0) {
                    diff = price[i] - price[i-1];
                }
            }
        }

    return (int)diff;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
