
package patroncommand.cocina;

import patroncommand.command.PedidoCommand;
import patroncommand.model.EstadoPedido;
import patroncommand.model.Pedido;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cocina {

    private final Map<Integer, Pedido> pedidos = new LinkedHashMap<>();
    private int siguienteId = 1;

    public Pedido registrarPedido(PedidoCommand comando) {
        Pedido pedido = new Pedido(siguienteId++, comando);
        pedidos.put(pedido.getId(), pedido);

        System.out.println("Pedido registrado: " + pedido);
        return pedido;
    }

    public void ejecutarPedido(int id) {
        Pedido pedido = pedidos.get(id);

        if (pedido == null) {
            System.out.println("Error: no existe el pedido #" + id);
            return;
        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println(
                    "No se puede preparar el pedido #" + id
                    + ". Estado actual: " + pedido.getEstado()
            );
            return;
        }

        pedido.setEstado(EstadoPedido.EN_PREPARACION);

        System.out.println("\nIniciando pedido #" + id + "...");
        pedido.getComando().ejecutar();

        pedido.setEstado(EstadoPedido.PREPARADO);

        System.out.println("Pedido #" + id + " finalizado.");
    }

    public void cancelarPedido(int id) {
        Pedido pedido = pedidos.get(id);

        if (pedido == null) {
            System.out.println("Error: no existe el pedido #" + id);
            return;
        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println(
                    "No se puede cancelar el pedido #" + id
                    + ". Solo se permiten cancelaciones pendientes."
            );
            return;
        }

        pedido.setEstado(EstadoPedido.CANCELADO);

        System.out.println("Pedido #" + id + " cancelado.");
    }

    public void modificarPedido(
            int id,
            PedidoCommand nuevoComando) {

        Pedido pedido = pedidos.get(id);

        if (pedido == null) {
            System.out.println("Error: no existe el pedido #" + id);
            return;
        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println(
                    "No se puede modificar el pedido #" + id
                    + ". Solo se permiten cambios en pedidos pendientes."
            );
            return;
        }

        pedido.modificarComando(nuevoComando);

        System.out.println(
                "Pedido #" + id + " modificado: "
                + nuevoComando.getDescripcion()
        );
    }

    public void mostrarPedidos() {
        System.out.println("\n--- Estado de los pedidos ---");

        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos.values()) {
            System.out.println(pedido);
        }
    }
}
