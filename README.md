# Eldar DevOps Challenge
Este código es la implementación de una API REST para el desafío propuesto. En este mismo repositorio están las soluciones tanto del ejercicio 1 como del ejercicio 2. 


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
Para la implementación del ejercicio 2, se solicitó una Api REST que devuelva la tasa de una operación, informando la marca de la tarjeta y el importe. Para eso, se creo una API con SpringBoot.
<TODO: URL de la API, ¿cómo se usa la api?>