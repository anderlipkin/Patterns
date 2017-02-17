package Creational;

/**
 *  The intent in employing the pattern is to insulate the creation
 *  of objects from their usage and to create families of related
 *  objects without having to depend on their concrete classes.
 */
public class AbstractFactoryApp {

    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.prinln();
        t.track(10,50);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dblclick();
    void scroll(int direction);
}

interface Keyboard {
    void print();
    void prinln();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements Mouse{

    public void click() {
        System.out.println("Щелчок мышью");
    }

    public void dblclick() {
        System.out.println("Двойной щелчок мышью");
    }

    public void scroll(int direction) {
        if(direction > 0)
            System.out.println("Скроллим верх");
        else if (direction < 0)
            System.out.println("Скроллим вниз");
        else
            System.out.println("Не скроллим");
    }
}

class RuKeyboard implements Keyboard {
    public void print() {
        System.out.print("Печатаем строку");
    }

    public void prinln() {
        System.out.println("Печатаем строку с переводом строки");
    }
}

class RuTouchpad implements Touchpad {

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}


class EnMouse implements Mouse{

    public void click() {
        System.out.println("Mouse click");
    }

    public void dblclick() {
        System.out.println("Mouse double click");
    }

    public void scroll(int direction) {
        if(direction > 0)
            System.out.println("Scroll Up");
        else if (direction < 0)
            System.out.println("Scroll Down");
        else
            System.out.println("No scrolling");
    }
}

class EnKeyboard implements Keyboard {
    public void print() {
        System.out.print("Print");
    }

    public void prinln() {
        System.out.println("Print line");
    }
}

class EnTouchpad implements Touchpad {

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
        System.out.println("Moved " + s + " pixels");
    }
}

class EnDeviceFactory implements DeviceFactory {

    public Mouse getMouse() {
        return new EnMouse();
    }

    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}

class RuDeviceFactory implements DeviceFactory {

    public Mouse getMouse() {
        return new RuMouse();
    }

    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}