package com.empresa.servicios;

import com.empresa.modelo.Pedido;

public class Empaquetado {
    public void empaquetarPedido(Pedido pedido) {
        try {
            // Simular tiempo de empaquetado
            Thread.sleep(80);
            System.out.println("[EMPAQUETADO] Pedido empaquetado -" + pedido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
