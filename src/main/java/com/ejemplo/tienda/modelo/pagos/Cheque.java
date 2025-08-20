package com.ejemplo.tienda.modelo.pagos;

import com.ejemplo.tienda.modelo.Pago;

import java.math.BigDecimal;

public class Cheque extends Pago {
    private final String nombre;
    private final String bancoId;

    public Cheque(BigDecimal monto, String nombre, String bancoId) {
        super(monto);
        this.nombre = nombre;
        this.bancoId = bancoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBancoId() {
        return bancoId;
    }

    public boolean autorizado() {
        return nombre != null && !nombre.isBlank() && bancoId != null && !bancoId.isBlank();
    }
}

