package com.eldar.demo.Tarjetas;
import java.lang.Math;
import com.eldar.demo.Auxiliares.Persona;
import java.util.Calendar;
public class Visa extends Tarjeta {
    public Visa(String numero, Persona cardHolder, int diaVencimiento, int mesVencimiento, int anioVencimiento) {
        super(numero,cardHolder,diaVencimiento,mesVencimiento,anioVencimiento);
        this.marca = "VISA";
    }

    @Override
    public double getTasa() {
        Calendar cal = Calendar.getInstance();
        double tasa = truncarTasa((double)cal.get(Calendar.YEAR)%100/(cal.get(Calendar.MONTH)+1));
        return Math.round(tasa*10.0)/10.0;
    }
}