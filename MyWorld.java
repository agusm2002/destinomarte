import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

 
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
        
        placeRandomObjects();
        
    }
    
    private void placeRandomObjects(){
    Actor[] objects = {new Ast1(), new Ast2(), new Ufo1(), new Ufo2()};
    int[][] coordinates = {{375, 255}, {484, 255}, {593, 255}, {703, 255}, {375, 365}, {484, 365}, {593, 365}, {703, 365}, {375, 475}, {484, 475}, {593, 475}, {703, 475}}; // Reemplaza x1, y1, etc. con tus coordenadas

    int numObjects = Greenfoot.getRandomNumber(3) + 3; // Genera un número aleatorio entre 2 y 4

    List<int[]> availableCoordinates = new ArrayList<int[]>();
    for (int[] coordinate : coordinates) {
        availableCoordinates.add(coordinate.clone());
    }

    for(int i = 0; i < numObjects; i++)
    {
        int randomIndex = Greenfoot.getRandomNumber(objects.length);
        Actor randomObject = objects[randomIndex];

        if (availableCoordinates.isEmpty()) {
            break;
        }

        int randomCoordinateIndex = Greenfoot.getRandomNumber(availableCoordinates.size());
        int[] randomCoordinate = availableCoordinates.get(randomCoordinateIndex);
        availableCoordinates.remove(randomCoordinateIndex);

        addObject(randomObject, randomCoordinate[0], randomCoordinate[1]);
    }
}
    
}




    
   
 
