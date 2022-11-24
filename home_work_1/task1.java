package home_work_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * task1
 */
public class task1 {

    public static void main(String[] args)throws IOException{
        //double a = 2;
        //double b = 2;
        // File read = new File("input.txt");
        // Scanner sc = new Scanner(read);
        // String a1 = sc.nextLine();
        // System.out.println(a1);
        // String b1 = sc.nextLine();
        // System.out.println(b1);
        //double sum = power_modul(a, b);
        //System.out.println(sum);
        // FileReader file = new FileReader("input.txt");
        // Scanner sc = new Scanner(file);
        // while(sc.hasNext()){
        //     int number = sc.nextInt();
        //     String word = sc.next();
        //     System.out.print(number);
        //     System.out.print(word);
        // }
        // sc.close();
        // file.close();
        // List<String> lines =Collections.emptyList();
        // try{
        //     lines = Files.readAllLines(Paths.get("input.txt"),StandardCharsets.UTF_8);
        // } catch(IOException e){
        //     e.printStackTrace();
        // }
        // System.out.println(lines);
        ArrayList<String> list =    new ArrayList<>();
        try(Scanner sc =    new Scanner(new File("input.txt"))){
            while(sc.hasNextLine()){
                list.add(sc.nextLine());
            }
        String[] array = list.toArray(new String[0]);
        //String a1=array[0];
        //String b1 = array[1];
        String[] a2 = array[0].split(" ");
        String[] b2 = array[1].split(" ");
        // System.out.println(a2[1]);
        // System.out.println(b2[1]);
        double a = Integer.parseInt(a2[1]);
        double b = Integer.parseInt(b2[1]);
        double sum = power_modul(a, b);
        System.out.print(a+"^"+b+" = "+sum+"\n");
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
        }else{
            for (int i = 0; i > b; i--) {
                power*=a;
            }
            power = 1/power;
        }

        return power;
    }
}