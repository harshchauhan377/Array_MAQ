public class _06_Longest_Substring_with_K_Uniques{
    public static void main(String[] args){
        String s1 = "aabacbebebe";
        int k1 = 3;
        System.out.println("Longest substring length (k=3) : " + longestKSubstr(s1, k1));
        // Expected Output = 7 ("cbebebe")
    }

    public static int longestKSubstr(String s, int k) {
        int n = s.length();

        int left = 0 ;
        int right = 0 ;
        int hash[] = new int[26];
        int count = 0 ;
        int max = Integer.MIN_VALUE ;

        while(right < n){

            int index = s.charAt(right) - 'a';

            if(hash[index]==0){
                hash[index]++;
                count++;
            }else{
                hash[index]++;
            }

            if(count==k){
                max = Math.max(max , right - left + 1);
            }

            
            while(count > k && left < right){
                index = s.charAt(left) - 'a';
                hash[index]--;

                if(hash[index]==0){
                    count--;
                }
                left++;
            }
            right++; 

        }

        return (max == Integer.MIN_VALUE ? -1 : max);
    }
}