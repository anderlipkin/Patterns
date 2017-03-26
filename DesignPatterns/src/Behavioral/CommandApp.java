package Behavioral;

public class CommandApp {
    public static void main(String[] args) {
        Computer c = new Computer();
        User user = new User(
                        new StartCommand(c),
                        new StopCommand(c),
                        new ResetCommand(c)
                    );
        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface Command {
    void execute();
}

// Receiver
class Computer {
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}

//Concrete Command
class StartCommand implements Command {
    private Computer computer;

    public StartCommand(Computer comp) {
        computer = comp;
    }
    @Override
    public void execute(){
        computer.start();
    }
}
class StopCommand implements Command {
    private Computer computer;

    public StopCommand(Computer comp) {
        computer = comp;
    }
    @Override
    public void execute(){
        computer.stop();
    }
}
class ResetCommand implements Command {
    Computer computer;

    public ResetCommand(Computer comp) {
        computer = comp;
    }
    @Override
    public void execute(){
        computer.reset();
    }
}

//Invoker
class User {
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset){
        this.start = start;
        this.stop = stop;
        this.reset = reset;

    }

    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}