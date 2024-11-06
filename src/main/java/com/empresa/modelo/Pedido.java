package com.empresa.modelo;

public class Pedido {
    private final int id;
    private final boolean urgente;
    public static final String RESET = "\u001B[0m";   // Resetea el color al final
    public static final String RED = "\u001B[31m";    // Color rojo
    public static final String GREEN = "\u001B[32m";  // Color verde



    public Pedido(int id, boolean urgente) {
        this.id = id;
        this.urgente = urgente;
    }

    public int getId() {
        return id;
    }

    public boolean isUrgente() {
        return urgente;
    }

    @Override
    public String toString() {
        // Asigna el color dependiendo de si el pedido es urgente o no
        String color = isUrgente() ? RED : GREEN;  // Rojo para urgentes, verde para normales
        return "Pedido " + id + " (urgente: " + color + isUrgente() + RESET + ")";
    }
}
