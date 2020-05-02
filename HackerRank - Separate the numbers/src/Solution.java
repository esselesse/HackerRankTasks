import java.util.Scanner;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        int capacity = 1; //разрядность
        int len = s.length();//длина строки
        if(len<=1){
            System.out.println("NO");
            return;
        }
        long[] mass = new long[len];//массив чисел, на которые делим
        String tempstr;//переменная, в которую пихаем кусочки строки и парсим числа
        int iterator;//указатель на место в строке, с которого считавем
        int massIterator;//указатель на элемент массива, для которого сейчас будет парс кусочка строки
        boolean flag=false;//флаг для определения, изменилась ли разрядность в ходе вычисления строки
        boolean flag1=false;//флаг для определения, откуда мы вышли из общего цикла
        boolean flagNO=true;//заглугшка-флаг, который определяет, сказали ли мы YES, и если да, то запрещает говорить NO
        long strlen=0;//заглушка-измерялка длины изученной строки. сравнивает с длиной изучаемой строки после выполнения цикла. если длины не совпали - NO

        for (capacity = 1; capacity < len/2+1; capacity++) {
            strlen=0;
            iterator=0;
            massIterator=0;
            //кладем первый элемент в массив
            tempstr=s.substring(iterator, iterator+capacity);
            if(tempstr.charAt(0)=='0'){
                break;
            }
            strlen+=tempstr.length();
            mass[massIterator]=Long.parseLong(tempstr);
            massIterator++;
            iterator+=capacity;
            flag=true;
            flag1=false;
            while (iterator+capacity <= len) {
                tempstr = s.substring(iterator, iterator + capacity);
                if(tempstr.charAt(0)=='0'){
                    flag1=true;
                    break;
                }
                strlen+=tempstr.length();
                mass[massIterator] = Long.parseLong(tempstr);
                if(flag && mass[massIterator]-mass[massIterator-1]!=1) {
                    capacity++;
                    strlen-=tempstr.length();
                    if(iterator+capacity>len){
                        flag1=true;
                        break;
                    }
                    flag = false;
                    continue;
                }
                else if (!flag && mass[massIterator]-mass[massIterator-1]!=1) {
                    capacity--;
                    flag1=true;
                    break;
                }
                iterator+=capacity;
                massIterator++;
            }
            if(!flag1 && strlen==len) {
                System.out.println("YES " + mass[0]);
                flagNO = false;
                break;
            }
        }
        if(flagNO){
            System.out.println("NO");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
