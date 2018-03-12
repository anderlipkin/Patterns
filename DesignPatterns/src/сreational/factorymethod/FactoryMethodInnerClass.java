package сreational.factorymethod;

import java.util.Date;
import java.util.Random;

/**
 * Определяет интерфейс для создания объекта (WatchMaker),
 * но оставляет подклассам (DigitalWatchMaker, RomeWatchMaker) решение о том, какой класс инстанцировать.
 * Фабричный метод позволяет классу делегировать создание подклассов.
 * @author Fenix
 */
public class FactoryMethodInnerClass {

    public static void main(String[] args) {
        String[] randMaker = new String[]{"Digital", "Rome"};
        WatchMaker maker = getMakerByName(
                randMaker[new Random().nextInt(2)]);

        Watch watch = maker.createWatch();
        watch.showTime();
    }

    private static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return DigitalWatch2.watchMaker;
        else if(maker.equals("Rome"))
            return RomeWatch2.watchMaker;

        throw new RuntimeException("Production line of watches is not supported: " + maker);
    }

}

class DigitalWatch2 extends DigitalWatch {

    private DigitalWatch2() {}

    static WatchMaker watchMaker = () -> new DigitalWatch2();
}

class RomeWatch2 extends RomeWatch {

    private RomeWatch2() {}

    static WatchMaker watchMaker = () -> new RomeWatch2();
}