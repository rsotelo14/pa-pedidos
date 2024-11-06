package com.empresa.servicios;

import com.empresa.modelo.Pedido;

import java.util.List;
import java.util.concurrent.*;

public class ProcesadorPedidos {

    // ExecutorServices para cada etapa y tipo de pedido
    private final ExecutorService pagoUrgenteExecutor;
    private final ExecutorService pagoNormalExecutor;
    private final ForkJoinPool empaquetadoPool;
    private final ExecutorService envioUrgenteExecutor;
    private final ExecutorService envioNormalExecutor;

    // CountDownLatch para esperar a que todos los pedidos se procesen
    private final CountDownLatch latch;

    public ProcesadorPedidos(int amount) {
        // Executor para Procesamiento de Pago de pedidos urgentes
        pagoUrgenteExecutor = Executors.newFixedThreadPool(5);

        // Executor para Procesamiento de Pago de pedidos normales
        pagoNormalExecutor = Executors.newFixedThreadPool(15);

        // ForkJoinPool para Empaquetado
        empaquetadoPool = new ForkJoinPool();

        // Executor para Envío de pedidos urgentes
        envioUrgenteExecutor = Executors.newFixedThreadPool(5);

        // Executor para Envío de pedidos normales
        envioNormalExecutor = Executors.newFixedThreadPool(15);

        // Inicializar el CountDownLatch con el número total de pedidos
        latch = new CountDownLatch(amount);
    }

    public void procesarPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            if (pedido.isUrgente()) {
                procesarPedidoUrgente(pedido);
            } else {
                procesarPedidoNormal(pedido);
            }
        }
    }

    private void procesarPedidoUrgente(Pedido pedido) {
        pagoUrgenteExecutor.submit(() -> {
            new ProcesamientoPago().procesarPago(pedido);

            empaquetadoPool.submit(() -> {
                new Empaquetado().empaquetarPedido(pedido);

                envioUrgenteExecutor.submit(() -> {
                    new Envio().procesarEnvio(pedido);
                    latch.countDown();
                });
            });
        });
    }

    private void procesarPedidoNormal(Pedido pedido) {
        pagoNormalExecutor.submit(() -> {
            new ProcesamientoPago().procesarPago(pedido);

            empaquetadoPool.submit(() -> {
                new Empaquetado().empaquetarPedido(pedido);

                envioNormalExecutor.submit(() -> {
                    new Envio().procesarEnvio(pedido);
                    latch.countDown();
                });
            });
        });
    }

    public void awaitCompletion() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        pagoUrgenteExecutor.shutdown();
        pagoNormalExecutor.shutdown();
        empaquetadoPool.shutdown();
        envioUrgenteExecutor.shutdown();
        envioNormalExecutor.shutdown();
    }
}
