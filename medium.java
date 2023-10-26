import greenfoot.*; 
public class medium extends Actor
{   
    private MyWorld myWorld;
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld(200));
            Greenfoot.playSound("boton2.wav");
        }
    }
}