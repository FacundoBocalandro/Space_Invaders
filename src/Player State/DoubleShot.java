public class DoubleShot implements PlayerState{
    public void shoot(Player player, Handler handler){
        handler.addObject(new PlayerShot(player.getX() + 2, player.getY(), handler, player));
        handler.addObject(new PlayerShot(player.getX() + 10, player.getY(), handler, player));
    }
}
