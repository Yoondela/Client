package za.co.wethinkcode.robotworlds;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);
    private final Shield hp = new Shield(5);
    public static final Position CENTRE = new Position(0,0);

    static int directionIndex = 0;
    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;
    private Shield shieldhp;
    private String instruction;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.shieldhp = hp;
        this.currentDirection = Direction.UP;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    Gun gun = new Gun();
    public int remainingShots = gun.getBullets();

    public int updateGun() {
        if(this.instruction == "reload"){
            remainingShots = 3;
        }else if(remainingShots >= 0) {
            remainingShots--;
        }else remainingShots = -1;
        return remainingShots;
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        if (Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }
        if (Direction.DOWN.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }
        if (Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    /** Returns the cardinal direction the robot is facing, represented by numbers 0 - 3. This index is incremented in
     * RightCommand and decremented in LeftCommand.
     */
    public int getCardinalDirection() {
        return directionIndex;
    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getY() + "] "
                + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public String getName() {
        return this.name;
    }

    public void setInstruction(String instruction){
        this.instruction = instruction;
    }


    public Shield getShieldhp() {
        return shieldhp;
    }
}
