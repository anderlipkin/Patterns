package сreational.builder;

public class BuilderApp {

    public static void main(String[] args) {
        CarDirector director = new CarDirector(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car.toString());
    }
}

enum Transmission{
    MANUAL, AUTO
}

/*
 * Represents the product created by the builder
 */
class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make){
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [make = " + make + ", transmission = "
                + transmission + ", maxSpeed = " + maxSpeed + "]";
    }
}

abstract class CarBuilder {
    Car car;
    Car build(){
        return car;
    }

    abstract CarBuilder buildMake();
    abstract CarBuilder buildTransmission();
    abstract CarBuilder buildMaxSpeed();
}

class FordMondeoBuilder extends CarBuilder {

    public FordMondeoBuilder(){
        car = new Car();
    }

    public CarBuilder buildMake() {
        car.setMake("Ford Mondeo");
        return this;
    }

    public CarBuilder buildTransmission() {
        car.setTransmission(Transmission.AUTO);
        return this;
    }

    public CarBuilder buildMaxSpeed() {
        car.setMaxSpeed(220);
        return this;
    }
}

class SubaruBuilder extends CarBuilder {

    public SubaruBuilder(){
        car = new Car();
    }

    public CarBuilder buildMake() {
        car.setMake("Subaru");
        return this;
    }

    public CarBuilder buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
        return this;
    }

    public CarBuilder buildMaxSpeed() {
        car.setMaxSpeed(250);
        return this;
    }
}

class CarDirector {
    private CarBuilder builder;

    public CarDirector(final CarBuilder builder){
        this.builder = builder;
    }

    Car buildCar(){
        return builder.buildMake()
                    .buildTransmission()
                    .buildMaxSpeed()
                    .build();
    }
}