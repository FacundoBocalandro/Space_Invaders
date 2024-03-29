import java.awt.*;
import java.util.LinkedList;

public class Handler implements Commons{
    LinkedList<GameObject> objects = new LinkedList<GameObject>();
    LinkedList<Alien> aliens = new LinkedList<Alien>();
    Player player;
    SpaceInvaders game;
    Spawn spawn;
    int currentLevel = 1;
    int numberOfTicks;
    HighScore highScore;
    public Handler(SpaceInvaders game){
        this.game = game;
        highScore = new HighScore();
    }


    public void tick(){
            numberOfTicks ++;
            for (int i = 0; i < objects.size(); i++) {
                GameObject object = objects.get(i);
                object.tick();
            }
            if (numberOfTicks % 10000 == 0){
                Ufo ufo = new Ufo(0, 30, this);
                objects.add(ufo);
            }

    }
    public void render(Graphics g){
        for (int i = 0; i < objects.size(); i++) {
             GameObject object = objects.get(i);
             object.render(g);

        }
    }
    public void setPlayer(Player player){
        addObject(player);
        this.player = player;
    }
    public void setSpawn(Spawn spawn){
        this.spawn = spawn;
    }
    public Player getPlayer(){
        return player;
    }
    public int getLevel(){
        return currentLevel;
    }
    public void addObject(GameObject object){
        objects.add(object);
    }
    public void removeObject(GameObject object){
        objects.remove(object);
    }
    public void addAliens(){
        for (int j = 0; j < 11; j++) {
                SmallAlien alien = new SmallAlien(18 + 18*j, 40 , this, currentLevel);
                aliens.add(alien);
                addObject(alien);

        }
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                MedAlien alien = new MedAlien(18 + 18*j, 40 + 18*i, this, currentLevel);
                aliens.add(alien);
                addObject(alien);
            }
        }
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                BigAlien alien = new BigAlien(18 + 18*j, 40 + 18*i, this, currentLevel);
                aliens.add(alien);
                addObject(alien);
            }
        }

    }
    public void addShields(){
        int shieldsAmount = 5 - currentLevel;
        if (shieldsAmount < 0){ shieldsAmount = 0;}
        int spacing = BOARD_WIDTH/(shieldsAmount+1);


        for (int i = 0; i < shieldsAmount; i++) {
            Shield shield = new Shield( spacing-20 + spacing*i, 230, this);
            objects.add(shield);

        }
    }
    public LinkedList<GameObject> getObjects(){
        return objects;
    }
    public void removeAlien(Alien alien){
        aliens.remove(alien);
        removeObject(alien);
    }
    public void allienKilled(int increase){
        player.increaseScore(increase);
        spawn.increaseAlliensKilled();
    }
    public void increaseLevel(){
        if (currentLevel == 5){
            winGame();
        }else {
            currentLevel++;
            increaseLevel(currentLevel);
        }

    }
    public int getLives(){
        return player.getLives();
    }
    public int getScore(){
        return player.getScore();
    }
    public void restartObjects(){
        objects.clear();
        objects.add(player);
        addAliens();
        addShields();
    }

    public void restartLevel(){
        currentLevel = 1;
    }

    public void freezeAliens() {
        for (int i = 0; i < aliens.size(); i++) {
             aliens.get(i).setDoTick(false);

        }
    }

    public void unFreezeAliens() {
        for (int i = 0; i < aliens.size(); i++) {
             aliens.get(i).setDoTick(true);

        }
    }

    public LinkedList<Alien> getAliens() {
        return aliens;
    }
    public void menu() {
        Menu menu = game.getMenu();
        game.removeMouseListener(game.getCurrentMouseAdapter());
        game.setCurrentMouseAdapter(menu);
        game.addMouseListener(menu);
        game.setGameState(new MenuState(menu));
    }

    public void endGame() {
        game.removeMouseListener(game.getCurrentMouseAdapter());
        if (highScore.isHighScore(getScore())) {
            newHighScore();

        }else {
            EndGame endGameScreen = game.getEndGameScreen();
            game.setCurrentMouseAdapter(endGameScreen);
            game.addMouseListener(endGameScreen);
            game.setGameState(new EndGameState(endGameScreen));
        }
    }

    public void restartGame() {
        spawn.resetAliensKilled();
        player = new Player(100, 280, this);
        setPlayer(player);
        restartLevel();
        restartObjects();
    }

    public void inGame() {
        game.setGameState(new InGameState(this, game.getHud(), spawn));
    }

    public void increaseLevel(int level) {
        LevelUp levelUpScreen = game.getLevelUpScreen();
        game.removeMouseListener(game.getCurrentMouseAdapter());
        game.setCurrentMouseAdapter(levelUpScreen);
        game.addMouseListener(levelUpScreen);
        game.setGameState(new LevelUpState(levelUpScreen, level));
    }
    public void newHighScore(){
        NewHighScore newHighScore = game.getNewHighScoreScreen();
        game.removeMouseListener(game.getCurrentMouseAdapter());
        new NameTextField(200, 80, this, getScore());
        game.setCurrentMouseAdapter(newHighScore);
        game.addMouseListener(newHighScore);
        game.setGameState(new NewHighScoreState(newHighScore));
        game.getWindow().requestFocus();
    }
    public void ranking(){
        Ranking ranking = game.getRanking();
        game.removeMouseListener(game.getCurrentMouseAdapter());
        game.setCurrentMouseAdapter(ranking);
        game.addMouseListener(ranking);
        game.setGameState(new RankingState(ranking, highScore));
    }

    public void winGame() {
        game.removeMouseListener(game.getCurrentMouseAdapter());
        if (highScore.isHighScore(getScore())) {
           newHighScore();
        }else {
            GameWon gameWonScreen = game.getGameWonScreen();
            game.setCurrentMouseAdapter(gameWonScreen);
            game.addMouseListener(gameWonScreen);
            game.setGameState(new GameWonState(gameWonScreen));
        }
    }

    public void newHighScore(String name, int score) {
        highScore.addScoreToRanking(new Score(name, score));
        highScore.addToFile();
    }

    public void pause(){
        game.pause();

    }
    public boolean isPaused(){
        return game.isPaused();
    }
}
