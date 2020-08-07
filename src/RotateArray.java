public class RotateArray {
    public static void main(String[] args) {

        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        //int[] nums={-1,-100,3,99};
        //int k=2;
        //int[] nums={1,2,3,4,5};

        //int[] nums={7,6,4,3,1};
        //int[] nums={7,1,5,3,6,4};

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {

        if(nums.length>1 && nums.length>=k) {
            int[] temp = new int[k];
            int aux = 0;

            for (int i = nums.length - k; i < nums.length; i++) {
                temp[aux] = nums[i];
                aux++;
            }

            for (int j = nums.length - 1; j >= k; j--) {
                nums[j] = nums[j - k];
            }


            for (int m = 0; m < temp.length; m++) {
                nums[m] = temp[m];
            }
            System.out.println(nums);
        }
    }

    public static void rotate2(int[] nums, int k) {

        int i=0;
        int count=0;
        int enter=0;
        int out=0;
        enter=nums[i];
        while(count<nums.length){

            if(i+k>=nums.length){
                out=nums[i-k-(k%2)];
                nums[i-k-(k%2)]=enter;
                i=i-k-(k%2);
            }else {
                out = nums[i + k];
                nums[i+k]=enter;
                i+=k;
            }
            enter=out;
            count++;
        }

        System.out.println(nums);
    }
}
