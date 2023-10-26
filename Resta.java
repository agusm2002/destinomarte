import greenfoot.*;  
import java.util.List;

public class Resta extends Suma
{
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("carta.wav");
            Nave nave = (Nave) getWorld().getObjects(Nave.class).get(0);
            int filaActual = nave.getFilaActual();
            int bitsAcumulados = nave.getBitsAcumulados();
            bitsAcumulados = (bitsAcumulados - 1) % 16;  
            MyWorld world = (MyWorld) getWorld();
            world.getContadores()[filaActual] = bitsAcumulados;
            nave.setBitsAcumulados(bitsAcumulados);
            
            world.actualizarBitsEnEscenario();
            world.actualizarTexto();
            world.reducirTiempo(100);
        }
    }
}
