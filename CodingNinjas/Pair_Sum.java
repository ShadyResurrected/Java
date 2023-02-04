import java.util.*;
class Main {
  public static void main(String[] args) {
    int s = 4;
    int[] arr = {2, -6, 2 ,5 ,2};
    System.out.println(pairSum(arr,s));
  }
      static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < arr.length; i++){
            int target = s - arr[i];
            int[] mid = new int[2];
            Arrays.fill(mid,Integer.MIN_VALUE);
            for(int j = i;j < arr.length; j++){
                if(target == arr[j]){
                    mid[0] = arr[i];
                    mid[1] = arr[j];
                    Arrays.sort(mid);
                    if(!(mid[0] == Integer.MIN_VALUE && mid[1] == Integer.MIN_VALUE)) list.add(mid);
                }
            }
        }

        Collections.sort(list,new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                    if (a[0]== b[0])
                        return 0;
                    else if (a[0] > b[0])
                        return 1;
                    else
                        return -1;
            }
        });

        return list;
    }
}