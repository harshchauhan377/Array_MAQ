public class _06_KadaneAlgo_MaxSubArray{
    public static void main(String[]args){
        // Total subarray = n * (n + 1) / 2 

        int arr[]={-1, 4 , 3 , -2 , 3};
        System.out.print("MaxSumSubArray by Brute Force : "+bf(arr));

        System.out.print("\nMaxSumSubArray by Kadane Algorithm : "+KA(arr));

    }

    public static int bf(int[]arr ){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            int currSum = 0 ;
            for(int j = i ; j < n ; j++){
                currSum += arr[j];
                maxSum = Math.max(maxSum , currSum);
            }
        }

        return maxSum;
    }

    // Kadane Algorithm :- used to get the maxSum of array contaning both positive value and negative value  , its Tcomplexity is o(n) better than brutal force having TC of o(n)^2 .

    // what approch it follows is that if currSum become negative , it will turn currSum to zero and then start again with adding next Ele in CurrSum and start calculating and fiding maxuimum by comparing curr ele and maxEle and storing it into maxSum using Math.max
    public static int KA(int[]arr){
        int n = arr.length;

        int currSum = 0 ;
        int maxSum = 0 ;

        for(int i = 0 ; i < n ; i++){
            currSum+= arr[i];
            maxSum = Math.max(maxSum , currSum);

            if(currSum < 0){
                currSum = 0 ;
            }
        }
        return maxSum ;
    }
}