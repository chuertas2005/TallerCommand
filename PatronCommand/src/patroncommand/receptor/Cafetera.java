
package patroncommand.receptor;

public class Cafetera {

    private boolean encendida;
    private int intensidad;

    public Cafetera() {
        this.encendida = false;
        this.intensidad = 2;
    }

    public void prender() {
        if (!encendida) {
            encendida = true;
            System.out.println("Cafetera encendida.");
        } else {
            System.out.println("La cafetera ya esta encendida.");
        }
    }

    public void apagar() {
        if (encendida) {
            encendida = false;
            System.out.println("Cafetera apagada.");
        } else {
            System.out.println("La cafetera ya esta apagada.");
        }
    }

    public void configurarIntensidad(int intensidad) {
        if (intensidad < 1 || intensidad > 5) {
            throw new IllegalArgumentException(
                "La intensidad debe estar entre 1 y 5."
            );
        }

        this.intensidad = intensidad;
        System.out.println("Intensidad configurada: " + intensidad);
    }

    public void prepararCafe() {
        if (!encendida) {
            System.out.println(
                "No se puede preparar cafe: la cafetera esta apagada."
            );
            return;
        }

        System.out.println(
            "Preparando cafe con intensidad " + intensidad + "..."
        );
        System.out.println("Cafe listo para servir.");
    }

    public boolean isEncendida() {
        return encendida;
    }
}
