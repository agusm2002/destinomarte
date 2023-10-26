import greenfoot.*;
import java.util.List;
import java.util.Random;

public class Nave extends Actor {
    private WinWorld winWorld;
    int bitsAcumulados;
    boolean keyReleased = true;
    private MyWorld myWorld;
    int filaActual;
    public boolean mostrado = false;
    private BitsContador bitsContador;
    private int[] valoresFilas;
    
    public Nave(MyWorld myWorld) {
        this.myWorld = myWorld;
        this.bitsAcumulados = myWorld.getContadores()[0];
        this.filaActual = 0;

        valoresFilas = myWorld.getContadores().clone();
        bitsContador = new BitsContador();
        myWorld.addObject(bitsContador, 880, 200);
    }
    
    public int getBitsAcumulados() {
        return bitsAcumulados;
    }

    public void setBitsAcumulados(int bitsAcumulados) {
        this.bitsAcumulados = bitsAcumulados;
    }
    
    public int getFilaActual() {
        return filaActual;
    }
    
    public void setFilaActual(int filaActual) {
        this.filaActual = filaActual;
    }
    
    public void act() {
        RandomNumberDisplay rnd = (RandomNumberDisplay) getWorld().getObjects(RandomNumberDisplay.class).get(0);

        bitsContador.setValor(bitsAcumulados);
        
        if (keyReleased == true && bitsAcumulados == rnd.randomNumber) {
            mover();
        }
        
        if (getY() < 255) {
            getWorld().removeObject(this);
            Greenfoot.playSound("win.wav");
            Greenfoot.setWorld(new WinWorld());
            Greenfoot.stop();  
        }

        Actor ast1 = getOneIntersectingObject(Ast1.class);
        if (ast1 != null) {
            getWorld().removeObject(this);
            Greenfoot.playSound("impacto.wav");
            Greenfoot.stop();
        }

        Actor ast2 = getOneIntersectingObject(Ast2.class);
        if (ast2 != null) {
            getWorld().removeObject(this);
            Greenfoot.playSound("impacto.wav");
            Greenfoot.stop();
        }

        Actor ufo1 = getOneIntersectingObject(Ufo1.class);
        if (ufo1 != null) {
            getWorld().removeObject(this);
            Greenfoot.playSound("impacto.wav");
            Greenfoot.stop();
        }

        Actor ufo2 = getOneIntersectingObject(Ufo2.class);
        if (ufo2 != null) {
            getWorld().removeObject(this);
            Greenfoot.playSound("impacto.wav");
            Greenfoot.stop();
        }
        
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("up")) {
            keyReleased = true;
        }
    }
    
    public void actualizarFilaActual(int nuevaFila) {
        filaActual = nuevaFila;
    }

    public void mover() {
        int x = getX();
        int y = getY();
        MyWorld world = (MyWorld) getWorld();
        world.actualizarTexto();

        if (Greenfoot.isKeyDown("left") && x - 110 > 370) {
            keyReleased = false;
            Greenfoot.playSound("move2.wav");
            setLocation(x - 110, y);
            actualizarNumeroRandom();
            myWorld.moverObstaculosAbajo();
            resetearValor();
            System.out.println("Fila A: " + world.contadores[0]);
            System.out.println("Fila B: " + world.contadores[1]);
            System.out.println("Fila C: " + world.contadores[2]);
            System.out.println("Fila D: " + world.contadores[3]);
        } else if (Greenfoot.isKeyDown("right") && x + 110 < 705) {
            keyReleased = false;
            Greenfoot.playSound("move2.wav");
            setLocation(x + 110, y);
            actualizarNumeroRandom();
            myWorld.moverObstaculosAbajo();
            resetearValor();
            System.out.println("Fila A: " + world.contadores[0]);
            System.out.println("Fila B: " + world.contadores[1]);
            System.out.println("Fila C: " + world.contadores[2]);
            System.out.println("Fila D: " + world.contadores[3]);
        } else if (Greenfoot.isKeyDown("up") && y + 110 > 250) {
            keyReleased = false;
            Greenfoot.playSound("move2.wav");
            setLocation(x, y - 110);
            actualizarNumeroRandom();
            myWorld.moverObstaculosAbajo();
            filaActual++;
            if (filaActual >= 4) {
                filaActual = 3;
            }
            actualizarBitsAcumulados();
            resetearValor();
            System.out.println("Fila A: " + world.contadores[0]);
            System.out.println("Fila B: " + world.contadores[1]);
            System.out.println("Fila C: " + world.contadores[2]);
            System.out.println("Fila D: " + world.contadores[3]);
        }
    }
    
    public void actualizarBitsAcumulados() {
        int[] contadores = myWorld.getContadores();
        if (filaActual >= 0 && filaActual < contadores.length) {
            bitsAcumulados = contadores[filaActual];;
        }
    }
    
    public void resetearValor() {
        myWorld.valorActual = myWorld.valorInicial;
        myWorld.actualizarTexto();
    }
    
    public void actualizarNumeroRandom() {
        RandomNumberDisplay rnd = (RandomNumberDisplay) getWorld().getObjects(RandomNumberDisplay.class).get(0);
        rnd.updateRandomNumber();
    }

    public BitsContador getBitsContador() {
        return bitsContador;
    }
}
