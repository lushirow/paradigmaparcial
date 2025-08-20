package com.ejemplo.tienda.modelo;

import java.util.Objects;

public class Cliente {
    private final String nombre;
    private final String domicilio;

    public Cliente(String nombre, String domicilio) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser nulo");
        this.domicilio = Objects.requireNonNull(domicilio, "domicilio no puede ser nulo");
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }
}

