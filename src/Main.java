import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        ArrayList<Integer> mainArray= new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть кількість елементів масиву - ");
        int count = in.nextInt();

        for(int i=0; i<count;i++){
            System.out.print("Array["+i+"]=");
            int tmp= in.nextInt();
            mainArray.add(tmp);
        }

        System.out.println("Масив до сортування:");

        for(int i=0; i<count;i++){
            System.out.print(mainArray.get(i)+" ");
        }

        ArrayList<Integer> arraySorted = AlgorithmOfMergeSort.splitArray(mainArray);
        System.out.println();
        System.out.println("Відсортований масив:");
        for(int i=0; i<arraySorted.size();i++){
            System.out.print(arraySorted.get(i)+" ");
        }

        arraySorted.clear();
        mainArray.clear();

    }
}
