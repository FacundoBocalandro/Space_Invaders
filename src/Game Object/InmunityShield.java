public class InmunityShield extends GameObject {
    Player player;
    public InmunityShield(int x, int y, Handler handler, Player player){
        super(x, y, handler, "images/SpinningCircle.gif");
    }
    @Override
    public void tick() {
    }

    @Override
    public void getShotCollision(AlienShot shot) {
        shot.getInmunityShieldCollision(this);
    }

    public void move(int newX) {
        setX(newX - 10);
    }
}
