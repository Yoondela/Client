package za.co.wethinkcode.toyrobot;

public class ShutdownCommand extends Command{

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Shutting down...");
        return true;
    }
    public ShutdownCommand(){
        super("off");
    }
}
