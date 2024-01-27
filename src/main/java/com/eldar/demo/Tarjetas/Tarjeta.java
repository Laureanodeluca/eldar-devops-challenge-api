package com.eldar.demo.Tarjetas;

import com.eldar.demo.Auxiliares.Persona;
import java.util.Calendar;

public abstract class Tarjeta {
    protected String marca;
    protected String numero;
    protected Persona cardHolder;
    protected Calendar fechaVencimiento;
    
    /**
     * No chequea que la fecha sea valida.
     */
    public Tarjeta(String numero, Persona cardHolder, int diaVencimiento, int mesVencimiento, int anioVencimiento) {
        this.numero = numero;
        this.cardHolder = cardHolder;
        fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.set(anioVencimiento, mesVencimiento-1, diaVencimiento, 0, 0);
    }

    /**
     * Obtiene la tasa de la tarjeta. 
     * @return Tasa de la tarjeta.
     */
    public abstract double getTasa();

    public String getMarca() {
        return marca;
    }

    public String getNumero() {
        return numero;
    }

    public Persona getCardHolder() {
        return cardHolder;
    }

    public String toStringVencimiento() {
        return fechaVencimiento.get(Calendar.DAY_OF_MONTH)+"/"+(fechaVencimiento.get(Calendar.MONTH)+1)+"/"+fechaVencimiento.get(Calendar.YEAR)%100;
    }

    public Calendar getVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Trunca la tasa al valor máximo y minimo de tasa (0.3% mínimo y 5% máximo)
     * @param tasa tasa a truncar.
     * @return tasa truncada.
     */
    protected double truncarTasa(double tasa) {
        if (tasa > 5)
            tasa = 5;
        else
            if (tasa < 0.3)
                tasa = 0.3;
        return tasa;
    }

    /**
     * Retorna un String con toda la información de la tarjeta de crédito.
     * @return String conteniendo información de la tarjeta.
     */
    public String getInfo() {
        return "Numero: "+ numero +
            "\nDueño: "+ cardHolder.getNombre() + " " + cardHolder.getApellido()+
            "\nMarca: " + marca + 
            "\nVencimiento: " + toStringVencimiento() +
            "\nTasa: " + getTasa() +
            "%\nVálida para operar: " + esValidaParaOperar();
    }

    /**
     * Chequea que la tarjeta esté válida para operar. Es decir, chequea que la tarjeta no esté vencida.
     * @return True si la tarjeta no está vencida. False si lo está. 
     */
    public boolean esValidaParaOperar() {
        Calendar hoy = Calendar.getInstance();
        hoy.set(Calendar.HOUR_OF_DAY, 0);
        return fechaVencimiento.after(hoy);
    }
}