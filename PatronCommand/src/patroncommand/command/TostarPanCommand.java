
package patroncommand.command;

import patroncommand.receptor.Tostadora;

public class TostarPanCommand implements PedidoCommand {

    private final Tostadora tostadora;

    public TostarPanCommand(Tostadora tostadora) {
        this.tostadora = tostadora;
    }

    @Override
    public void ejecutar() {
        tostadora.prender();

        try {
            tostadora.tostarPan();
        } finally {
            tostadora.apagar();
        }
    }

    @Override
    public String getDescripcion() {
        return "Tostar pan";
    }
}
