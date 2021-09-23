import java.util.ArrayList;

public class AlgorithmOfMergeSort {
    public static ArrayList<Integer> splitArray(ArrayList<Integer> array) {
        if (array == null) { // Перевірка чи масив не пустий
            return null;
        }
        if (array.size() < 2) { // Перевірка чи у масиві не один елемент
            return array;
        }

        ArrayList<Integer> firstTmpArray = new ArrayList<Integer>(); /* Створення тимчасового масива, в якому
        буде зберігатись перша половина основго масиву */
        for(int i=0;i<array.size()/2;i++){ // Копіювання першої половини масиву
            firstTmpArray.add(array.get(i));
        }

        ArrayList<Integer> secondTmpArray = new ArrayList<Integer>();/* Створення тимчасового масива, в якому
        буде зберігатись друга половина основго масиву */
        for(int i=firstTmpArray.size(); i<array.size(); i++){// Копіювання другої половини масиву
            secondTmpArray.add(array.get(i));
        }
        //Треба занести тимчасові масиви у рекурсію функції, щоб у кінці було багато масивів по одному елементі
        splitArray(firstTmpArray);
        splitArray(secondTmpArray);

        mergeArray(array, firstTmpArray, secondTmpArray); //Після завершення розділення викликається функція зливання

        return array; // повернення відсортованого масиву
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

