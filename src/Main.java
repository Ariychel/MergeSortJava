import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        ArrayList<Integer> mainArray= new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("Input count of elements - ");
        int count = in.nextInt();

        for(int i=0; i<count;i++){
            System.out.print("Array["+i+"]=");
            int tmp= in.nextInt();
            mainArray.add(tmp);
        }

        System.out.println("Array before sorting:");

        for(int i=0; i<count;i++){
            System.out.print(mainArray.get(i)+" ");
        }

        ArrayList<Integer> arraySorted = AlgorithmOfMergeSort.splitArray(mainArray);
        System.out.println();
        System.out.println("Array after sorting:");
        for(int i=0; i<arraySorted.size();i++){
            System.out.print(arraySorted.get(i)+" ");
        }

        arraySorted.clear();
        mainArray.clear();

    }
}
