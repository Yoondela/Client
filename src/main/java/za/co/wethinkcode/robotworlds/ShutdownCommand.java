package za.co.wethinkcode.robotworlds;

public class ShutdownCommand extends Command{

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Shutting down...");
        return false;
    }
    public ShutdownCommand(){
        super("off");
    }
}
