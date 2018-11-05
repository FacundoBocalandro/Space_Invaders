public class Spawn {
    Handler handler;
    int score;
    public Spawn(Handler handler){
        this.handler = handler;
        score = 0;
    }
    public void tick(){
        if(score >= 100){
            handler.increaseLevel();
            score = 0;
        }

    }
    public void increaseScore(int increase){
        score += increase;
    }
}
