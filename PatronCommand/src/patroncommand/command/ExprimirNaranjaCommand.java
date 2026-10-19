
package patroncommand.command;

import patroncommand.receptor.Exprimidor;

public class ExprimirNaranjaCommand implements PedidoCommand {

    private final Exprimidor exprimidor;

    public ExprimirNaranjaCommand(Exprimidor exprimidor) {
        this.exprimidor = exprimidor;
    }

    @Override
    public void ejecutar() {
        exprimidor.prender();

        try {
            exprimidor.exprimirNaranja();
        } finally {
            exprimidor.apagar();
        }
    }

    @Override
    public String getDescripcion() {
        return "Exprimir naranja";
    }
}
