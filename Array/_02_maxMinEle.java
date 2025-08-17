public class _02_maxMinEle{
    public static void main(String[]args){
        int[] arr = {10 , 2, 4, 32, 21};
        
        maxMin(arr);
        
        
    }
    public static void maxMin(int[]arr){
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }
        System.out.println(max+"  |||  "+min);
    }
}