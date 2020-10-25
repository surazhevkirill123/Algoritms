import java.util.Arrays;

public class InsertionSort {
    public static void InsertionSort(int[]array, int low, int high){
        int n = high+1;//1
        for (int i = low; i < n; ++i) {//3*(n-low)
            int key = array[i];//2
            int j = i - 1;//2

            /* Перемещаем элементы arr [0..i-1], которые
                больше ключа, на одну позицию впереди
                своего текущего положения */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];//3
                j = j - 1;//2
            }
            array[j + 1] = key;//2
        }

    }

    public static void InsertionSortWithCountOfOperations(int[]array, int low, int high){
        int n = high+1;//1
        int countOfOperations=1;
        for (int i = low; i < n; ++i) {//3*(n-low)
            countOfOperations+=3;
            int key = array[i];//2
            int j = i - 1;//2
            countOfOperations+=2;
            /* Перемещаем элементы arr [0..i-1], которые
                больше ключа, на одну позицию впереди
                своего текущего положения */
            while (j >= 0 && array[j] > key) {
                countOfOperations+=3;
                array[j + 1] = array[j];//3
                j = j - 1;//2
                countOfOperations+=5;
            }
            array[j + 1] = key;//2
            countOfOperations+=2;
        }
        System.out.println(countOfOperations+" операций");

    }

    public static void main(String...args){
        int[]array= InitOfRandomArray.InitOfRandomArray(100,100);
        System.out.println(Arrays.toString(array));
        InsertionSortWithCountOfOperations(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }


}
