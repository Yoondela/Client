package za.co.wethinkcode.robotworlds;

public class BackCommand extends Command {
    /** This method moves the Robot back negatively on the Y axis
     * @param target: Input from Robot as a command to move Backwards
     * @return true: Returns true when the Backwards movement has been executed
     */
    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        if (target.updatePosition(-nrSteps)){
            target.setStatus("Moved back by "+nrSteps+" steps.");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        return true;
    }

    public BackCommand(String argument) {
        super("back", argument);
    }
}

