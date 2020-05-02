
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        if(n==0)
            return;

        if(n==1) {
            //System.out.println(arr.toString());
            System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
            return;
        }

        int temp = arr[n-1];

        if(n==2){
            if(arr[0]>arr[1]){
                arr[1]=arr[0];
                arr[0]=temp;
            }
            System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
            return;
        }

        int iterator = n-2;
        arr[iterator+1]=arr[iterator];

        while(arr[iterator]>temp && iterator-1>=0){
            System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
            arr[iterator]=arr[iterator-1];
            iterator--;
        }
        if(arr[iterator]>temp) {
            System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
            arr[iterator] = temp;
        }
        else
            arr[iterator+1]=temp;
        System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
