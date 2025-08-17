
import java.util.HashMap;

public class _01_twoSum {

    public static void main(String[] args) {
        int arr[] = {9, 7, 11, 2};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println("The two numbers indexes are: " + result[0] + " and " + result[1]);

    
    
    }

    public static int[] twoSum(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
