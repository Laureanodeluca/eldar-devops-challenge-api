package com.eldar.demo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eldar.demo.Auxiliares.Operacion;
import com.eldar.demo.Excepciones.OperacionInvalidaException;
import com.eldar.demo.Excepciones.TarjetaInvalidaParaOperarException;
import com.eldar.demo.Tarjetas.AmericanExpress;
import com.eldar.demo.Tarjetas.Naranja;
import com.eldar.demo.Tarjetas.Tarjeta;
import com.eldar.demo.Tarjetas.Visa;

@SpringBootApplication
@RestController
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

  @GetMapping("/tasaOperacion")
    public Object getInfoTarjeta(@RequestParam String marca, @RequestParam double importe) throws NullPointerException{
      Map<String,Object> object = new HashMap<String,Object>();
      Tarjeta t;
      Operacion o;
      Calendar cal = Calendar.getInstance();
      if (marca.equals("visa")) //Esto es un espanto, pero cambiarlo a esta altura sería demasiado...Creo una tarjeta dummy dependiendo de la marca recibida.
        t = new Visa(null, null, cal.get(Calendar.DAY_OF_MONTH)+1, cal.get(Calendar.MONTH)+2, cal.get(Calendar.YEAR)+1);
      else {
        if (marca.equals("naranja"))
          t = new Naranja(null, null, cal.get(Calendar.DAY_OF_MONTH)+1, cal.get(Calendar.MONTH)+2, cal.get(Calendar.YEAR)+1);
        else {
          if (marca.equals("amex"))
            t = new AmericanExpress(null, null, cal.get(Calendar.DAY_OF_MONTH)+1, cal.get(Calendar.MONTH)+2, cal.get(Calendar.YEAR)+1);
          else
            t = null;
        }
      }

      o = new Operacion(importe, t);
      if (t == null) {
        object.put("error","Bad request");
      }
      else {
        try {
          object.put("marca",t.getMarca());
          object.put("tasa",o.getTasaDeOperacion());
        }
        catch (OperacionInvalidaException | TarjetaInvalidaParaOperarException ex) {
          object.put("error",ex.getMessage());
          ex.printStackTrace();
        }
      }
      return object;
    }
}
