import greenfoot.*;  
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

 
public class MyWorld extends World {
    private boolean started = false;
    public boolean obstaculosMovidos = false;
    int x = (new java.util.Random()).nextInt(15);
    public int[] contadores;
    public int valorActual;
    private GreenfootImage valorImage; 
    public boolean juegoTerminado = false;  
    public int valorInicial;
    
    public MyWorld(int valorInicial) {    
        super(1013, 768, 1);
        
        addObject(new Suma(), 70, 220);
        addObject(new Resta(), 180, 220);
        addObject(new Reset(), 70, 330);
        addObject(new Invertir(), 180, 330);
        addObject(new Izquierda(), 70, 440);
        addObject(new Derecha(), 180, 440);
        addObject(new And(), 70, 550);
        addObject(new Or(), 180, 550);
        addObject(new CartaOb(),885, 385);
        addObject(new RandomNumberDisplay(), 885, 385);
        
        this.valorInicial = valorInicial; 
        valorImage = new GreenfootImage("" + valorActual, 106, Color.RED, null);
        valorActual = valorInicial;
        actualizarTexto();
        
        GreenfootSound backgroundMusic = new GreenfootSound("backgroundsound.mp3");
        backgroundMusic.playLoop();
        
        int[][] coordenadas = {
            {375, 255}, {484, 255}, {593, 255}, {703, 255},
            {375, 365}, {484, 365}, {593, 365}, {703, 365},
            {375, 475}, {484, 475}, {593, 475}, {703, 475},
            {375, 585}, {484, 585}, {593, 585}, {703, 585}
        };

        
        for (int[] coords : coordenadas) {
            int x = coords[0];
            int y = coords[1];

            
            int bitValue = Greenfoot.getRandomNumber(2);

            
            Bit bit = new Bit(bitValue);
            addObject(bit, x, y);
        }
        
        contarBitPrendidos();
        
    
        Nave nave = new Nave(this);
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
        
        inicioObstaculos();
    }

    public void reducirTiempo(int valor) {
        valorActual -= valor;
        
        
        actualizarTexto();
    }   
    
    public void actualizarTexto() {
        int x = 50;
        int y = 20;
        int ancho = valorImage.getWidth();
        int alto = valorImage.getHeight();
    
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect(x, y, ancho, alto);
        
        if (valorActual >= 0) {
            valorImage = new GreenfootImage("" + valorActual, 106, Color.RED, null);
            getBackground().drawImage(valorImage, 50, 23);
        } else if (valorActual == -1) {
            valorImage = new GreenfootImage("WIN", 50, Color.RED, null);
        } else if (valorActual < 0){
            valorImage = new GreenfootImage("GAME OVER", 35, Color.RED, null);
            getBackground().drawImage(valorImage, 50, 50);
            Greenfoot.playSound("over.mp3");
        }
    
        
    }
    
    
   public void contarBitPrendidos() {
        contadores = new int[4]; 
    
    
        List<Bit> bits = getObjects(Bit.class);
    
        for (Bit bit : bits) {
            int y = bit.getY();
            int x = bit.getX();
            int fila = -1;
    
            
            if (y == 585) {
                fila = 0; 
            } else if (y == 475) {
                fila = 1; 
            } else if (y == 365) {
                fila = 2; 
            } else if (y == 255) {
                fila = 3; 
            }
            

            if (bit.getValue()==1) {
                int valorBit = 0;
                if (x == 375) {
                    valorBit = 8;
                } else if (x == 484) {
                    valorBit = 4;
                } else if (x == 593) {
                    valorBit = 2;
                } else if (x == 703) {
                    valorBit = 1;
                }
                contadores[fila] += valorBit;             
            }
        }
        actualizarBitsEnEscenario();
        // Imprime el contador de bits encendidos por fila
        //System.out.println("Bits encendidos en la fila A: " + contadores[0]);
        //System.out.println("Bits encendidos en la fila B: " + contadores[1]);
        //System.out.println("Bits encendidos en la fila C: " + contadores[2]);
        //System.out.println("Bits encendidos en la fila D: " + contadores[3]);
    }
    
    public void actualizarBitsEnEscenario() {
    List<Bit> bits = getObjects(Bit.class);
    
    for (Bit bit : bits) {
        int x = bit.getX();
        int y = bit.getY();
        
        int fila = -1;
        if (y == 585) {
            fila = 0; // Fila A
        } else if (y == 475) {
            fila = 1; // Fila B
        } else if (y == 365) {
            fila = 2; // Fila C
        } else if (y == 255) {
            fila = 3; // Fila D
        }
        
        if (fila >= 0 && fila < contadores.length) {
            int valorBit = 0;
            if (x == 375) {
                valorBit = 8;
            } else if (x == 484) {
                valorBit = 4;
            } else if (x == 593) {
                valorBit = 2;
            } else if (x == 703) {
                valorBit = 1;
            }
            
            int valorFila = contadores[fila];
            boolean encendido = (valorFila & valorBit) != 0;
            
            if (encendido) {
                bit.setImage("bitPrendido.png");
            } else {
                bit.setImage("bitApagado.png");
            }        
        }
    }
}
        
    public int[] getContadores() {
        return contadores;
    }
    
    private void inicioObstaculos() {
        Actor[] objects = {new Ast1(), new Ast2(), new Ufo1(), new Ufo2()};
        int[][] coordinates = {{375, 255}, {484, 255}, {593, 255}, {703, 255}, {375, 365}, {484, 365}, {593, 365}, {703, 365}, {375, 475}, {484, 475}, {593, 475}, {703, 475}};
    
        int numObjects = Greenfoot.getRandomNumber(2) + 3;
    
        List<int[]> availableCoordinates = new ArrayList<int[]>();
        boolean ultFila = false;
        int prevX = -1; 
    
        for (int[] coordinate : coordinates) {
            availableCoordinates.add(coordinate.clone());
        }
    
        while (getObjects(Obstaculo.class).size() < 3) {
            if (availableCoordinates.isEmpty()) {
                break;
            }
    
            int randomIndex = Greenfoot.getRandomNumber(objects.length);
            Actor randomObject = objects[randomIndex];
    
            int randomCoordinateIndex = Greenfoot.getRandomNumber(availableCoordinates.size());
            int[] randomCoordinate = availableCoordinates.get(randomCoordinateIndex);
    
            if (randomCoordinate[1] == 475) {
                if (ultFila) {
                    continue;
                } else {
                    ultFila = true;
                }
            }
    
            if (Math.abs(randomCoordinate[0] - prevX) <= 109) {
                continue;
            }
    
            prevX = randomCoordinate[0];
    
            availableCoordinates.remove(randomCoordinateIndex);
            addObject(randomObject, randomCoordinate[0], randomCoordinate[1]);
        }
    }
    
    
   public void moverObstaculosAbajo() {
    List<Obstaculo> obstaculos = getObjects(Obstaculo.class);
    Set<String> posicionesOcupadas = new HashSet<>();

    for (Obstaculo obstaculo : obstaculos) {
        int x = obstaculo.getX();
        int y = obstaculo.getY();
        posicionesOcupadas.add(x + "-" + y);
    }

    for (Obstaculo obstaculo : obstaculos) {
        int x = obstaculo.getX();
        int y = obstaculo.getY();

        int nuevaY = y + 110;
        int nuevaX = x;

        if (y + 110 > 585) {
            int[][] newCoordinates = {{375, 255}, {484, 255}, {593, 255}, {703, 255}};
            int randomIndex = Greenfoot.getRandomNumber(newCoordinates.length);
            int[] randomCoordinate = newCoordinates[randomIndex];
            nuevaX = randomCoordinate[0];
            nuevaY = randomCoordinate[1];
        }

        String nuevaPosicion = nuevaX + "-" + nuevaY;

        while (posicionesOcupadas.contains(nuevaPosicion)) {
            int[][] newCoordinates = {{375, 255}, {484, 255}, {593, 255}, {703, 255}};
            int randomIndex = Greenfoot.getRandomNumber(newCoordinates.length);
            int[] randomCoordinate = newCoordinates[randomIndex];
            nuevaX = randomCoordinate[0];
            nuevaY = randomCoordinate[1];
            nuevaPosicion = nuevaX + "-" + nuevaY;
        }

        obstaculo.setLocation(nuevaX, nuevaY);

        posicionesOcupadas.remove(x + "-" + y);
        posicionesOcupadas.add(nuevaX + "-" + nuevaY);
    }

    obstaculosMovidos = true;
}



    
    public void act() {
        if (valorActual < 0) {
            Greenfoot.playSound("over.mp3");
            Greenfoot.stop();

        }
    }
    


}





    
   
 
