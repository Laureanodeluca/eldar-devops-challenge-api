package com.eldar.demo;
import com.eldar.demo.Auxiliares.Operacion;
import com.eldar.demo.Auxiliares.Persona;
import com.eldar.demo.Excepciones.OperacionInvalidaException;
import com.eldar.demo.Excepciones.TarjetaInvalidaParaOperarException;
import com.eldar.demo.Tarjetas.AmericanExpress;
import com.eldar.demo.Tarjetas.Naranja;
import com.eldar.demo.Tarjetas.Tarjeta;
import com.eldar.demo.Tarjetas.Visa;

public class Ejecutable {
    public static void main(String args[]){
        Tarjeta visa = new Visa("4575 5700 9600 3596",new Persona("Juan", "Perez"), 31,12,2029);
        Tarjeta naranja = new Naranja("7655 0923 7488 9699", new Persona("Martina", "Gonzalez"),30,2,2029);
        Tarjeta amex = new AmericanExpress("3047 8500 5679 9696", new Persona("Pablo", "López"), 26, 7, 2024);

        Operacion o1 = new Operacion(759, amex);
        Operacion o2 = new Operacion(150, visa);
        Operacion o3 = new Operacion(180, naranja);

        System.out.println("========= INFORMACION DE LAS TARJETAS =========");
        System.out.println(visa.getInfo());
        System.out.println("\n"+naranja.getInfo());
        System.out.println("\n"+amex.getInfo());
        
        System.out.println("\n========= INFORMACION DE LAS OPERACIONES =========");
        System.out.println(getTasaDeOperacionDetallada(o1));
        System.out.println("\n"+getTasaDeOperacionDetallada(o2));
        System.out.println("\n"+getTasaDeOperacionDetallada(o3));

    }    

    /**
     * Chequea que dos tarjetas sean diferentes una de otra.
     * @param t1 Tarjeta 1
     * @param t2 Tarjeta 2
     * @return True si las tarjetas son diferentes. False si no lo es. 
     */
    public static boolean sonDistintas(Tarjeta t1, Tarjeta t2) {
        boolean toReturn = true;
        if (t1.getNumero().equals(t2.getNumero())) {
            if (t1.getCardHolder().getApellido().equals(t2.getCardHolder().getApellido()) && t1.getCardHolder().getNombre().equals(t2.getCardHolder().getNombre())) {
                if (t1.getMarca().equals(t2.getMarca())) {
                    if (t1.getVencimiento().equals(t2.getVencimiento())) {
                        toReturn = false;
                    }
                }
            }
        }
        return toReturn;
    }

    /**
     * Obtiene la tasa de la operacion con todos sus detalles.
     * @param monto Monto de la operacion.
     * @param t Tarjeta de la operacion.
     * @return Informacion sobre la operacion (importe, tasa, tarjeta).
     */
    public static String getTasaDeOperacionDetallada(Operacion o) {
        try {
            String toReturn = "Marca: " + o.getTarjeta().getMarca() + "\nMonto: "+o.getMonto();
            double tasa = o.getTasaDeOperacion();
            toReturn = toReturn + "\nTasa ("+o.getTarjeta().getTasa()+"%): " + tasa + "\nIMPORTE TOTAL: " + (o.getMonto() + tasa);
            return toReturn;
        }
        catch (OperacionInvalidaException | TarjetaInvalidaParaOperarException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}