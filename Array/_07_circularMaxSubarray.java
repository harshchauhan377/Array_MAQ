public class _07_circularMaxSubarray{
    public static void main(String[]args){
        int arr[]={8 , -1 , 3, 4};
        System.out.println("Circular Max Subarray is : "+maxSubarray(arr));

    }

    public static int kadaneMax(int arr[]){
        int n = arr.length;
        int max = arr[0];
        int currMax = arr[0];

        for(int i = 1 ; i < n ; i++){
            currMax = Math.max(currMax + arr[i] , arr[i]);
            max = Math.max(max , currMax);
        }
        return max;
    }

    public static int kadaneMin(int arr[]){
        int n = arr.length;
        int min = arr[0];
        int currMin = arr[0];

        for(int i = 1 ; i < n ; i++){
            currMin = Math.min(currMin + arr[i] , arr[i]);
            min = Math.min(min , currMin);
        }
        return min;
    }

    public static int maxSubarray(int arr[]){
        int maxKadane = kadaneMax(arr);
        if(maxKadane < 0){
            return maxKadane;
        }

        int minKadane = kadaneMin(arr);
        int totalSum = 0 ;
        for(int num : arr){
            totalSum+=num;
        }

        int maxWrap = totalSum - minKadane;
        return Math.max(maxKadane , maxWrap);
    }
}