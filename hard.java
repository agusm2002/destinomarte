import greenfoot.*; 

public class hard extends Actor
{   
    private MyWorld myWorld;
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld(150));
            Greenfoot.playSound("boton2.wav");
        }
    }

}