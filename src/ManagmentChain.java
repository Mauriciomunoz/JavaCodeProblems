import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ManagmentChain {

    /**
     *
     * Create a class with methods where you receive two values as <Employee_id><Manager_id>
     *
     * Resolve:
     * IsManager(id1, id2): Returns true if id1 is manager of id2
     * IsInManagmentChain(id1, id2): Returns true if id1 is above id2 in the managment chain
     *      3 -> 4 -> 5 -> 1 || IsInManagmentChain(4,1) true, because 4 is manager of 5 and 5 is manager of 1
     * GetSubemployees(id): Return all the employees belowe the id
     */

    public static void main(String[] args) {

        MySystemHR myhr = new MySystemHR();

        String[] employees = {"2,1", "7,1", "3,2", "6,2", "4,3", "5,3", "9,7", "8,9", "10,9", "8,6"};

        myhr.fillDatabase(employees);

        System.out.println("IS MANAGER " + myhr.isManager(1,7));
        System.out.println("IS IN MANAGMENT " + myhr.isInManagmentChain(7,6));
        ArrayList<Integer> result = myhr.getSubemployees(2);

        System.out.println("DONE");

    }


    static class MySystemHR{
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        public void fillDatabase(String[] employees){
            for(int i = 0; i < employees.length; i++){
                String str = employees[i];
                String[] aux = str.split(",");
                int idManager = Integer.parseInt(aux[1]);
                int idEmployee = Integer.parseInt(aux[0]);

                ArrayList<Integer> auxEmployess = new ArrayList<>();

                if(hm.containsKey(idManager)){
                    auxEmployess = hm.get(idManager);
                    auxEmployess.add(idEmployee);
                    hm.put(idManager,auxEmployess);
                }else{
                    auxEmployess.add(idEmployee);
                    hm.put(idManager,auxEmployess);
                }

            }

        }

        public boolean isManager(int id1, int id2){
            ArrayList<Integer> aux = hm.get(id1);

            if(aux != null){
                return aux.contains(id2);
            }

            return false;
        }

        public boolean isInManagmentChain(int id1, int id2){
            Stack<Integer> myStack = new Stack<>();

            myStack.push(id1);

           while(!myStack.isEmpty()){
               int id = myStack.pop();
               ArrayList<Integer> aux = hm.get(id);
               if(aux != null) {
                   for (int i = 0; i < aux.size(); i++) {
                       if (aux.get(i) == id2)
                           return true;
                       myStack.push(aux.get(i));
                   }
               }else{
                   return false;
               }
           }

            return false;
        }

        public ArrayList<Integer> getSubemployees(int id){
            Stack<Integer> myStack = new Stack<>();
            ArrayList<Integer> result = new ArrayList<>();

            myStack.push(id);

            while(!myStack.isEmpty()){
                int idAux = myStack.pop();
                ArrayList<Integer> aux = hm.get(idAux);
                if(aux != null) {
                    for (int i = 0; i < aux.size(); i++) {
                        result.add(aux.get(i));
                        myStack.push(aux.get(i));
                    }
                }
            }

            return result;
        }
    }


}
