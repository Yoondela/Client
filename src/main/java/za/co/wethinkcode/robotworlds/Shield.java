package za.co.wethinkcode.robotworlds;

public class Shield {
    private final int ShieldHp;

    public Shield(int shieldHp){
        this.ShieldHp = shieldHp;
    }

    public int getShieldHp(){
        return ShieldHp;
    }

    public boolean IsAlive(){
        boolean broke = this.ShieldHp >= 0;
        return broke;
    }

    public boolean IsDead(){
        boolean dead = this.ShieldHp <=-1;
        return dead;
    }
}
