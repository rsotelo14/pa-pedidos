package com.empresa;

import com.empresa.modelo.Pedido;
import com.empresa.servicios.ProcesadorPedidos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int amount = 100;
        List<Pedido> listaPedidos = generarPedidos(amount);

        ProcesadorPedidos procesador = new ProcesadorPedidos(amount);

        procesador.procesarPedidos(listaPedidos);

        // Esperar a que todos los pedidos se procesen antes de cerrar los ejecutores
        procesador.awaitCompletion();

        // Cerrar los ejecutores de forma ordenada
        procesador.shutdown();
    }

    private static List<Pedido> generarPedidos(int amount) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            boolean urgente = (i % 10 == 0); // Cada 10 pedidos es urgente
            pedidos.add(new Pedido(i, urgente));
        }
        return pedidos;
    }
}
