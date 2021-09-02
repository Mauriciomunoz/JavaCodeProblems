package HackerRank.DictionariesAndHashMaps.Medium;

import java.io.*;
import java.util.*;

/**
 *
 * You are given  queries. Each query is of the form two integers described below:
 * -  1x: Insert x in your data structure.
 * -  2y: Delete one occurence of y from your data structure, if present.
 * -  3z: Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
 *
 * The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element.
 *
 * https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 *
 *
 */
public class FrequencyQueries {

    public static void main(String[] args) {

      /*  List<List<Integer>> queries = new ArrayList<>();//{{1,1}, {2,2}, {3,2}, {1,1}, {1,1}, {1,1}, {2,1}, {3,2}};
        List<Integer> element = new ArrayList<>();
        element.add(1);
        element.add(3);
        queries.add(element);
        element = new ArrayList<>();
        element.add(2);
        element.add(3);
        queries.add(element);
        element = new ArrayList<>();
        element.add(3);
        element.add(2);
        queries.add(element);
        element = new ArrayList<>();
        element.add(1);
        element.add(4);
        queries.add(element);
        element = new ArrayList<>();
        element.add(1);
        element.add(5);
        queries.add(element);
        element = new ArrayList<>();
        element.add(1);
        element.add(5);
        queries.add(element);
        element = new ArrayList<>();
        element.add(1);
        element.add(4);
        queries.add(element);
        element = new ArrayList<>();
        element.add(3);
        element.add(2);
        queries.add(element);
        element = new ArrayList<>();
        element.add(2);
        element.add(4);
        queries.add(element);
        element = new ArrayList<>();
        element.add(3);
        element.add(2);
        queries.add(element);*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = 0;
        try {
            q = Integer.parseInt(bufferedReader.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = new String[0];
            try {
                queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> ocurrencies = new HashMap<>();
        HashMap<Integer, Integer> ocurrenciesNumber = new HashMap<>();

        for(int i = 0; i < queries.size(); i++){
            int instruction = queries.get(i).get(0);
            int value = queries.get(i).get(1);
            if(instruction == 1){
                insertValue(value, ocurrencies, ocurrenciesNumber);
            }else{
                if(instruction == 2){
                    removeValue(value, ocurrencies, ocurrenciesNumber);
                }else{
                    if(ocurrenciesNumber.getOrDefault(value, 0) > 0){
                        result.add(1);
                    }else{
                        result.add(0);
                    }
                }
            }

        }

        return result;

    }

    static void insertValue(int value, HashMap<Integer, Integer> occurrencies, HashMap<Integer, Integer> ocurrenciesNumber){

        int oc = occurrencies.getOrDefault(value, 0);
        occurrencies.put(value, oc + 1);

        int qt = ocurrenciesNumber.getOrDefault(oc, 0);
        ocurrenciesNumber.put(oc, qt - 1);
        int qt2 = ocurrenciesNumber.getOrDefault(oc + 1, 0);
        ocurrenciesNumber.put(oc + 1, qt2 + 1);


        /*
        int oc = 1;
        if(occurrencies.containsKey(value)){
            oc = occurrencies.get(value);

            if(ocurrenciesNumber.containsKey(oc)){
                int ocNum = ocurrenciesNumber.get(oc);
                ocurrenciesNumber.put(oc, ocNum - 1);
            }

            occurrencies.put(value, oc + 1);

            if(ocurrenciesNumber.containsKey(oc + 1)){
                int ocNum = ocurrenciesNumber.get(oc + 1);
                ocurrenciesNumber.put(oc + 1, ocNum + 1);
            }else{
                ocurrenciesNumber.put(oc + 1, 1);
            }

        }else{
            occurrencies.put(value, 1);

            if(ocurrenciesNumber.containsKey(1)){
                int ocNum = ocurrenciesNumber.get(1);
                ocurrenciesNumber.put(1, ocNum + 1);
            }else{
                ocurrenciesNumber.put(1, 1);
            }
        }
*/
    }

    static void removeValue(int value, HashMap<Integer, Integer> occurrencies, HashMap<Integer, Integer> ocurrenciesNumber){

        int oc = occurrencies.getOrDefault(value, 0);
        if(oc == 0)
            return;

        if(oc == 1)
            occurrencies.remove(value);
        else{
            occurrencies.put(value, oc - 1);
        }

        int qt = ocurrenciesNumber.getOrDefault(oc, 0);
        ocurrenciesNumber.put(oc, qt - 1);
        int qt2 = ocurrenciesNumber.getOrDefault(oc - 1, 0);
        ocurrenciesNumber.put(oc - 1, qt2 + 1);



        /*
        if(occurrencies.containsKey(value)){
            int oc = occurrencies.get(value);

            if(ocurrenciesNumber.containsKey(oc)){
                int ocNum = ocurrenciesNumber.get(oc);
                ocurrenciesNumber.put(oc, ocNum - 1);
            }

            occurrencies.put(value, oc - 1);

            if(ocurrenciesNumber.containsKey(oc - 1)){
                int ocNum = ocurrenciesNumber.get(oc - 1);
                ocurrenciesNumber.put(oc - 1, ocNum + 1);
            }
        }*/
    }


}
