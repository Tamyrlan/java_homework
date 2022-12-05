package home_work3;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        getArg();
    }

    public static int getNumber(String Number) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter int " + Number + ":");
        int a = sc.nextInt();
        return a;
    }
    public static void getArg(){
        int a = getNumber("a");
        int b = getNumber("b");
        System.out.println("Enter number for k1 command and k2 command");
        int c = getNumber("k1");
        int d = getNumber("k2");
        System.out.println("Let's see your numbers:");
        System.out.printf("a:%d, b:%d, c:(*%d), d:(+%d)\n", a, b, c, d);
        exception(a, b, c, d);
    }

    public static long[] steps(int a, int b, int c, int d) {
        long[] arr = new long[b + 1];
        arr[a] = 1;
        for (int i = 0; i <= b; i++) {
            if (i % c == 0 && i / c > 0) {
                arr[i] += arr[i / c];
            }
            if (i > a && i - d > 0) {
                arr[i] += arr[i - d];
            }
        }
        return arr;
    }

    public static void exception(int a ,int b, int c, int d){
        if(a > b){
            System.out.println("Wrong number of arguments, a can not be greater than b, please enter correct numbers!");
        } else{
            long[] arr = steps(a, b, c, d);
            long result = arr[b];
            System.out.printf("ways to turn %d to %d => %d",a,b,result);
            getMinPath(result, a, b, c, d);
        }
    }public static void getMinPath(long res,int a, int b ,int c, int d){
        String str = "";
        System.out.println("\n Min path:");
        if(res == 0){
            System.out.println("There is no solution :(");
        } else{
            while(b > a){
                if(b%c==0){
                    str+="(x" + c + ")";
                    b /= c;
                }else{
                    str+= "(+" + d + ")";
                    b -= d;
                }
            }
            System.out.println(str);
        }
    }
}
