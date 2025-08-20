package com.ejemplo.tienda.modelo.pagos;

import com.ejemplo.tienda.modelo.Pago;

import java.math.BigDecimal;

public class Efectivo extends Pago {
    private final BigDecimal efectivoEntregado;

    public Efectivo(BigDecimal monto, BigDecimal efectivoEntregado) {
        super(monto);
        this.efectivoEntregado = efectivoEntregado;
    }

    public BigDecimal getEfectivoEntregado() {
        return efectivoEntregado;
    }
}

