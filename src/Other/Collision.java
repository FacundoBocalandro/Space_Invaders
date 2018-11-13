public interface Collision {
    default void getShotCollision(PlayerShot shot){}
    default void getShotCollision(AlienShot shot){}
    default void getAlienCollision(Alien alien){}
    default void getPlayerCollision(Player player){}
    default void getShieldCollision(Shield shield){}
    default void getInmunityShieldCollision(InmunityShield shield){}
    default void getUfoCollision(Ufo ufo){}

}