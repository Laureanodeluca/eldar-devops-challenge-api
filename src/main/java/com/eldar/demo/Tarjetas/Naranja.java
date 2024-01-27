package com.eldar.demo.Tarjetas;
import java.lang.Math;
import java.util.Calendar;
import com.eldar.demo.Auxiliares.Persona;

public class Naranja extends Tarjeta {
    public Naranja(String numero, Persona cardHolder, int diaVencimiento, int mesVencimiento, int anioVencimiento) {
        super(numero, cardHolder, diaVencimiento, mesVencimiento, anioVencimiento);
        this.marca = "NARA";
    }
    
    @Override
    public double getTasa() {
        double tasa = truncarTasa(fechaVencimiento.get(Calendar.DAY_OF_MONTH)*0.5);
        return Math.round(tasa*10.0)/10.0;
    }
}