package za.co.wethinkcode.robotworlds;

public class ShieldRepairCommand extends Command {
    int hp = 5 ;
    public ShieldRepairCommand(){
        super("repair");
    }

    @Override
    public boolean execute(Robot target) {
        if(hp<5 && hp >= 0) {
            int repair = 5 - hp;
            this.hp = repair;
        }
        return true;
    }
}