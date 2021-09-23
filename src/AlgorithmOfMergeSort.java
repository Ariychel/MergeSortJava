import java.util.ArrayList;

public class AlgorithmOfMergeSort {
    public static ArrayList<Integer> splitArray(ArrayList<Integer> array) {
        if (array == null) { // Check if array not null
            return null;
        }
        if (array.size() < 2) { // Check if array has got more elements than one
            return array;
        }

        ArrayList<Integer> firstTmpArray = new ArrayList<Integer>(); /* Create a temporary array in which the first
        half of the main array will be stored */
        for(int i=0;i<array.size()/2;i++){ // Copying first half of array
            firstTmpArray.add(array.get(i));
        }

        ArrayList<Integer> secondTmpArray = new ArrayList<Integer>();/* Create a temporary array in which the second
        half of the main array will be stored */
        for(int i=firstTmpArray.size(); i<array.size(); i++){// Copying second half of array
            secondTmpArray.add(array.get(i));
        }
        //Enter temporary arrays in recursion that there were many arrays on two elements
        splitArray(firstTmpArray);
        splitArray(secondTmpArray);

        mergeArray(array, firstTmpArray, secondTmpArray); //after finish recursion send data to another method

        return array; // return sorted array
    }

    private static void mergeArray(ArrayList<Integer> array, ArrayList<Integer> firstTmpArray, ArrayList<Integer> secondTmpArray) {

        int posFirstTmpArray = 0, posSecondTmpArray = 0;

        for (int i = 0; i < array.size(); i++) {
            if (posFirstTmpArray == firstTmpArray.size()) {
                array.set(i, secondTmpArray.get(posSecondTmpArray));
                posSecondTmpArray++;
            } else if (posSecondTmpArray == secondTmpArray.size()) {
                array.set(i, firstTmpArray.get(posFirstTmpArray));
                posFirstTmpArray++;
            } else if (firstTmpArray.get(posFirstTmpArray) < secondTmpArray.get(posSecondTmpArray)) {
                array.set(i, firstTmpArray.get(posFirstTmpArray));
                posFirstTmpArray++;
            } else {
                array.set(i, secondTmpArray.get(posSecondTmpArray));
                posSecondTmpArray++;
            }
        }
    }
}

