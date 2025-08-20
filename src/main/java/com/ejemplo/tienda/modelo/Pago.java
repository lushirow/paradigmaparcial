package com.ejemplo.tienda.modelo;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Pago {
    private final BigDecimal monto;

    protected Pago(BigDecimal monto) {
        this.monto = Objects.requireNonNull(monto, "monto no puede ser nulo");
    }

    public BigDecimal getMonto() {
        return monto;
    }
}

