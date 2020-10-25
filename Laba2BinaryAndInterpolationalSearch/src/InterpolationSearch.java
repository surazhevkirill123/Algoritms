import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {
    public static void interpolationSearch(int[] array,int first,int last,int item) {

        int position;
        int comparisonCount = 0;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (first + ((last-first)*(item - array[first])/(array[last]-array[first])));
        System.out.println(first+"+"+(last-first)+"*"+(item - array[first])+"/"+(array[last]-array[first])+"="+position);

        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число больше заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + ((last-first)*(item - array[first])/(array[last]-array[first])));
            System.out.println(position);
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
    public static void main(String...args){
        int[]array= InitOfRandomArray.InitOfRandomArray(10000,100000);
        int num, item, first, last;
        num=array.length;
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));


        // вводим элемент для бинарного поиска
        System.out.println("Введите элемент для бинарного поиска: ");
        Scanner input = new Scanner(System.in);
        item = input.nextInt();

        // определяем последний и начальный индекс
        first = 0;
        last = num - 1;

        // метод принимает начальный и последний индекс, а также число для поиска
        interpolationSearch(array, first, last, item);
    }
}