package com.eldar.demo.Auxiliares;

import com.eldar.demo.Excepciones.OperacionInvalidaException;
import com.eldar.demo.Excepciones.TarjetaInvalidaParaOperarException;
import com.eldar.demo.Tarjetas.Tarjeta;

public class Operacion {
    private double monto;
    private Tarjeta tarjeta;

    public Operacion(double monto, Tarjeta tarjeta) {
        this.monto = monto;
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public boolean esValida() {
        return monto < 1000;
    }

    /**
     * Obtiene la tasa de una operacion.
     * @return Monto total teniendo en cuenta la tasa de la tarjeta. 
     */
    public double getTasaDeOperacion() throws  OperacionInvalidaException, TarjetaInvalidaParaOperarException{
        if (!esValida())
            throw new OperacionInvalidaException("getTasaDeOperacion(): El monto supera el límite ("+monto+")");
        
        if (!tarjeta.esValidaParaOperar())
            throw new TarjetaInvalidaParaOperarException("getTasaDeOperacion(): La tarjeta está vencida.");
        

        double aux = (monto*tarjeta.getTasa())/100;
        return Math.round(aux*100.0)/100.0;
    }
}
