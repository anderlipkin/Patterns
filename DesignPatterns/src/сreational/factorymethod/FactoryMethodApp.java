package сreational.factorymethod;

import java.util.Date;

/**
 * Определяет интерфейс для создания объекта (WatchMaker),
 * но оставляет подклассам (DigitalWatchMaker, RomeWatchMaker) решение о том, какой класс инстанцировать.
 * Фабричный метод позволяет классу делегировать создание подклассов.
 * @author Fenix
 */
public class FactoryMethodApp {

    public static void main(String[] args) {
        WatchMaker maker = getMakerByName("Digital");

        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if(maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Production line of watches is not supported: " + maker);
    }

}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}