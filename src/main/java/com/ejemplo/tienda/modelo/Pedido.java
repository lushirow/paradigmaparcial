package com.ejemplo.tienda.modelo;

import com.ejemplo.tienda.modelo.pagos.Cheque;
import com.ejemplo.tienda.modelo.pagos.Efectivo;
import com.ejemplo.tienda.modelo.pagos.Tarjeta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private final Cliente cliente;
    private final LocalDate fecha;
    private String estado;
    private final List<DetallePedido> lineas;
    private final List<Pago> pagos;

    public Pedido(Cliente cliente, LocalDate fecha, String estado) {
        this.cliente = Objects.requireNonNull(cliente, "cliente no puede ser nulo");
        this.fecha = Objects.requireNonNull(fecha, "fecha no puede ser nula");
        this.estado = Objects.requireNonNullElse(estado, "NUEVO");
        this.lineas = new ArrayList<>();
        this.pagos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getLineas() {
        return List.copyOf(lineas);
    }

    public List<Pago> getPagos() {
        return List.copyOf(pagos);
    }

    public void agregarLinea(DetallePedido detalle) {
        lineas.add(Objects.requireNonNull(detalle));
    }

    public void agregarPago(Pago pago) {
        pagos.add(Objects.requireNonNull(pago));
    }

    public BigDecimal calcSubTotal() {
        return lineas.stream()
            .map(DetallePedido::obtenerPrecioPorCantidad)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcImpuesto(BigDecimal tasaImpuesto) {
        return lineas.stream()
            .map(l -> l.calcularImpuesto(tasaImpuesto))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcMonto(BigDecimal tasaImpuesto) {
        return calcSubTotal().add(calcImpuesto(tasaImpuesto)).setScale(2, RoundingMode.HALF_UP);
    }

    public double calcPesoTotal() {
        return lineas.stream().mapToDouble(DetallePedido::calcularPesoTotalKg).sum();
    }
}

