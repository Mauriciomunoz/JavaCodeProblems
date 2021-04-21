package EasyProblems;

public class MaximumSubarray {
    public static void main(String[] args) {

        int[] n = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray2(n));
    }


    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int[] auxArray = new int[nums.length];

        for(int j = 0; j < nums.length; j++) {

            int aux = maximum(nums, auxArray,  nums.length - 1, j);
            max = Math.max(max, aux);
        }

        return max;
    }


    public static int maximum(int[] nums, int[] aux, int i, int j){
        if(i == j) {
            aux[i] = nums[i];
            return nums[i];
        }

        int auxMax =  maximum(nums, aux,i - 1, j);
        aux[i] = nums[i] + aux[i - 1];

        return Math.max(auxMax, aux[i]);

    }

    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }
}
