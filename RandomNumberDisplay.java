import greenfoot.*;

public class RandomNumberDisplay extends Actor {
    public int randomNumber;
    public int previousNumber = -1;

    public RandomNumberDisplay() {
        GreenfootImage image = new GreenfootImage(100, 50);
        setImage(image);
        updateRandomNumber();
    }

    public void updateRandomNumber() {
        do {
            randomNumber = Greenfoot.getRandomNumber(15);
        } while (randomNumber == previousNumber);
        
        previousNumber = randomNumber;

        GreenfootImage image = getImage();
        image.clear();

        Font font = new Font("Arial", 35);
        image.setFont(font);

        image.drawString("" + randomNumber, 30, 30);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
