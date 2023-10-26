import greenfoot.*; 

public class BitsContador extends Actor {
    private int valor;
    private int filaActual;

    public BitsContador() {
        valor = 0;
        filaActual = 0; 
        actualizarImagen();
    }

    public void act() {
        
        actualizarImagen();
    }

    public void setValor(int nuevoValor) {
        valor = nuevoValor;
    }

    public void setFilaActual(int nuevaFila) {
        filaActual = nuevaFila;
    }

    public void actualizarImagen() {
        GreenfootImage imagen = new GreenfootImage("Bits: " + valor, 34, Color.WHITE,null);
        setImage(imagen);
    }
    
    public void actualizarValor(int valor) {
        this.valor = valor;
        actualizarImagen();
}
}

