package Activities;

public class Car {

    String color;
    String  transmission;
    int make;
    int tyre;
    int doors;

    public Car(){
        tyre=4;
        doors=4;
    }

    public void displayCharacteristics(){
        System.out.println(color);
        System.out.println(transmission);
        System.out.println(make);
        System.out.println("no of tyres"+tyre);
        System.out.println("no of doors"+doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    }

    public void brake(){
        System.out.println("Car has stopped.");
    }

}
