import java.util.Arrays;
/*
* 1.Сортируемый массив разбивается на две части примерно одинакового размера.
  2.Каждая из получившихся частей сортируется отдельно.
  3.Два получившихся упорядоченных массива соединяются в один.
  * При этом наименьший из первых элементов двух массивов записывается в результирующий массив,
  * и эта операция повторяется, пока не закончатся элементы в этих двух массивах.
* */

public class MergeSort {

    public static void MergeSort(int a[],int low,int high,int k)
    {
        if(high<=1)
            return;
        int mid=low + (high - low) / 2;
        int left[]=new int[mid];
        int right[]=new int[high-mid];
        for(int i=low;i<mid;i++)
            left[i]=a[i];
        for(int i=mid;i<high;i++)
            right[i-mid]=a[i];

        if(mid-low<k) {
            InsertionSort.InsertionSort(left,low,mid-1);
        }
        else {
            MergeSort(left,low,mid,k);
        }

        if(high-mid-low<k) {
            InsertionSort.InsertionSort(right,low,high-mid-1);
        }
        else {
            MergeSort(right,low,high-mid,k);
        }
        Merge(left,right,a);

    }
    public static void Merge(int left[],int right[],int a[])
    {
        int nL=left.length;
        int nR=right.length;
        int i,j,k;
        i=j=k=0;
        while(i<nL&&j<nR)
        {
            if(left[i]<=right[j])
            {
                a[k]=left[i];
                i++;
                k++;
            }
            else
            {
                a[k]=right[j];
                j++;
                k++;
            }
        }
        while(i<nL)
        {
            a[k]=left[i];
            i++;
            k++;
        }
        while(j<nR)
        {
            a[k]=right[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[]array= InitOfRandomArray.InitOfRandomArray(1000,1000);
        System.out.println(Arrays.toString(array));
        MergeSort(array,0,array.length-1,4);
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
                MergeSort(arrayOfArrays2[k1], low, high, k);
                for(int i=0;i<countOfArrays;i++)
                    for (int j=0;j<arrayLength;j++)
                        arrayOfArrays2[i][j]=arrayOfArrays[i][j];
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
