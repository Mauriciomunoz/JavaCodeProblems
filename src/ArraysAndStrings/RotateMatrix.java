package ArraysAndStrings;

public class RotateMatrix {

    /**
     * Given an image represented by an NxN matrix, where each pixel in the images is 4 bytes,
     * write a method to rotate the image by 90 degrees. Can you do this in place?
     *
     * [0 1 1 0]
     * [0 1 0 0]
     * [0 1 1 0]
     * [0 0 1 0]
     *
     * [0 0 0 0]
     * [0 1 1 1]
     * [1 1 0 1]
     * [0 0 0 0]
     *
     * Matrix transpose
     * [0 0 0 0]
     * [1 1 1 0]
     * [1 0 1 1]
     * [0 0 0 0]
     *
     *
     *
     * Started: 8:38pm
     * Finished: 8:57pm
     *
     * @param args
     */

    public static void main(String[] args) {
/*
        int[][] image = new int[4][4];
        image[0][0] = 0;
        image[0][1] = 1;
        image[0][2] = 1;
        image[0][3] = 0;

        image[1][0] = 0;
        image[1][1] = 1;
        image[1][2] = 0;
        image[1][3] = 0;

        image[2][0] = 0;
        image[2][1] = 1;
        image[2][2] = 1;
        image[2][3] = 0;

        image[3][0] = 0;
        image[3][1] = 0;
        image[3][2] = 1;
        image[3][3] = 0;

        */
        int[][] image = new int[3][3];
        image[0][0] = 1;
        image[0][1] = 2;
        image[0][2] = 3;

        image[1][0] = 4;
        image[1][1] = 5;
        image[1][2] = 6;

        image[2][0] = 7;
        image[2][1] = 8;
        image[2][2] = 9;

        int[][] result = rotateMatrix(image);


    }

    //Time complexity: O(N^2)
    //Space complexity: O(N)
    //Using matrix transpose could improve the Space complexity
    private static int[][] rotateMatrix(int[][] image){
        int[][] rotated = new int[image.length][image.length];

        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image.length; j++){
                rotated[i][j] = image[image.length-1-j][i];
            }
        }

        return rotated;
    }

}
