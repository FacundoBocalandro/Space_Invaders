public class Inmunity implements PlayerState {
    public void getAlienShotCollision(AlienShot shot, Player player){
        shot.getPlayerCollision(player);
    }

}
