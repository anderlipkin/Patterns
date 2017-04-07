package behavioral.observer.corruption;

import java.util.ArrayList;
import java.util.List;

public class Agency {

    private Congress congress;
    private List<Observer> spiesAgency = new ArrayList<>();

    Agency(Congress c){
        congress = c;
    }

    void sendSpies(){
        for(int i = 0; i < 10; i++) {
            Observer spy = new Spy(congress);
            spiesAgency.add(spy);
            congress.addObserver(spy);
        }
    }

    void getMessage(Message msg){
        System.out.println(msg.getMessage());
    }

}
