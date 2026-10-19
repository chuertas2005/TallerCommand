
package patroncommand.command;

import patroncommand.receptor.Cafetera;

public class PrepararCafeCommand implements PedidoCommand {

    private final Cafetera cafetera;

    public PrepararCafeCommand(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    @Override
    public void ejecutar() {
        cafetera.prender();

        try {
            cafetera.prepararCafe();
        } finally {
            cafetera.apagar();
        }
    }

    @Override
    public String getDescripcion() {
        return "Preparar cafe";
    }
}
