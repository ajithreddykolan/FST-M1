package Activities;

public class Activity2 {

        public static void main(String []arg){

            int [] array={10, 77, 10, 54, -11, 10};
            int count=0,temp;
            for(int x:array){
                if(x==10){
                    count++;   
                } 
            }
            System.out.println(count);
            
            temp=count*10;
            if(temp==30){
                System.out.println("Value is eqaul to 30");
            }else{
                System.out.println("value is not 30");
            }
        }
}
