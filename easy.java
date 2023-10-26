import greenfoot.*; 
public class easy extends Actor
{   
    private MyWorld myWorld;
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld(250));
            Greenfoot.playSound("boton2.wav");
        }
    }
}
