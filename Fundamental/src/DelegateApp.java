/**
 * Created by Fenix on 06.02.2017.
 */
public class DelegateApp {

    public static void main(String[] args) {

        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());

        painter.draw();
    }
}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("Draw triangle");
    }
}

class Square implements Graphics{
    public void draw() {
        System.out.println("Draw square");
    }
}

class Circle implements Graphics{
    public void draw() {
        System.out.println("Draw circle");
    }
}

class Painter {
    Graphics graphics;

    void setGraphics(Graphics g){
        graphics = g;
    }

    void draw(){
        graphics.draw();
    }
}



