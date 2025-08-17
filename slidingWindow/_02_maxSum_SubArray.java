import java.util.ArrayList;
import java.util.Arrays;
public class _02_maxSum_SubArray{
    public static void main(String[] args) {
        // Test data
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        // Brute force
        int bruteForceAns = maxSumSubarraySizeK(arr, k);
        System.out.println("Brute Force Max Sum (int[]): " + bruteForceAns);

        // Convert array to ArrayList<Integer>
        ArrayList<Integer> nums = new ArrayList<>();
        for (int val : arr) nums.add(val);

        // Sliding Window
        long slidingWindowAns = sw(k, nums);
        System.out.println("Sliding Window Max Sum (ArrayList): " + slidingWindowAns);
    }

    // brute force tC : O(n * K)
    public static int maxSumSubarraySizeK(int[] arr, int k) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // sliding window
    public static long sw(int k , ArrayList<Integer>nums){
        int  n = nums.size();
        if(n < k) return -1;
        long maxSum = 0 ;
        long sum = 0 ;
        
        int index = 0 ;
        while(index < n && index < k){
            sum += nums.get(index);
            index++;
        }

        for(int i = 1  ; i <= n-k ; i++){
            int prev = nums.get(i-1);
            int next = nums.get(i+1);

            sum = sum - prev + next;
            maxSum = Math.max(maxSum , sum);
        }
        return maxSum ;

    }

}