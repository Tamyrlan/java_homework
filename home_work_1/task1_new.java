package home_work_1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class task1_new {
 public static void main(String[] args)throws IOException {
    calculate_and_write();
 }
 static String[] read()throws IOException{
    ArrayList<String> list = new ArrayList<>();
    try(Scanner sc = new Scanner(new File("input.txt"))){
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
    String[] array = list.toArray(new String[0]);
    return array;
    }
    
 }
 static void calculate_and_write()throws IOException{
    String[] newArr = read();
    String [] a1 = newArr[0].split(" ");
    String [] b1 = newArr[1].split(" ");
    double a = Double.parseDouble(a1[1]);
    double b = Double.parseDouble(b1[1]);
    double sum = power_modul(a, b);
    if(sum==0){
        System.out.println("Не определено");
        FileWriter fw = new FileWriter("output.txt",false);
        fw.write("Не определено");
        fw.flush();
    }else{
    System.out.println(a+"^"+" "+b+" = "+sum);
    FileWriter fw = new FileWriter("output.txt",false);
    fw.write("Result:"+sum);
    fw.flush();
    System.out.println("Succesfully wrote to the file");
    }
 }
 static double power_modul(double a,double b){
    double power=1;
    if(b>0){
        for (int i = 1; i <=b; i++) {
            power*=a;
        }
    return power;
    }else if(a==0 && b==0){
        System.out.println("Не определено");
        return 0;
    }else{
        for (int i = 0; i > b; i--) {
            power*=a;
        }
        power = 1/power;
    }
    return power;
}
}
