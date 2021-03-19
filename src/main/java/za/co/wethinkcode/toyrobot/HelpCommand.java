package za.co.wethinkcode.toyrobot;

public class HelpCommand extends Command{

    @Override
    public boolean execute(Robot target) {
        target.setStatus("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'");
        return true;
    }
    public HelpCommand(){
        super("help");
    }
}
