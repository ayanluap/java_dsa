import java.util.*;

// Sort an array using recursion

public class SortArrayRecursion {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0; i<n; i++) {
            int t=sc.nextInt();
            arr.add(t);
        }

        recurSort(arr);

        System.out.print(arr);

    }
    
    public static void recurSort(ArrayList<Integer> arr){
        // bc
        if(arr.size()==1) return;

        // Hypothesis [Faith rkh bhai result ka chinta mt kr]
        int lastElem=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        recurSort(arr);

        // Induction [Isse kaam kra Hypothesis result dedega]
        recurInsert(arr, lastElem);
    }

    public static void recurInsert(ArrayList<Integer> arr, int last){
        // BC
        if(arr.size()==0 || arr.get(arr.size()-1)<=last) {
            arr.add(last);
            return;
        }

        // hypothesis
        int lastVal=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        recurInsert(arr, last);

        // induction
        arr.add(lastVal);
        return;
    }
}
