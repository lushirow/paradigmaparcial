package com.ejemplo.tienda.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Articulo {
    private final String codigo;
    private final String descripcion;
    private final BigDecimal precioUnitario;
    private final double pesoUnitarioKg;
    private int stockDisponible;

    public Articulo(String codigo, String descripcion, BigDecimal precioUnitario, double pesoUnitarioKg, int stockDisponible) {
        this.codigo = Objects.requireNonNull(codigo, "codigo no puede ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion, "descripcion no puede ser nula");
        this.precioUnitario = Objects.requireNonNull(precioUnitario, "precioUnitario no puede ser nulo");
        this.pesoUnitarioKg = pesoUnitarioKg;
        this.stockDisponible = stockDisponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPesoUnitarioKg() {
        return pesoUnitarioKg;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void ajustarStock(int delta) {
        this.stockDisponible += delta;
    }

    public BigDecimal obtenerPrecioPorCantidad(int cantidad) {
        return precioUnitario
            .multiply(BigDecimal.valueOf(cantidad))
            .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean enAlmacen(int cantidad) {
        return stockDisponible >= cantidad;
    }
}

