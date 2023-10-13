import greenfoot.*;

public class RandomNumberDisplay extends Actor {
    public RandomNumberDisplay() {
        GreenfootImage image = new GreenfootImage(100, 50);
        setImage(image);
        updateRandomNumber();
    }
   
    public void updateRandomNumber() {
    int randomNumber = Greenfoot.getRandomNumber(16); // Generates a random integer between 0 and 15
    GreenfootImage image = getImage();
    image.clear();
    
    // Define a new font with a larger size
    Font font = new Font("Arial", 35); // You can adjust the font type and size as needed
    image.setFont(font);
    
    image.drawString("" + randomNumber, 30, 30);
    image.setColor(Color.GREEN);
    }

}

