import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String temp = "";
        boolean flag1, flag;
        int substrCount = s.length()-k+1;
        smallest = largest = s.substring(0, k);
        for (int i = 1; i < substrCount; i++) {
            temp = s.substring(i, i+k);
            flag = flag1 = false;

            for (int j = 0; j < k; j++) {
                if(!flag && smallest.charAt(j)>temp.charAt(j)){
                    //если вдруг мелкий оказался в каком-то аспекте больше, то заменяем мелкого
                    smallest=temp;
                    flag = true;
                } else if (!flag && smallest.charAt(j)<temp.charAt(j)){
                    //иначе же если он был меньше, то сразу забиваем - он точно меньше
                    flag = true;
                }

                if(!flag1 && largest.charAt(j)<temp.charAt(j)){
                    largest=temp;
                    flag = true;
                } else if (!flag1 && largest.charAt(j)>temp.charAt(j)){
                    flag1 = true;
                }

                if(flag && flag1){
                    break;
                }
            }

        }



        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}