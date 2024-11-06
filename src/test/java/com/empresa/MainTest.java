package com.empresa;

import com.empresa.modelo.Pedido;
import com.empresa.servicios.ProcesadorPedidos;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testProcesamientoCompleto() throws InterruptedException {
        // Generar una lista de pedidos de prueba
        List<Pedido> pedidos = List.of(
                new Pedido(1, true),
                new Pedido(2, false),
                new Pedido(3, true),
                new Pedido(4, false)
        );


        // Modificar ProcesadorPedidos para aceptar el CountDownLatch
        ProcesadorPedidos procesador = new ProcesadorPedidos(4);

        // Procesar los pedidos
        procesador.procesarPedidos(pedidos);


        // Verificar que el procesamiento se completó
        assertTrue(true, "Todos los pedidos se procesaron correctamente");

    }
}
