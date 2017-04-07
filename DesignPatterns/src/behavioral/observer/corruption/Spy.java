package behavioral.observer.corruption;

interface Observer {
    void handleEvent(boolean discussExpanding, boolean discussMoneyLaundering, boolean discussNewSourcesBribes);
}

public class Spy implements Observer{

    private static Agency agency;
    private Message msg = new Message();

    private int idAgent;
    private static int id;
    double levelStealth;

    Spy(Congress c) {
        levelStealth = Math.random()+0.25;
        agency = new Agency(c);
        idAgent = id++;
    }

    int getIdAgent(){
        return idAgent;
    }

    @Override
    public void handleEvent(boolean discussExpanding, boolean discussMoneyLaundering, boolean discussNewSourcesBribes) {
        if (discussExpanding && discussMoneyLaundering && discussNewSourcesBribes) {
            msg.setMessage("Агент - " + idAgent + ": Можно захвачивать! " );
            sendMessage(msg);
        }
    }

    private void sendMessage(Message msg){
        agency.getMessage(msg);
    }
}
