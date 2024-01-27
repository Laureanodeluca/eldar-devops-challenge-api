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
        Tarjeta amex_copy = new AmericanExpress("3047 8500 5679 9696", new Persona("Pablo", "López"), 26, 7, 2024);

        Operacion o1 = new Operacion(759, amex);
        Operacion o3 = new Operacion(880, naranja);

        System.out.println("========= EJERCICIO 1 =========");
        System.out.println("a. Invocar un método que devuelva toda la información de una tarjeta:");
        System.out.println(visa.getInfo());

        System.out.println("\nb. Informar si una operacion es válida:");
        if (o1.esValida())
            System.out.println("La operación o1 es válida. (Marca: "+o1.getTarjeta().getMarca()+", monto:"+o1.getMonto()+")");
        else
            System.out.println("La operación o1 es invalida. (Marca: "+o1.getTarjeta().getMarca()+", monto:"+o1.getMonto()+")");

        System.out.println("\nc. Informar si una tarjeta es válida para operar:");
        if (naranja.esValidaParaOperar())
            System.out.println("La tarjeta naranja es válida para operar. (Fecha de vencimiento: "+naranja.toStringVencimiento()+")");
        else
            System.out.println("La tarjeta naranja no es válida para operar. (Fecha de vencimiento: "+naranja.toStringVencimiento()+")");

        System.out.println("\nd. Informar si una tarjeta es distinta a otra:");
        System.out.println("Son distintas (amex y naranja): "+sonDistintas(amex, naranja));
        System.out.println("Son distintas (amex y amex_copy): "+sonDistintas(amex, amex_copy));

        System.out.println("\ne. Obtener, por medio de un método, la tasa de una operación informando marca e importe: ");
        System.out.println(getTasaDeOperacionDetallada(o3));


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
            String toReturn = "Marca: " + o.getTarjeta().getMarca() + "\nMonto: "+o.getMonto();;
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