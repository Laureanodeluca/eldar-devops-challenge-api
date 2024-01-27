# Ejercicio 3

**RESPUESTA:** 10.
___
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
Se usa un bucle `FOR` para iterar a través de los elementos de la variable `fname`. Se imprime cada nombre junto con su índice usando `DBMS_OUTPUT.PUT_LINE`.

# Ejercicio 4
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

La respuesta correcta es "Le falta un retorno, por lo que no compila".

En el header de la función dice que retorna un `Number`, pero falta el return. 

# Ejercicio 5
