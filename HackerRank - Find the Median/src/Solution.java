import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findMedian function below.
    static int findMedian(int[] arr) {
        quickSort(0, arr.length-1, arr);

        return arr[arr.length/2];
    }


    public static void quickSort(int a, int b, int[] arr){
        if(a>=b) return;

        int index = partition(a, b, arr);
        quickSort(a, index, arr);
        quickSort(index+1, b, arr);
    }

    public static int partition(int a, int b, int[] arr){
        int tempIndex = a+(b-a+1)/2;
        int mid = arr[tempIndex];
        int i = a, j = b;
        while (i<=j){
            while(arr[i]<mid) {
                i++;
            }
            while(arr[j]>mid) {
                j--;
            }
            if(i<=j) {
                swap(i++, j--, arr);
            }
        }
        return j;
    }

    private static void swap(int j, int i, int[] arr) {
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
