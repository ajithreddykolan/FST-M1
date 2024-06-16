package Activities;

public class Activiyt8 {

    public static void main(String[] a){
        try {
            Activiyt8.exceptionTest("Will print to console");
            Activiyt8.exceptionTest(null); 
            Activiyt8.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
    
}
