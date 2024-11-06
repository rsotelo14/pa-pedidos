package com.empresa.servicios;

import com.empresa.modelo.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesamientoPagoTest {

    @Test
    void testProcesarPago() {
        Pedido pedido = new Pedido(1, false);
        ProcesamientoPago procesamientoPago = new ProcesamientoPago();

        assertDoesNotThrow(() -> procesamientoPago.procesarPago(pedido));
    }
}
