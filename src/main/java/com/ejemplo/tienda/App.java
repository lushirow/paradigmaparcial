package com.ejemplo.tienda;

import com.ejemplo.tienda.modelo.*;
import com.ejemplo.tienda.modelo.pagos.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana Perez", "Calle Falsa 123");

        Articulo a1 = new Articulo("A1", "Teclado", new BigDecimal("25.50"), 0.7, 100);
        Articulo a2 = new Articulo("A2", "Mouse", new BigDecimal("11.90"), 0.2, 200);

        Pedido pedido = new Pedido(cliente, LocalDate.now(), "NUEVO");
        pedido.agregarLinea(new DetallePedido(a1, 2, true));
        pedido.agregarLinea(new DetallePedido(a2, 3, true));

        BigDecimal tasaIVA = new BigDecimal("0.21");
        System.out.println("Subtotal: " + pedido.calcSubTotal());
        System.out.println("Impuesto: " + pedido.calcImpuesto(tasaIVA));
        System.out.println("Total: " + pedido.calcMonto(tasaIVA));
        System.out.println("Peso total kg: " + pedido.calcPesoTotal());

        pedido.agregarPago(new Efectivo(pedido.calcMonto(tasaIVA), new BigDecimal("100.00")));
        pedido.agregarPago(new Cheque(new BigDecimal("0.00"), "Ana Perez", "B001"));
        pedido.agregarPago(new Tarjeta(new BigDecimal("0.00"), "4111111111111111", "VISA", YearMonth.now().plusYears(2)));

        System.out.println("Pagos registrados: " + pedido.getPagos().size());
    }
}

