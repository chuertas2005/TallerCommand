
package patroncommand;

import patroncommand.cocina.Cocina;
import patroncommand.usuario.Mesero;

import patroncommand.receptor.Cafetera;
import patroncommand.receptor.Tostadora;
import patroncommand.receptor.Exprimidor;

import patroncommand.command.PrepararCafeCommand;
import patroncommand.command.TostarPanCommand;
import patroncommand.command.ExprimirNaranjaCommand;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   SISTEMA DE PEDIDOS CAFETERIA");
        System.out.println("==================================\n");

        Cafetera cafetera = new Cafetera();
        Tostadora tostadora = new Tostadora();
        Exprimidor exprimidor = new Exprimidor();

        System.out.println("--- Configuracion de equipos ---");

        cafetera.configurarIntensidad(4);

        tostadora.configurarTemperatura(200);
        tostadora.configurarTiempo(4);

        exprimidor.configurarVelocidad(3);

        // Crear comandos 
        PrepararCafeCommand prepararCafe =
                new PrepararCafeCommand(cafetera);

        TostarPanCommand tostarPan =
                new TostarPanCommand(tostadora);

        ExprimirNaranjaCommand exprimirNaranja =
                new ExprimirNaranjaCommand(exprimidor);

        //cocina y mesero
        Cocina cocina = new Cocina();
        Mesero mesero = new Mesero(cocina);
        //casos
        System.out.println("\n--- Caso 1: Pedido de cafe ---");

        int pedido1 = mesero.tomarPedido(prepararCafe);
        mesero.enviarPedido(pedido1);

        System.out.println("\n--- Caso 2: Modificar pedido ---");

        int pedido2 = mesero.tomarPedido(tostarPan);

        mesero.modificarPedido(pedido2, exprimirNaranja);
        mesero.enviarPedido(pedido2);

        System.out.println("\n--- Caso 3: Cancelar pedido ---");

        int pedido3 = mesero.tomarPedido(tostarPan);
        mesero.cancelarPedido(pedido3);

        System.out.println("\n--- Caso 4: Cancelacion no permitida ---");

        mesero.cancelarPedido(pedido1);

        System.out.println("\n--- Estado final de los pedidos ---");

        mesero.consultarPedidos();

        System.out.println("\n==================================");
        System.out.println("       FIN DEL PROGRAMA");
        System.out.println("==================================");
    }
}
