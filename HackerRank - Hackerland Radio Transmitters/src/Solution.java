import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    public static void quickSort(int[] mass, int a, int b){
        if(a>=b) return;

        int index = partition(mass, a, b);
        quickSort(mass, a, index);
        quickSort(mass,index+1, b);
    }

    public static int partition(int [] mass, int a, int b){
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

    private static void swap(int[] mass, int j, int i) {
        int temp = mass[j];
        mass[j]=mass[i];
        mass[i]=temp;
    }



    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {

        int len = x.length;
        quickSort(x, 0, len-1);

        int count = 0;
        int iterator = 0;
        int iteratorLow = 0;
        int iteratorHigh = 0;

        while (iterator<len){
            while (iterator<len && x[iterator]-k<=x[iteratorLow]){
                iterator++;
            }
            if(iterator==len || x[iterator]-k>x[iteratorLow])
                iterator--;

            iteratorHigh=iterator;
            while (iteratorHigh<len && x[iteratorHigh]-k<=x[iterator]){
                iteratorHigh++;
            }
            if(iteratorHigh==len || x[iteratorHigh]-k>x[iterator])
                iteratorHigh--;

            count++;
            iterator=iteratorHigh+1;
            iteratorLow=iteratorHigh=iterator;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
