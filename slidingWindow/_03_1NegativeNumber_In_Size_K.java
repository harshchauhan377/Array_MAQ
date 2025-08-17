import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class _03_1NegativeNumber_In_Size_K{
    public static void main(String[]args){
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        bf(arr, arr.length, k);

        sl(arr , arr.length , k);

        slOptimise(arr , arr.length , k);


    }

    // brute force tC : N * K 
    public static void bf(int[]arr , int n , int k){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<=n-k ; i++){
            boolean found = false;

            for(int j = i ; j < i+k ; j++){
                if(arr[j]< 0 ){
                    ans.add(arr[j]);
                    found = true;
                    break;
                }
            }

            if(!found){
                ans.add(0);
            }
            
        }

        System.out.println(ans);
    }


    // by Sliding window and Queue for TC : O(N)
    public static void sl(int[]arr , int n , int k){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // for first window 
        int index = 0 ;
        while(index < k){
            if(arr[index] < 0){
                q.offer(arr[index]);
            }
            index++;
        }

        if(!q.isEmpty()){
            ans.add(q.peek());
        }else{
            ans.add(0);
        }

        // for rest of array , by adding deleting ele to mainatain window 
        for(int i = 1 ; i <= n - k  ; i++){

            // if q is having -ve ele , then remove 
            if(arr[i-1] < 0){
                q.poll();
            }

            // by adding -ve ele in queue 
            if( arr[i + k -1 ] < 0 ){
                q.offer(arr[i+k-1]);
            }

            // by adding -ve ele in ans , if q is not empty
            if(!q.isEmpty()){
                ans.add(q.peek());
            }else{
                ans.add(0);
            }

        }

        System.out.println(ans);
    }


    // same just can conter duplicate value by storing index not ele in queue
    public static void slOptimise(int[]arr , int n , int k){        
        List<Integer>ans = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        
        int index = 0 ;
        while(index < k){
            if(arr[index]<0){
                q.offer(index);
            }
            index++;
        }
        
        ans.add( q.isEmpty() ? 0 : arr[q.peek()] );
        
        for(int i = k ; i < n ; i++){
            // remove
            if( !q.isEmpty() && q.peek() == i - k ){
                q.poll();
            }
            // add 
            if(arr[i] < 0){
                q.offer(i);
            }
            
            ans.add( q.isEmpty() ? 0 : arr[q.peek()] );
        }
        
        System.out.println(ans);
    }

}