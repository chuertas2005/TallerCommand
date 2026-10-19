
package patroncommand.receptor;

public class Exprimidor {

    private boolean encendido;
    private int velocidad;

    public Exprimidor() {
        this.encendido = false;
        this.velocidad = 2;
    }

    public void prender() {
        if (!encendido) {
            encendido = true;
            System.out.println("Exprimidor encendido.");
        } else {
            System.out.println("El exprimidor ya esta encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("Exprimidor apagado.");
        } else {
            System.out.println("El exprimidor ya esta apagado.");
        }
    }

    public void configurarVelocidad(int velocidad) {
        if (velocidad < 1 || velocidad > 3) {
            throw new IllegalArgumentException(
                "La velocidad debe estar entre 1 y 3."
            );
        }

        this.velocidad = velocidad;
        System.out.println("Velocidad configurada: " + velocidad);
    }

    public void exprimirNaranja() {
        if (!encendido) {
            System.out.println(
                "No se puede exprimir: el exprimidor esta apagado."
            );
            return;
        }

        System.out.println(
            "Exprimiendo naranjas a velocidad " + velocidad + "..."
        );
        System.out.println("Zumo de naranja listo para servir.");
    }

    public boolean isEncendido() {
        return encendido;
    }
}
