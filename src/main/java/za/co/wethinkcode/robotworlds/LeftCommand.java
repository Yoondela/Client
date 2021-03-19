package za.co.wethinkcode.robotworlds;

public class LeftCommand extends Command {
    /** This method checks the current direction and makes a decision on where Left is, depending on where
     * the robot is currently facing.
     * @param target: Input from Robot as a command to turn Left
     * @return true: Returns true when the Left turn has been executed
     */
    @Override
    public boolean execute(Robot target) {
        Robot.directionIndex -= 1; // For the cardinal directions
        if (Robot.directionIndex < 0) {
            Robot.directionIndex = 3;
        }

        Direction direction = target.getCurrentDirection();
        if (Direction.UP.equals(direction)) {
            target.setCurrentDirection(Direction.LEFT);
        }
        if (Direction.LEFT.equals(direction)) {
            target.setCurrentDirection(Direction.LEFT);
        }
        if (Direction.DOWN.equals(direction)) {
            target.setCurrentDirection(Direction.RIGHT);
        }
        if (Direction.RIGHT.equals(direction)) {
            target.setCurrentDirection(Direction.LEFT);
        }
        target.setStatus("Turned left.");
        return true;
    }

    public LeftCommand() {
        super("left");
    }
}
