
package patroncommand.receptor;

public class Tostadora {

    private boolean encendida;
    private int temperatura;
    private int tiempoTostado;

    public Tostadora() {
        this.encendida = false;
        this.temperatura = 180;
        this.tiempoTostado = 3;
    }

    public void prender() {
        if (!encendida) {
            encendida = true;
            System.out.println("Tostadora encendida.");
        } else {
            System.out.println("La tostadora ya esta encendida.");
        }
    }

    public void apagar() {
        if (encendida) {
            encendida = false;
            System.out.println("Tostadora apagada.");
        } else {
            System.out.println("La tostadora ya esta apagada.");
        }
    }

    public void configurarTemperatura(int temperatura) {
        if (temperatura < 100 || temperatura > 250) {
            throw new IllegalArgumentException(
                "La temperatura debe estar entre 100 y 250 grados."
            );
        }

        this.temperatura = temperatura;
        System.out.println(
            "Temperatura configurada: " + temperatura + " grados."
        );
    }

    public void configurarTiempo(int minutos) {
        if (minutos < 1 || minutos > 10) {
            throw new IllegalArgumentException(
                "El tiempo debe estar entre 1 y 10 minutos."
            );
        }

        this.tiempoTostado = minutos;
        System.out.println("Tiempo de tostado: " + minutos + " minutos.");
    }

    public void tostarPan() {
        if (!encendida) {
            System.out.println(
                "No se puede tostar pan: la tostadora esta apagada."
            );
            return;
        }

        System.out.println(
            "Tostando pan a " + temperatura + " grados durante "
            + tiempoTostado + " minutos..."
        );
        System.out.println("Pan tostado listo para servir.");
    }

    public boolean isEncendida() {
        return encendida;
    }
}
