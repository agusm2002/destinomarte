import greenfoot.*;

public class Izquierda extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("carta.wav");
            MyWorld world = (MyWorld) getWorld();
            Nave nave = world.getObjects(Nave.class).get(0);
            int filaActual = nave.filaActual;

            if (filaActual >= 0 && filaActual < world.getContadores().length) {
                int[] contadores = world.getContadores();
                int bitsEncendidosEnFila = contadores[filaActual];

                if ((bitsEncendidosEnFila & 1) != 0) {
                    contadores[filaActual] += 1;
                }

                if ((bitsEncendidosEnFila & 2) != 0) {
                    contadores[filaActual] += 2;
                }

                if ((bitsEncendidosEnFila & 4) != 0) {
                    contadores[filaActual] += 4;
                }

                if ((bitsEncendidosEnFila & 8) != 0) {
                    contadores[filaActual] -= 7;
                }

                nave.setBitsAcumulados(contadores[filaActual]);
                world.actualizarBitsEnEscenario();
                BitsContador bitsContador = world.getObjects(BitsContador.class).get(0);
                bitsContador.setValor(contadores[filaActual]);
                world.actualizarTexto();

                world.reducirTiempo(50);
            }
        }
    }
}
