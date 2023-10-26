import greenfoot.*;  

public class Bit extends Actor {
    private int value; 

    public Bit(int value) {
        this.value = value;
        setImage(value == 1 ? "bitPrendido.png" : "bitApagado.png"); 
    }
    
    public void actualizarImagen() {
    setImage(value == 1 ? "bitPrendido.png" : "bitApagado.png");
}
    
    public int getValue() {
        return value; 
    }
    
}
