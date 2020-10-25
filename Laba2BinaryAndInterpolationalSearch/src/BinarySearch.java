import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]) {
        int num, item, first, last;

        // инициализируем массив
        int[]array=InitOfRandomArray.InitOfRandomArray(100000,1000000);
        num=array.length;
        System.out.println(Arrays.toString(array));

        // сортируем элементы массива, так как для бинарного поиска
        // элементы массива должны быть отсортированными
        // и выводим его
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
        binarySearch(array, first, last, item);
    }

    // бинарный поиск
    // Поиск происходит путем деления элементов массива на половины.
    // Сравнивая средний элемент с числом для поиска, мы сдвигаем last или first, и меняем на их основе position, то есть середину
    public static void binarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 0;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число больше заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
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
}
