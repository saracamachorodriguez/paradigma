RideApp - Laboratorio Integrador de Patrones de Diseño

Estructura y ejecución rápida (consola)

Compilar:

```bash
javac -d out src\main\Main.java src\app\RideApp.java src\factory\ViajeFactory.java src\builder\ViajeBuilder.java src\model\*.java src\observer\*.java src\mediator\CentralViajesMediator.java src\state\*.java
```

Ejecutar:

```bash
java -cp out main.Main
```

El programa simula el flujo completo pedido en el enunciado y muestra mensajes en consola.
