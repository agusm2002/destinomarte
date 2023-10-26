import greenfoot.*; 

public class Invertir extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("carta.wav");
            MyWorld world = (MyWorld) getWorld();
            Nave nave = world.getObjects(Nave.class).get(0);
            invertirBits(nave);
            world.reducirTiempo(50);
        }
        MyWorld world = (MyWorld) getWorld();
        world.actualizarBitsEnEscenario();
    }
    
    private void invertirBits(Nave nave) {
        int filaActual = nave.getFilaActual();
        int bitsAcumulados = nave.getBitsAcumulados();
        
        int bitsInvertidos = ~bitsAcumulados;
        bitsInvertidos &= 15;
        
        nave.setBitsAcumulados(bitsInvertidos);
        
        MyWorld world = (MyWorld) getWorld();
        world.actualizarBitsEnEscenario();
        world.actualizarTexto();
        world.getContadores()[filaActual] = bitsInvertidos;
    }
}
