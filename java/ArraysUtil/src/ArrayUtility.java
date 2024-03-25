
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayUtility {
    public static void main(String[] args) {
        int[] nums = { 12, 23, 45, 78, 2 };

        //Search
        System.out.println(Arrays.binarySearch(nums, 45));

        //String representation of an array
        System.out.println(Arrays.toString(nums));

        //array to list
        List<Integer> list = Arrays.asList(1,23,56,67);
        System.out.println(list.toString());

        //create copy of an array
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(numsCopy));

        //create copy of a range of an array
        int[] subArrayCopy = Arrays.copyOfRange(nums, 1, 4);
        System.out.println(Arrays.toString(subArrayCopy));

        //Array comparison
        System.out.println(Arrays.equals(nums, numsCopy));
        System.out.println(Arrays.equals(nums, subArrayCopy));

        //replace array items with a value
        Arrays.fill(subArrayCopy, 1);
        System.out.println(Arrays.toString(subArrayCopy));

        //generate hash code from array items
        System.out.println(Arrays.hashCode(nums));

        //sort array ascending
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
