package za.co.wethinkcode.robotworlds;

public class RightCommand extends Command {
    /** This method checks the current direction and makes a decision on where Right is, depending on where
     * the robot is currently facing.
     * @param target: Input from Robot as a command to turn Right
     * @return true: Returns true when the Right turn has been executed
     */
    @Override
    public boolean execute(Robot target) {
        Robot.directionIndex += 1; // For the cardinal directions
        if (Robot.directionIndex > 3) {
            Robot.directionIndex = 0;
        }

        Direction direction = target.getCurrentDirection(); // Checking what the direction currently is
        if (Direction.UP.equals(direction)) {
            target.setCurrentDirection(Direction.RIGHT);
        }
        if (Direction.RIGHT.equals(direction)) {
            target.setCurrentDirection(Direction.RIGHT);
        }
        if (Direction.DOWN.equals(direction)) {
            target.setCurrentDirection(Direction.LEFT);
        }
        if (Direction.LEFT.equals(direction)) {
            target.setCurrentDirection(Direction.RIGHT);
        }
        target.setStatus("Turned right.");
        return true;
    }

    public RightCommand() {
        super("right");
    }
}

