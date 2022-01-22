package beginning;

public class Sorting {
    public static void main(String args[]){
        int arr[]={7,8,3,1,2};

        ///// BUBBLE SORT ~ O(n^2)
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.print("\nBubble Sort : ");
        for(int x: arr) System.out.print(x+" ");
        System.out.println("\n");

        ///// SELECTION SORT ~ O(n^2)
        for(int i=0; i<arr.length-1; i++){
            int min=i;
            for(int j=i+1; j<arr.length-1; j++){
                if(arr[min] > arr[j]) {
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        System.out.print("Selection Sort : ");
        for(int x: arr) System.out.print(x+" ");
        System.out.println("\n");

        ///// INSERTION SORT ~ O(n^2)
        for(int i=1; i<arr.length; i++){
            int elem=arr[i];
            int j=i-1;
            while(j>=0 && elem < arr[j]){
                arr[j+1]=arr[j];
                j--;
            }

            // placement of element
            arr[j+1]=elem;
        }
        System.out.print("Intertion Sort : ");
        for(int x: arr) System.out.print(x+" ");
        System.out.println("\n");


    }
}
