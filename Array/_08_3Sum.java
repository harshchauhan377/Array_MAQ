import java.util.*;
public class _08_3Sum{
    public static void main(String[] args) {
        int arr[] = {1, 2, -2, 0, -1, 1};
        int target = 0;

        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);

        List<List<Integer>> result1 = threeSumm(arr);
        System.out.println(result1);
    }

    // brute force 
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i + 1 ; j < n -1 ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer>list = new ArrayList<>( Arrays.asList( nums[i],nums[j],nums[k] ) );
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
        
    }

    public static List<List<Integer>> threeSumm(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < n-2 ; i++){
            if( i>0 && nums[i]==nums[i-1] ) continue;

            int left = i+1 ; 
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}