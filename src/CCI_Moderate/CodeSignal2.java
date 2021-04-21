package CCI_Moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeSignal2 {


    public static void main(String[] args) {

        int[][] a = {{3,3, 4, 2},{4, 4},{4, 0, 3, 3},{2, 3},{3, 3, 3}};

        int[][] result = meanGroups(a);
        System.out.println(result);

    }

    static int[][] meanGroups(int[][] a) {
        //mean is the average value of each array
        //sort using the first element (?)

        int average = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> myList;

        for(int i = 0; i < a.length; i++){
            int[] aux = a[i];
            average = 0;
            for(int j = 0; j < aux.length; j++){
                average = average + aux[j];
            }
            average = average / aux.length;
            myList = new ArrayList<>();
            if(!hm.containsKey(average)){
                myList.add(i);
                hm.put(average, myList);
            }else{
                myList = hm.get(average);
                myList.add(i);
                hm.put(average, myList);
            }
        }

        //ArrayList<int[]> meanGroups = new ArrayList<>();
        int[][] means = new int[hm.size()][];
        int iterator = 0;

        for(Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()){
            int key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();

            int[] arrayValues = new int[value.size()];
            for(int m = 0; m < value.size(); m++){
                arrayValues[m] = value.get(m);
            }

            iterator = arrayValues[0];
            means[iterator] = arrayValues;
            //meanGroups.add(arrayValues);

        }



        return means;

    }

}
