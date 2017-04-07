package behavioral.observer.corruption;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

public class Congress implements Observable{
    private boolean discussExpand;
    private boolean discussMoney;
    private boolean discussNewBribes;

    private List<Observer> spies;

    Congress() {
        discussExpand = false;
        discussMoney = false;
        discussNewBribes = false;
        spies = new ArrayList<>();
    }

    void doneDiscussExpanding(){
        discussExpand = true;
        notifyObservers();
    }

    void doneDiscussMoneyLaundering(){
        discussMoney = true;
        notifyObservers();
    }

    void doneDiscussNewSourcesBribes(){
        discussNewBribes = true;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        if (o instanceof Spy && ((Spy) o).levelStealth > 0.5){
            spies.add(o);
        } else if(o instanceof Spy ){
            System.out.println("Замечен шпион - №" + ((Spy) o).getIdAgent());
        }
    }

    @Override
    public void removeObserver(Observer o) {
        spies.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer spy: spies) {
            spy.handleEvent(discussExpand, discussMoney, discussNewBribes);
        }
    }
}
