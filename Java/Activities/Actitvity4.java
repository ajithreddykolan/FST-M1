package Activities;

public class Actitvity4 {

    public static void main(String []arg){

        int[] array={4,2,3,5,22,3,7,1,9};
        System.out.println("before loop: ");
        for(int x:array){
            System.out.println(x);
        }
        
        for(int i=0;i<=array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp;
                    temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
        System.out.println("after loop: ");
        for(int x:array){
            System.out.println(x);
        }
    }
}
