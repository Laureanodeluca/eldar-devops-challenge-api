package com.eldar.demo.Tarjetas;
import com.eldar.demo.Auxiliares.Persona;
import java.util.Calendar;

public class AmericanExpress extends Tarjeta {
    public AmericanExpress(String numero, Persona cardHolder, int diaVencimiento, int mesVencimiento, int anioVencimiento) {
        super(numero, cardHolder, diaVencimiento, mesVencimiento, anioVencimiento);
        this.marca = "AMEX";
    }

    @Override
    public double getTasa() {
        double tasa = truncarTasa((fechaVencimiento.get(Calendar.MONTH)+1)*0.1);
        return Math.round(tasa*10.0)/10.0;
    }
}
