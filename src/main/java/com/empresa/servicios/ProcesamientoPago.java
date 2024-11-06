package com.empresa.servicios;

import com.empresa.modelo.Pedido;

public class ProcesamientoPago {
    public void procesarPago(Pedido pedido) {
        try {
            // Simular tiempo de procesamiento
            Thread.sleep(100);
            System.out.println("[PAGO] Pago procesado -" + pedido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
