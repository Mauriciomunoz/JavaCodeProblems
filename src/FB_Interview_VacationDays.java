import java.util.*;

public class FB_Interview_VacationDays {


    /**
     * Calendar with holidays
     * Number of PTOs
     *
     * schedule = {F, T, T, F, F, T, T, T , T};
     * PTO = 1
     *
     *     B  F
     * {T, T, T, F, F, T, T, T, T};
     *
     * PTO = 1
     * Result = 3
     *
     * {T, T, T, T, F, T, T, T, T};
     *
     * @param args
     */

    public static void main(String[] args) {

        boolean[] schedule = {false, true, true, false, false, true, true, true , true};
        int pod = 1;

        System.out.println(maxVacation(schedule, pod));
    }


    public static int maxVacation(boolean[] schedule, int pod){
        int best_length = 0;
        int start = 0;
        int end = 0;
        int length = 0;

        Stack<Integer> pods = new Stack<>();

        while (end < schedule.length){
            if(schedule[end] == true){
                end++;
            }else{
                if(pod > 0){
                    pod--;
                    end++;
                    pods.add(end);
                }else{
                    length = end - start;
                    if(length > best_length){
                        best_length = length;
                    }
                    start = pods.pop();
                    pod++;
                }
            }
        }
        length = end - start;
        if(length > best_length){
            return length;
        }else{
            return best_length;
        }
    }

}
