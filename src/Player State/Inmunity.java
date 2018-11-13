public class Inmunity implements PlayerState {
    InmunityShield inmunityShield;
    public void getAlienShotCollision(AlienShot shot, Player player){
        shot.getPlayerCollision(player);
    }
    public void activate(Handler handler, Player player){
        inmunityShield = new InmunityShield(player.getX() - 10, player. getY() - 12, handler, player);
        handler.addObject(inmunityShield);
    }
    public void deactivate(Player player, Handler handler){
        handler.removeObject(inmunityShield);
        player.resetSuccesfulShots();
        player.setNormalPlayer();
    }
    public void move(int newX){
        inmunityShield.move(newX);
    }
}
