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

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r, int m, int n) {

        int[][]stripes = matrixStriper(matrix, m, n);

        int maxIter = Math.min(m, n)/2;

        for (int i = 0; i < maxIter; i++) {
            stripes[i]=shiftLeft(stripes[i], r);
        }


        int[][] arr = matrixReBuilder(stripes, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static int[][] matrixReBuilder(int[][] stripes, int m, int n){

        int minSize = Math.min(m, n);
        int maxIter = minSize/2;
        int [][] array = new int[m][n];

        for (int i = 0; i < maxIter; i++) {
            for (int j = 0; j < stripes[i].length; j++) {
                if(j<m-1-2*i){
                    array[i+j][i]=stripes[i][j];
                } else if (j<m-1-2*i+n-1-2*i){
                    array[m-1-i][i+j-(m-1-2*i)]=stripes[i][j];
                } else if (j<2*m-2-4*i+n-1-2*i){
                    array[m-1-(j-(m-1-2*i+n-1-2*i))-i][n-1-i]= stripes[i][j];
                } else {
                    array[i][n-1-i-(j-(2*m-2-4*i+n-1-2*i))]=stripes[i][j];
                }
            }
        }
        return array;
    }


    public static int[][] matrixStriper(List<List<Integer>> matrix, int m, int n){
        int maxSize = Math.max(m, n);
        int minSize = Math.min(m, n);
        int maxIter = minSize/2;

        int[][] stripes = new int[maxIter][];

        for (int i = 0; i < maxIter; i++) {
            stripes[i]=new int[2*maxSize+2*minSize-4];
            maxSize--;
            maxSize--;
            minSize--;
            minSize--;
        }

        for (int i = 0; i < maxIter; i++) {
            for (int j = 0; j < stripes[i].length; j++) {
                if(j<m-1-2*i){
                    stripes[i][j]=matrix.get(i+j).get(i);
                } else if (j<m-1-2*i+n-1-2*i){
                    stripes[i][j]=matrix.get(m-1-i).get(i+(j-(m-1-2*i)));
                } else if (j<2*m-2-4*i+n-1-2*i){
                    stripes[i][j]=matrix.get(m-1-(j-(m-1-2*i+n-1-2*i))-i).get(n-1-i);
                } else {
                    stripes[i][j]=matrix.get(i).get(n-1-i-(j-(2*m-2-4*i+n-1-2*i)));
                }

            }
        }


        return stripes;
    }


    public static int[] shiftLeft(int[] a, int shift) {
        if (a != null) {
            int length = a.length;
            shift%=length;
            shift=length-shift;
            int[] b = new int[length];
            // шаг 1
            System.arraycopy(a, shift, b, 0, length - shift);
            // шаг 2
            System.arraycopy(a, 0, b, length - shift, shift);
            return b;
        } else {
            return null;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r, m, n);

        bufferedReader.close();
    }
}
