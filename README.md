# RideApp - Laboratorio Integrador de Patrones de Diseño

## 📖 Descripción

RideApp es una simulación de plataforma de viajes (similar a Uber) que implementa múltiples patrones de diseño en Java de manera integrada y profesional.

## 🎯 Objetivo

Desarrollar una aplicación ejecutable que demuestre:
- Uso correcto de patrones creacionales y comportamentales
- Integración real entre patrones
- Cumplimiento de principios SOLID
- Flujo completo de un viaje desde solicitud hasta finalización

## 🏗️ Patrones Implementados

1. **Singleton** - RideApp (instancia única central)
2. **Factory Method** - ViajeFactory (creación de viajes)
3. **Builder** - ViajeBuilder (configuración paso a paso)
4. **Observer** - Notificaciones automáticas
5. **Mediator** - Coordinación de interacciones
6. **State** - Ciclo de vida del viaje

## 🔧 Requisitos

- Java 21 LTS o superior
- javac (compilador Java)

## ⚙️ Compilación y Ejecución

### En Windows (CMD):

```bash
cd "c:\Users\sarac\Downloads\Solución paradigma"
javac -d out src\main\Main.java src\app\RideApp.java src\factory\ViajeFactory.java src\builder\ViajeBuilder.java src\model\*.java src\observer\*.java src\mediator\CentralViajesMediator.java src\state\*.java
java -cp out main.Main
```

### En Linux/Mac:

```bash
cd "Solución paradigma"
javac -d out src/main/Main.java src/app/RideApp.java src/factory/ViajeFactory.java src/builder/ViajeBuilder.java src/model/*.java src/observer/*.java src/mediator/CentralViajesMediator.java src/state/*.java
java -cp out main.Main
```

## 📊 Salida Esperada

La aplicación muestra en consola:

```
============================================================
      SISTEMA RIDEAPP - LABORATORIO DE PATRONES
============================================================
Patrones: Singleton, Factory, Builder, Observer,
          Mediator, State
============================================================

============================================================
FASE 1: SOLICITUD Y CONFIGURACIÓN DE VIAJE
============================================================

[1] Pasajero solicita viaje...
✓ [RideApp] Solicitud de viaje recibida
  ✓ [Factory] Viaje premium creado
  ✓ Estado: Solicitado

[2] Configurando opciones del viaje...
  ✓ [Builder] Viaje configurado: [WiFi, A/C, Equipaje], pasajeros: 2

...

============================================================
RESUMEN FINAL
============================================================

Estado final: Finalizado
Pasajero: Ana González
Conductor: Carlos Mendoza
Servicio: premium

✓ Simulación completada exitosamente
```

## 📁 Estructura del Proyecto

```
src/
├── app/          → RideApp (Singleton)
├── factory/      → ViajeFactory (Factory Method)
├── builder/      → ViajeBuilder (Builder)
├── observer/     → Observer, Observable, Pasajero, Conductor, UIObserver
├── mediator/     → CentralViajesMediator (Mediator)
├── state/        → EstadoViaje, Solicitado, Asignado, EnCamino, Finalizado, Cancelado
├── model/        → Viaje, ViajeEconomico, ViajePremium, ViajeMoto, ViajeCompartido
└── main/         → Main (punto de entrada)

out/              → Archivos compilados (.class)
```

## 🔍 Análisis SOLID

Véase `SOLID_Y_PATRONES.md` para validación detallada de principios SOLID y patrones.

### Resumen:

- ✅ **SRP**: Cada clase tiene única responsabilidad
- ✅ **OCP**: Abierto para extensión (nuevos estados, viajes, observadores)
- ✅ **LSP**: Sustitución de Liskov respetada en todas las jerarquías
- ✅ **ISP**: Interfaces segregadas y mínimas
- ✅ **DIP**: Dependencias invertidas (abstracciones, no concreciones)

## 🔄 Flujo de Ejecución

1. Pasajero solicita viaje (Singleton + Factory + State)
2. RideApp crea viaje del tipo especificado
3. Builder configura opciones del viaje
4. Observadores se registran (Observer)
5. Mediator asigna conductor (Mediator)
6. Cambios de estado transitados (State)
7. Observadores notificados automáticamente (Observer)
8. Ciclo completo: Solicitud → Asignación → En ruta → Finalizado

## 📝 Notas de Implementación

### Singleton
- Constructor privado
- Instancia estática sincronizada
- Thread-safe

### Factory Method
- Switch con rule syntax (Java 16+)
- Encapsulación de creación
- Fácil de extender

### Builder
- Fluent interface
- Configuración paso a paso
- Retorno de viaje configurado

### Observer
- Notificaciones automáticas
- Bajo acoplamiento
- Observadores independientes

### Mediator
- Coordinación central
- Asignación inteligente
- Gestión de conductores disponibles

### State
- Encapsulación de comportamiento
- Transiciones explícitas
- Sin if/else anidados

## 👨‍💻 Autor

Laboratorio de Patrones de Diseño - Java

## 📚 Referencias

- Patrones de Diseño (Gang of Four)
- Principios SOLID
- Java Design Patterns
