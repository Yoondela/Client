package za.co.wethinkcode.robotworlds;

public class ReloadCommand extends Command{
    public ReloadCommand() {super("reload");}

    @Override
    public boolean execute(Robot target) {
        target.setInstruction("reload");
        target.updateGun();
        target.setStatus("Reloaded");
        return true;
    }
}
