
package patroncommand.usuario;

import patroncommand.cocina.Cocina;
import patroncommand.command.PedidoCommand;
import patroncommand.model.Pedido;

public class Mesero {

    private final Cocina cocina;

    public Mesero(Cocina cocina) {
        this.cocina = cocina;
    }

    public int tomarPedido(PedidoCommand comando) {
        Pedido pedido = cocina.registrarPedido(comando);
        return pedido.getId();
    }

    public void enviarPedido(int id) {
        cocina.ejecutarPedido(id);
    }

    public void cancelarPedido(int id) {
        cocina.cancelarPedido(id);
    }

    public void modificarPedido(
            int id,
            PedidoCommand nuevoComando) {

        cocina.modificarPedido(id, nuevoComando);
    }

    public void consultarPedidos() {
        cocina.mostrarPedidos();
    }
}