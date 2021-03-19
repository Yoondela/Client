package za.co.wethinkcode.robotworlds;

public class FireCommand extends Command {
    public FireCommand() {
        super("fire");
    }


    @Override
    public boolean execute(Robot target) {
        target.setInstruction("fire");
        int remainingBullets = target.updateGun();
        if(remainingBullets >= 0) {
            target.setStatus("Fired one shot");
        }else {
            target.setStatus("No bullets left");
        }
        return true;
    }
}
