public class SameValueAndIndex {

    public static void main(String[] args) {

        //int[] arr = {0,2,4,3};
        int[] arr = {-1,0,1,2};
        //int[] arr = {-8,-5,-3,0,1,5};

        System.out.println(findValue(arr));
    }

    public static int findValue(int[] arr){

        return helper(arr, 0, arr.length - 1);

    }

    public static int helper(int[] arr, int start, int end){
        int pivot = (start + end) / 2;

        if(arr[pivot] == pivot){
            return pivot;
        }

        if(start == end)
            return -1;

        if(arr[pivot] > pivot){ // Left
            return helper(arr, start, pivot);
        }else{ //Right
            return helper(arr, pivot + 1, arr.length - 1);
        }

    }
}
