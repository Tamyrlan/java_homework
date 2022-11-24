package home_work_1;
import java.io.Reader;

import javax.naming.spi.DirStateFactory.Result;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * task1
 */
public class task1 {

    public static void main(String[] args) {
        double a = 2;
        double b = 7;
        double sum = Math.pow(a, b);
        try(FileWriter fw = new FileWriter("output.txt",false)){
            fw.write("Result:"+sum);
            System.out.println("Succesfully wrote to the file");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}