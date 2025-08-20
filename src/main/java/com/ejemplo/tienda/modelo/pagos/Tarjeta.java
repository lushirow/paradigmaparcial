package com.ejemplo.tienda.modelo.pagos;

import com.ejemplo.tienda.modelo.Pago;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Tarjeta extends Pago {
    private final String numero;
    private final String tipo;
    private final YearMonth expira;

    public Tarjeta(BigDecimal monto, String numero, String tipo, YearMonth expira) {
        super(monto);
        this.numero = numero;
        this.tipo = tipo;
        this.expira = expira;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public YearMonth getExpira() {
        return expira;
    }

    public boolean autorizado() {
        return numero != null && numero.length() >= 12 && expira != null && !YearMonth.now().isAfter(expira);
    }
}

