package com.ejemplo.tienda.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class DetallePedido {
    private final Articulo articulo;
    private final int cantidad;
    private final boolean estadoImpuesto;

    public DetallePedido(Articulo articulo, int cantidad, boolean estadoImpuesto) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("cantidad debe ser positiva");
        }
        this.articulo = Objects.requireNonNull(articulo, "articulo no puede ser nulo");
        this.cantidad = cantidad;
        this.estadoImpuesto = estadoImpuesto;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isEstadoImpuesto() {
        return estadoImpuesto;
    }

    public BigDecimal obtenerPrecioPorCantidad() {
        return articulo.obtenerPrecioPorCantidad(cantidad);
    }

    public boolean enAlmacen() {
        return articulo.enAlmacen(cantidad);
    }

    public BigDecimal calcularImpuesto(BigDecimal tasaImpuesto) {
        if (!estadoImpuesto) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        return obtenerPrecioPorCantidad()
            .multiply(tasaImpuesto)
            .setScale(2, RoundingMode.HALF_UP);
    }

    public double calcularPesoTotalKg() {
        return cantidad * articulo.getPesoUnitarioKg();
    }
}

