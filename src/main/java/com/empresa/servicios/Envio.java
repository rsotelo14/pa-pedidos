package com.empresa.servicios;

import com.empresa.modelo.Pedido;

public class Envio {

    public void procesarEnvio(Pedido pedido) {
        // Simular procesamiento de envío
        try {
            Thread.sleep(50); // Simula tiempo de envío
            System.out.println("[ENVÍO] Pedido enviado -" + pedido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
