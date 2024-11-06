package com.empresa.servicios;

import com.empresa.modelo.Pedido;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private final Pedido pedido;
    private final Runnable task;

    public PrioritizedTask(Pedido pedido, Runnable task) {
        this.pedido = pedido;
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }

    @Override
    public int compareTo(PrioritizedTask other) {
        if (this.pedido.isUrgente() && !other.pedido.isUrgente()) {
            return -1;
        } else if (!this.pedido.isUrgente() && other.pedido.isUrgente()) {
            return 1;
        } else {
            return Integer.compare(this.pedido.getId(), other.pedido.getId());
        }
    }
}
