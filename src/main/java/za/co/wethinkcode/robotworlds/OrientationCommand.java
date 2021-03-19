package za.co.wethinkcode.robotworlds;

public class OrientationCommand extends Command {
    /** The directionIndex increments by one when a Right turn is made and decrements by one when a Left turn is made.
     * This method simply prints out the cardinal direction the robot is facing.
     * @param target: Input from Robot as a command to turn show Orientation
     * @return true: Returns true when orientation has been executed
     */
    @Override
    public boolean execute(Robot target) {
        int cardinalDirection = target.getCardinalDirection();
        Direction direction;

        if (cardinalDirection == 0) {
            direction = Direction.UP;
        } else if (cardinalDirection == 1) {
            direction = Direction.DOWN;
        } else if (cardinalDirection == 2) {
            direction = Direction.LEFT;
        } else {
            direction = Direction.RIGHT;
        }
        target.setStatus("Facing "+direction+".");
        return true;
    }

    public OrientationCommand() {
        super("orientation");
    }
}

