import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int counter=0;
    static int counter1=0;

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr, int[]arr1) {

        int arrLength = arr.length;


        for (int i = 0; i < arrLength; i++) {
            swap(arr, min(arr, i, arrLength), i);
            swap1(arr1, max(arr1, i, arrLength), i);
        }
        return Math.min(counter, counter1);
    }

    static void swap(int[] arr, int a, int b){
        if(a!=b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            counter++;
        }
    }

    static void swap1(int[] arr, int a, int b){
        if(a!=b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            counter1++;
        }
    }

    static int min(int[] arr, int beginIndex, int endIndex){
        int temp=arr[beginIndex];
        int index=beginIndex;
        for (int i = beginIndex+1; i < endIndex; i++) {
            if(arr[i]<temp){
                temp=arr[i];
                index=i;
            }
        }
        return index;
    }

    static int max(int[] arr, int beginIndex, int endIndex){
        int temp=arr[beginIndex];
        int index=beginIndex;
        for (int i = beginIndex+1; i < endIndex; i++) {
            if(arr[i]>temp){
                temp=arr[i];
                index=i;
            }
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];
        int[] arr1 = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arr1[i] = arrItem;
        }

        int result = lilysHomework(arr, arr1);

        System.out.println(result);
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
