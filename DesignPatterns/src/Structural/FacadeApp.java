package Structural;

/**
 * Facade pattern hides the complexities of the system
 * and provides an interface to the client using
 * which the client can access the system.
 * @author Fenix
 */

public class FacadeApp {

    public static void main(String[] args) {

//        Power power = new Power();
//        power.turnOn();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer{
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.turnOn();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power{

    void turnOn(){
        System.out.println("Turn on power");
    }

    void turnOff(){
        System.out.println("Turn off power");
    }
}

class DVDRom{
    private boolean data = false;

    public boolean hasData(){
        return data;
    }

    void load(){
        data = true;
    }

    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Copying data from the disc");
        }
        else {
            System.out.println("Insert the disc with the data");
        }
    }
}