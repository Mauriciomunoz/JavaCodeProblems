import java.util.Arrays;

public class AwardBudgetCuts {


    public static void main(String[] args) {

        //double[] n = {2,100,50,120,1000}; // 190
        //double[] n = {14,15,16,17,18,19}; // 97
        double[] n = {2,100,50,120,167}; // 400

        System.out.println(findGrantsCap(n, 400));
    }

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // your code goes here

        double cap = newBudget / grantsArray.length;
        double budgetLeft = newBudget;

        Arrays.sort(grantsArray);

        for(int i = 0; i < grantsArray.length; i++){
            if(grantsArray[i] < cap){
                budgetLeft -= grantsArray[i];
                cap = budgetLeft / (grantsArray.length - 1 - i);
            }
        }

        return cap;

    }

}
