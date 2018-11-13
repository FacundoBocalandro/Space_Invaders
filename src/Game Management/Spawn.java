public class Spawn {
    Handler handler;
    int aliensKilled;
    public Spawn(Handler handler){
        this.handler = handler;
        aliensKilled = 0;
    }
    public void tick(){
        if(aliensKilled >= 30){
            handler.increaseLevel();
            aliensKilled = 0;
        }

    }
    public void increaseAlliensKilled(){
        aliensKilled += 1;
    }
    public void resetAliensKilled(){
        aliensKilled = 0;
    }

}
