
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class _04_Chocolate_Distribution_Problem{

    public static void main(String[]args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50));
        int k = 7;
        System.out.println("Minimum difference is: " + distributeChocolates(arr, k));
    }

    public static int distributeChocolates(ArrayList<Integer> arr, int m) {
        if (m == 0 || arr.size() == 0) return 0;  
        if (arr.size() < m) return -1; 
        
        Collections.sort(arr);
        int n = arr.size();
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0 ; i <= n - m ; i++){
            int min = arr.get(i);
            int max = arr.get(i + m - 1);
            ans = Math.min(ans , max - min);
        }
        
        return ans;
    }
}