package behavioral.observer.corruption;

public class CorruptionApp {

    public static void main(String[] args) {

        Congress firstCongress = new Congress();
        Agency agency = new Agency(firstCongress);

        agency.sendSpies();

        firstCongress.doneDiscussExpanding();
        firstCongress.doneDiscussMoneyLaundering();
        firstCongress.doneDiscussNewSourcesBribes();

    }

}
