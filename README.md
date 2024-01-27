# Eldar DevOps Challenge
Este código es la implementación de una API REST para el desafío propuesto. En este mismo repositorio están las soluciones de todos los ejercicios. Para ver las soluciones, leer este Readme.


## Ejercicio 1
Para el ejercicio 1 se solicitó realizar un programa de prueba que tenga tres objetos de tipo `Tarjeta` y que haga diversas operaciones. Para realizar este ejercicio tuve que implementar varias cosas: 

- Una clase abstracta `Tarjeta`.
- Clases `Visa`, `Naranja` y `AmericanExpress`, que extienden a `Tarjeta`.
- Clase `Persona` (Cada tarjeta tiene un dueño).
- Clase `Operación` (Una operación tiene un monto y una tasa).
- Excepciones
- Un archivo de java que ejecute las tareas que pedía el ejercicio 1 (`Ejecutable.jar`).

Todos los archivos se encuentran en el directorio `src/main/java/com/eldar/demo`. Para ejecutar las tareas requeridas por el ejercicio 1, ejecutar el archivo `Ejecutable.java`. 

## Ejercicio 2
Para la implementación del ejercicio 2, se solicitó una Api REST que devuelva la tasa de una operación, informando la marca de la tarjeta y el importe. Para eso, se creo una API con SpringBoot. Y se hosteó en Render. 

La URL de la API es: https://eldar-devops-challenge.onrender.com/. Para poder obtener la tasa de una operación, usar el endpoint `/tasaOperacion`. Hay que ingresar la marca de la tarjeta y el importe, por lo que las consultas tienen siempre la siguiente forma:

```
https://eldar-devops-challenge.onrender.com/tasaOperacion?marca=<MARCA>&importe=<IMPORTE>
```

Dónde: 

- `<MARCA>`: Puede ser cualquiera de las siguientes: `visa`, `amex`, `nara`.
- `<IMPORTE>`: Puede ser cualquier valor entre 0 y 999.

## Ejercicio 3
> La tabla de empleados tiene un total de 107 registros. ¿Cuántos imprime la siguiente consulta?
> ```
> DECLARE
>     CURSOR exp_cur IS
>     SELECT first_name FROM employees; TYPE
>     nt_fName IS TABLE OF VARCHAR2(20);
>     fname nt_fName;
> BEGIN
>     OPEN exp_cur;
>     FETCH exp_cur BULK COLLECT INTO fname
> LIMIT 10;
>     CLOSE exp_cur;
>     FOR idx IN 1 .. fname.COUNT
>     LOOP
>         DBMS_OUTPUT.PUT_LINE (idx||'
> '||fname(idx) );
>     END LOOP;
> END;
> ```
> - 10
> - 100
> - 107
> - 0
> - 105

**RESPUESTA:** 10.

<Details>
<Summary>Explicación</Summary>
<br>
Se puede desglosar este código en varias partes para entender qué es lo que hace:

```
CURSOR exp_cur IS
SELECT first_name FROM employees;
```
Se define un cursor llamado `exp_cur`. Este selecciona la columna `first_name` de la tabla `employees`.

Un cursor es una estructura de control que sirve para apuntar y seleccionar una fila de datos de un result set dado.

```
TYPE nt_fName IS TABLE OF VARCHAR2(20);
```
Se define un tipo de tabla llamado `nt_fName`. Es una tabla de cadenas de texto (`VARCHAR2`), de un tamaño máximo de 20 caracteres.

```
fname nt_fName
```

Se crea una variable llamada `fname`, de tipo de tabla `nt_fName` (el tipo de tabla creado arriba).

```
OPEN exp_cur
```

Se abre el cursor. Los cursores se abren para comenzar a recuperar datos.

```
FETCH exp_cur BULK COLLECT INTO fname LIMIT 10
```

Se recuperan 10 filas del cursor y se almacenan en la variable `fname`, usando la cláusula `BULK COLLECT INTO`.

```
CLOSE exp_cur;
```

Se cierra el cursor. 

```
FOR idx IN 1 .. fname.COUNT
LOOP
    DBMS_OUTPUT.PUT_LINE (idx||' '||fname(idx));
END LOOP;
```
Se usa un bucle `FOR` para iterar a través de los elementos de la variable `fname`. Se imprime cada nombre junto con su índice usando `DBMS_OUTPUT.PUT_LINE`. Este for itera sobre todos los elementos de `fname`. Por como fue creado y llenado `fname`, sabemos que este bucle siempre va a imprimir 10 elementos.

</Details>

## Ejercicio 4
> ¿Qué es cierto acerca de la siguiente función?
> ```
> Create or Replace function Get_salary(P_Emp_id Number) Return Number As
> L_salary Number;
> Begin
>     Select Salary into L_salary from Employees where employee_id = P_Emp_Id;
> End Get_salary;
> ```
> - Le falta un retorno, por lo que no compila.
> - Se compilará
> - Devuelve el valor de P_Emp_Id.
> - Falta la sección de declaración.
> - Habrá un error en tiempo de ejecución. 

**RESPUESTA:** Le falta un retorno, por lo que no compila.

<Details>
<Summary>Explicación</Summary>
    
En el header de la función dice que retorna un `Number`, pero la función no retorna nada. 
</Details>

## Ejercicio 5
> Dada un array de strings, unir todos los elementos del array con espacios, convierta todas las letras a minúsculas y envíe el resultado a 'stdout'.
> Ejemplo:
> ```
>     my_array = ["FirstWord,"SecondWord","THIRDWORD"]
>     Resultado esperado: "firstword secondword thirdword" sin comillas
> ```
> Restricciones:
> - La longitud de la matriz no supera los 10
> - Cada elemento del array contiene una cadena de letras en inglés, solo ascii\[a-z,A-Z] y espacio, ascii\[32]

La resolución decidí hacerla en Java. El código depende de si se tiene acceso a la librería de String completa de java o si no. Hice ambas soluciones, por las dudas:

```
public void toLowerCaseArray(String [] arreglo) {
    String toPrint = "";
    for (int i = 0; i < arreglo.length; i++) {
        toPrint = toPrint + toLowerCase(arreglo[i]);
        toPrint = toPrint + " ";
    }
    System.out.println(toPrint);
}

// Lowercase = Uppercase + 32.
private String toLowerCase(String s) {
    String toReturn = "";
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        char toAdd = s.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            int ascii_lowercase = (int) c;
            toAdd = (char) (ascii_lowercase + 32);
        }
        toReturn = toReturn + toAdd;
    }
    return toReturn;
}


// Si se tiene acceso a la librería de String, es más fácil usar esto:
private String toLowerCaseAuxiliary(String s) {
    return s.toLowerCase();
}
```
