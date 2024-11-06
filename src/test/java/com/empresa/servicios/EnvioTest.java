
package com.empresa.servicios;

import com.empresa.modelo.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvioTest {

    @Test
    void testEnvio() {
        Pedido pedido = new Pedido(1, false);
        Envio envio = new Envio();

        assertDoesNotThrow(() -> envio.procesarEnvio(pedido));
    }
}
