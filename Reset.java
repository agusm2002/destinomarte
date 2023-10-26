import greenfoot.*;

public class Reset extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("carta.wav");
            MyWorld world = (MyWorld) getWorld();
            
            RandomNumberDisplay rnd = (RandomNumberDisplay) world.getObjects(RandomNumberDisplay.class).get(0);
            rnd.updateRandomNumber();
            
            world.reducirTiempo(50);
        }
    }
}