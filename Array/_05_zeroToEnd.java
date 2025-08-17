public class _02_zeroToEnd{
    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeroes(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
    public static void moveZeroes(int arr[]){
        int n = arr.length;
        int j = 0;
        for(int i =0 ; i<n ; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp ;
                j++;
            }
        }
    }
}