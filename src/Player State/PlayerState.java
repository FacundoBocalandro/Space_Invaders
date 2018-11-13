public interface PlayerState {
    default void shoot(Player player, Handler handler) {
        handler.addObject(new PlayerShot(player.getX() + 6, player.getY(), handler, player));
    }
    default void getAlienShotCollision(AlienShot shot, Player player){
        player.reduceLives();
        shot.getPlayerCollision(player);
    }
    default void freezeAliens(Handler handler){}
    default void move(int newX){}
    default void activate(Handler handler, Player player){}
    default void deactivate(Player player,Handler handler){
        player.resetSuccesfulShots();
        player.setNormalPlayer();
    }
}
