public class FreezeInvaders implements PlayerState {
    public void activate(Handler handler, Player player) {
        handler.freezeAliens();
    }
    public void deactivate(Player player,Handler handler){
        handler.unFreezeAliens();
        player.resetSuccesfulShots();
        player.setNormalPlayer();
    }
}
