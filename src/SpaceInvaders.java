import java.awt.*;
import java.awt.image.BufferStrategy;

public class SpaceInvaders extends Canvas implements Runnable, Commons{
    int width = BOARD_WIDTH ;
    int height = BOARD_HEIGHT;
    private Thread thread;
    private Handler handler;
    private HUD hud;
    private Spawn spawn;
    private Menu menu;
    private boolean running = false;
    Canvas window;
    public enum State{
        Menu,
        Game
    }
    public State gameState = State.Menu;

    public SpaceInvaders(){
        handler = new Handler();
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        this.addKeyListener(new KeyInput(handler));
        this.addKeyListener(new KeyShotInput(handler));
        handler.setPlayer(new Player(100, 280, handler));
        handler.addAliens();
        handler.addShields();

        spawn = new Spawn(handler);
        handler.setSpawn(spawn);
        hud = new HUD(handler);
        window = new StartGameWindow(width, height, this, "Space Invaders");


    }
    public void run(){
        long lastTime = System.nanoTime();      //Game loop copiado de internet
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta --;
            }
            if(running){
                render();
            }
            frames ++;
            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){
        if (gameState == State.Game) {
            handler.tick();
            hud.tick();
            spawn.tick();
        }else if (gameState == State.Menu){
            menu.tick();
        }

    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);


        if (gameState == State.Game) {
            hud.render(g);
            handler.render(g);
        }else if (gameState == State.Menu) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }
    public synchronized void start() {
        setFocusable(true);
        thread = new Thread(this);
        thread.start();
        running = true;

    }
    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static boolean collides(GameObject object1, GameObject object2){
        return object1.getBounds().intersects(object2.getBounds());
    }

    public static void main(String[] args) {
        new SpaceInvaders();
    }

}
