import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    
    private boolean started = false;
    int x = (new java.util.Random()).nextInt(15);
    

    public MyWorld() {    
        // tamaño del fondo
        super(1013, 768, 1); 
        
        //Se posicionan las cartas de operaciones
        addObject(new Suma(), 70, 220);
        addObject(new Resta(), 180, 220);
        addObject(new Mover(), 70, 330);
        addObject(new Invertir(), 180, 330);
        addObject(new Izquierda(), 70, 440);
        addObject(new Derecha(), 180, 440);
        addObject(new CopiaA(), 70, 550);
        addObject(new CopiaB(), 180, 550);
        addObject(new CopiaC(), 126, 660);
        addObject(new CartaOb(),885, 385);
        addObject(new RandomNumberDisplay(), 885, 385);
        // Configura el color
        Color colorTexto = Color.RED;

        // Crea una imagen de texto con el tamaño y el color personalizados
        GreenfootImage imagen = new GreenfootImage("15:00", 66, colorTexto, null);
        
        // Muestra el texto en el escenario
        getBackground().drawImage(imagen, 62, 40);

        // Crea una instancia de Random
        Random random = new Random();
        
        // Crea una matriz 4x4 de instancias de bits y agrega cada celda al mundo
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Genera un número aleatorio (0 o 1) para decidir qué imagen mostrar
                int randomBit = random.nextInt(2);

                if (randomBit == 0) {
                    bitApagado bitApagado = new bitApagado(); //Instancio la imagen
                    addObject(bitApagado, i * 110 + 375, j * 110 + 255); //Posicion de la imagen
                } else {
                    bitEncendido bitPrendido = new bitEncendido();

                    addObject(bitPrendido, i * 110 + 375, j * 110 + 255);
                }
            }
        }
        
        // Generación de Nave
        Nave nave = new Nave();
        int random2 = Greenfoot.getRandomNumber(4);
        switch(random2){
            case 0:
                addObject(nave, 375, 585);
                break;
            case 1:
                addObject(nave, 483, 585);
                break;
            case 2:
                addObject(nave, 593, 585);
                break;
            case 3:
                addObject(nave, 703, 585);
                break;
        }
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}




    
   
 
