import java.util.HashMap;
import java.util.HashSet;

public class EncoraTest {
/**
    This is a demo task.

    Write a function:

    fun solution(A: IntArray): Int

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
    Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/
    public static void main(String[] args) {

        //int[] A = {8,1,5,4,4,6,7,2};
        int[] A = {-1,-2,1,3};

        //solution(A);


        System.out.println(solution(A));
    }
/*
    Take value in A
    add it to inarray
    check if A[i] + 1 is in inArray
    if not add it to occ
    check if A[i] is in occur
    if it is remove it

 */

    static int solution(int[] A){

        int sol = 0;
        HashSet<Integer> inArray = new HashSet<>();
        HashSet<Integer> noOccurrences = new HashSet<>();

        for(int i = 0; i < A.length; i++){
            if(A[i] > 0) {
                if (!inArray.contains(A[i])) {
                    inArray.add(A[i]);
                    if (!inArray.contains(A[i] + 1)) {
                        noOccurrences.add(A[i] + 1);
                    }
                    if (noOccurrences.contains(A[i])) {
                        noOccurrences.remove(A[i]);
                    }
                }
            }
        }

        if(noOccurrences.isEmpty())
            sol = 1;
        else {
            sol = (int) noOccurrences.toArray()[0];
        }

        return sol;

    }


}

