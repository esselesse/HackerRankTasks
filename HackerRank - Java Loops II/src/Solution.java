import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        int a, b, n, tempCounter, result;
        for(int i=0; i<q; i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            tempCounter =0;
            result = a;
            for (int j = 0; j < n; j++) {
                result += ( (int)Math. pow(2, tempCounter))*b;
                tempCounter++;
                System.out.print(result + " ");
            }
            System.out.println();
        }
        in.close();
    }
}

