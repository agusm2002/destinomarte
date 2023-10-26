import greenfoot.*;  

public class And extends Actor {
    
    private boolean andClicked = false; 
    private int selectedFila = -1; 
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("carta.wav");
            andClicked = true;
            MyWorld world = (MyWorld) getWorld();
            world.reducirTiempo(25);
        }
        
        if (andClicked) {
            if (Greenfoot.isKeyDown("a")) {
                selectedFila = 0; 
            } else if (Greenfoot.isKeyDown("b")) {
                selectedFila = 1; 
            } else if (Greenfoot.isKeyDown("c")) {
                selectedFila = 2;
            } else if (Greenfoot.isKeyDown("d")) {
                selectedFila = 3;
            }
        }
        
        if (andClicked && selectedFila != -1) {
            copiarFila(selectedFila);
        }
    }
    
    private void copiarFila(int filaSeleccionada) {
        MyWorld world = (MyWorld) getWorld();
        Nave nave = (Nave) getWorld().getObjects(Nave.class).get(0);
        
        int filaNave = nave.getFilaActual();
        
        if (filaNave != -1) {
            int[] contadores = world.getContadores();
            
            contadores[filaNave] &= contadores[filaSeleccionada];
            
            world.actualizarBitsEnEscenario();
            
            
            nave.actualizarBitsAcumulados();
            
            nave.getBitsContador().actualizarValor(nave.getBitsAcumulados());
        }
        
        andClicked = false;
        selectedFila = -1;
    }
}


