
package patroncommand.model;

import patroncommand.command.PedidoCommand;

public class Pedido {

    private final int id;
    private PedidoCommand comando;
    private EstadoPedido estado;

    public Pedido(int id, PedidoCommand comando) {
        this.id = id;
        this.comando = comando;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public PedidoCommand getComando() {
        return comando;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void modificarComando(PedidoCommand nuevoComando) {
        this.comando = nuevoComando;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido #" + id
                + " | Producto: " + comando.getDescripcion()
                + " | Estado: " + estado;
    }
}