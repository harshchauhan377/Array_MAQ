import java.util.HashMap;
public class _03_MajorityEle{
    public static void main(String[] args) {
        int arr[]={3,3,4,2,3,3,3};
        System.out.println("find majority ele : "+findmajority(arr));

        System.out.println("\nmajority ele by Moor's Voting : "+majEle(arr));
    }

    
    //hashing
    public static int findmajority(int [] arr){
        int n = arr.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);

            if(map.get(ele)>n/2){
                return ele;
            }
        }
        return -1;
    }


    // Moore's voting 
    // - find the candidate might be majority ele 
    // - count the candidate more acur than arr.length / 2 ;
    public static int majEle(int arr[]){
        int candidate = arr[0];
        int count = 1 ;

        for(int i = 1 ; i< arr.length ; i++){
            if(arr[i]==candidate){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    candidate = arr[i];
                    count = 1 ;
                }
            }
        }

        count = 0 ;
        for(int num : arr){
            if(num  == candidate){
                count++;
            }
        }

        if(count > arr.length / 2){
            return candidate;
        }else{
            return -1;
        }
    }

}