package com.empresa.servicios;

import com.empresa.modelo.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpaquetadoTest {

    @Test
    void testEmpaquetado() {
        Pedido pedido = new Pedido(1, false);
        Empaquetado empaquetado = new Empaquetado();

        assertDoesNotThrow(() -> empaquetado.empaquetarPedido(pedido));
    }
}
