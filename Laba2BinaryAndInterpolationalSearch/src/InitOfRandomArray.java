import java.util.Arrays;

public class InitOfRandomArray {
    public static int[] InitOfRandomArray(int arrayLength,int randomRound){
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * randomRound);
        }
        return array;
    }


    public static void main(String...args){
        int[]array=InitOfRandomArray(10,10);
        System.out.println(Arrays.toString(array));
    }
}
