import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] array, int low, int high,int k) {

        if(high-low<k) {
            InsertionSort.InsertionSort(array, low, high);
        }
        else{


        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j )
        {
            if (j-low<k)
                InsertionSort.InsertionSort(array, low, j);
            else
                quickSort(array, low, j,k);
        }


        if (high > i)
        {
            if (high-i<k)
                InsertionSort.InsertionSort(array, i, high);
            else
                quickSort(array, i, high,k);
        }


        }
        return array;
    }
    public static void main(String[] args) {
        int[]array= InitOfRandomArray.InitOfRandomArray(100,10000);
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1,4);
        System.out.println(Arrays.toString(array));

        int countOfArrays=10;
        int arrayLength=1000;
        int randomRound=100;


        int[][]arrayOfArrays = new int[countOfArrays][arrayLength];
        for (int i=0;i<countOfArrays;i++) {
            arrayOfArrays[i]=InitOfRandomArray.InitOfRandomArray(arrayLength,randomRound);
        }

        int[][]arrayOfArrays2 = new int[countOfArrays][arrayLength];
        for(int i=0;i<countOfArrays;i++)
            for (int j=0;j<arrayLength;j++)
                arrayOfArrays2[i][j]=arrayOfArrays[i][j];

        int low = 0;
        int high = arrayLength - 1;

        long optimalTime=System.nanoTime();
        int optimalK=0;
        for (int k=0;k<arrayLength;k++) {
            long start = System.nanoTime();
            for (int k1=0;k1 <countOfArrays;k1++) {
                for(int i=0;i<countOfArrays;i++)
                    for (int j=0;j<arrayLength;j++)
                        arrayOfArrays2[i][j]=arrayOfArrays[i][j];
                quickSort(arrayOfArrays2[k1], low, high, k);
            }
            long finish = System.nanoTime();
            long timeConsumedNanos = finish - start;
            if (timeConsumedNanos<optimalTime)
            {
                optimalTime=timeConsumedNanos;
                optimalK=k;
            }
            System.out.println("k= "+k+" Время: "+timeConsumedNanos);
        }
        System.out.println("оптимальное k= "+optimalK+" оптимальное время: "+optimalTime);

    }
}
