package home_work2;

import java.util.Random;
import java.util.Scanner;

public class task2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = sc.nextInt();
        int[] array = CreatArray(10, 190, size);
        //int[] array = new int[]{15,78,89,9,12,12546,8,879,16,54,1};
        System.out.println(arrayToString(array));
        array=mergeSort(array);
        System.out.println(arrayToString(array));
        
    }
    public static int[] mergeSort(int[]array){
        int[] tmp;
        int[] currentarr = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while(size<array.length){
            for (int i = 0; i < array.length; i+=2*size) {
                merge(currentarr,i,currentarr,i+size,currentDest,i,size);
            }
            tmp = currentarr;
            currentarr = currentDest;
            currentDest = tmp;
            size = size*2;

            System.out.println(arrayToString(currentarr));
            }
            return currentarr;
        }

    private static void merge(int[] src1,int src1Start, int[] src2,int src2Start,int[] dest,int destStart,int size){
        int index1 = src1Start;
        int index2 = src2Start;
        int src1End = Math.min(src1Start+size,src1.length);
        int src2End = Math.min(src2Start+size,src2.length);
        if(src1Start +size>src1.length){
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }
        int iterationCount = src1End-src1Start+src2End-src2Start;
        for (int i = destStart; i < destStart+iterationCount; i++) {
            if(index1<src1End && (index2>=src2End || src1[index1]<src2[index2])){
                dest[i] = src1[index1];
                index1++;
            }else{
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
    private static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if(i>0){
                sb.append(",");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    public static int[] CreatArray(int min, int max, int size)
    {
        int [] array = new int [size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array [i] = random.ints(min, max).findFirst().getAsInt();
        }

        return array;
    }
    }
 
