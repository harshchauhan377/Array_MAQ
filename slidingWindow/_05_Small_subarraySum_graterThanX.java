public class _05_Small_subarraySum_graterThanX{
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 19};
        int x = 51;

        System.out.println("Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\nTarget (x) = " + x);

        // Test brute force
        int brute = smallestSubWithSum(x, arr);
        System.out.println("Smallest subarray length (Brute Force) = " + brute);

        // Test sliding window
        int swAns = sw(x, arr);
        System.out.println("Smallest subarray length (Sliding Window) = " + swAns);
    }

    // brute force TC : O(n)^2
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i<arr.length ; i++){
            int sum = 0 ;
            for(int j = i ; j <arr.length ; j++){
                sum += arr[j];
                if(sum>x){
                    min = Math.min(min ,j-i+1);
                    break;
                }
            }
        }
        
        return (min==Integer.MAX_VALUE ? 0 : min);
    }

    public static int sw(int x, int[] arr) {
        int n = arr.length;
        int left = 0 ;
        int right = 0 ;
        int sum = 0 ;
        int min = Integer.MAX_VALUE;
        
        
        while(right < n){
            sum += arr[right];
            
            while(sum > x){
                min = Math.min(min ,right - left + 1);
                sum-=arr[left];
                left++;
            }
            right++;
        }
         return (min==Integer.MAX_VALUE ? 0 : min);
    }
}