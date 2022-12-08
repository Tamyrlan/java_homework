package home_work5;
import java.util.Scanner;
public class hw5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int num = sc.nextInt();
        sc.close();
        // createTriangle(num);
        int n = createTriangle(num);
        System.out.println();
        drawTriangle(n);
    }
    public static int createTriangle(int num){
        int tr = 0;
        if(num == (int) num && num > 0){
            tr = (num + 1) * num / 2;
            System.out.printf("%d - треугоьное число %d",num,tr); 
        }else{
            System.out.println("Вы ввели не правильное число");
        }
        return tr;
    }
    private static void drawTriangle(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
        System.out.println();
    }
}
}
