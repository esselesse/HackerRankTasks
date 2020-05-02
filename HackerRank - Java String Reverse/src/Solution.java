import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        int fullLen = A.length();
        int length = fullLen/2;
        for (int i = 0; i < length; i++) {
            if(A.charAt(i)!=A.charAt(fullLen-1-i)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}