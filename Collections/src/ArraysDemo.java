import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ArraysDemo {
    public static void main(String[] args) {


        Integer[] arr = {1, 5, 3, 2, 5};

        Integer[] brr = {5, 2, 3, 4, 1};

        int[] crr = {1, 2, 3 , 4};



        // sorting the arrays
        Arrays.sort(arr);

        // prints the address of the array
        System.out.println(crr.hashCode());

        System.out.println(crr);

        // prints the array in string format
        System.out.println(Arrays.toString(crr));

        System.out.println(arr);

        int arrKeyIndex = Arrays.binarySearch(arr, 4);
        int brrKeyIndex = Arrays.binarySearch(brr, 4);


        // returns the index if the array is sorted
        // if the array is sorted, the key doesn't exist -> -(upper_bound(key) + 1)
        // else -(arraySize + 1)
        System.out.println("arr: " +  arrKeyIndex);

        // return -(arraySize + 1) if the key doesn't exist
        // unsorted list -> index is unpredictable
        System.out.println("brr: " + brrKeyIndex);

        // Converting array into list


        // fails if arr is declared int[] arr
        // immutable list, throws exception on arrList.add(23);
        List<Integer> arrList = Arrays.asList(arr);

        // immutable list, throws exception on     // brrList.add(5);
        List<Integer> brrList = List.of(brr);


        Integer[] integerArray = arrList.toArray(Integer[]::new);

        System.out.println(integerArray.toString());






        System.out.println(arrList);

        System.out.println(brrList);



        // lists


        List<String> colorsList = Arrays.asList("Red", "Orange", "Green", "Yellow");

//        ArrayList<String> colorsList  = new ArrayList<>();
//
//        colorsList.add("Red");
//        colorsList.add("Orange");

        String[] colorsArray =  colorsList.toArray(String[]::new);

        System.out.println(Arrays.toString(colorsArray));

        System.out.println(colorsArray.getClass().getName());


    }
}
