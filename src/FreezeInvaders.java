public class FreezeInvaders implements PlayerState {
    @Override
    public void freezeAliens(Handler handler) {
        handler.freezeAliens();
    }
    public void deactivate(Player player,Handler handler){
        handler.unFreezeAliens();
        player.resetSuccesfulShots();
        player.setNormalPlayer();
    }
}
