# RideApp - Validación de Principios SOLID y Patrones

## ✅ PRINCIPIOS SOLID

### 1. Single Responsibility Principle (SRP)
- **RideApp**: Responsable únicamente de orquestar solicitudes de viajes.
- **ViajeFactory**: Solo responsable de crear instancias de viajes.
- **ViajeBuilder**: Solo configura opciones del viaje paso a paso.
- **CentralViajesMediator**: Solo media comunicación entre pasajeros/conductores.
- **EstadoViaje (y sus implementaciones)**: Cada estado controla solo su comportamiento.
- **Observer (Pasajero, Conductor, UIObserver)**: Solo reciben y reaccionan a notificaciones.

### 2. Open/Closed Principle (OCP)
- **ViajeFactory**: Abierto para nuevos tipos de viaje (agregar casos en switch).
- **EstadoViaje**: Interfaz abierta para nuevos estados (crear nuevas clases que implementen EstadoViaje).
- **Observer**: Extensible agregando nuevas clases que implementen la interfaz.

### 3. Liskov Substitution Principle (LSP)
- Todas las clases de viaje (ViajeEconomico, ViajePremium, ViajeMoto, ViajeCompartido) 
  son intercambiables como instancias de Viaje.
- Todos los observadores (Pasajero, Conductor, UIObserver) son intercambiables como Observer.
- Todos los estados (Solicitado, Asignado, EnCamino, Finalizado, Cancelado) son 
  intercambiables como EstadoViaje.

### 4. Interface Segregation Principle (ISP)
- **Observable**: Interfaz mínima para notificaciones (agregarObservador, eliminarObservador, notificar).
- **Observer**: Interfaz mínima para observadores (update).
- **EstadoViaje**: Interfaz mínima con métodos default que lanzan excepción si no se implementan.

### 5. Dependency Inversion Principle (DIP)
- El código depende de abstracciones, no de implementaciones concretas:
  - Viaje es abstracta, no se usa directamente.
  - Observable es interfaz, no se instancia directamente.
  - EstadoViaje es interfaz, no se instancia directamente.
  - Observer es interfaz, las clases concretas la implementan.

---

## ✅ PATRONES DE DISEÑO IMPLEMENTADOS

### 1. SINGLETON - RideApp
**Problema**: Necesidad de única instancia central.
**Solución**: 
- Constructor privado.
- Instancia estática privada.
- Método getInstance() sincronizado.

```java
public class RideApp {
    private static RideApp instance;
    private RideApp() { ... }
    public static synchronized RideApp getInstance() { ... }
}
```

**Evidencia en consola**: Instancia única durante toda la ejecución.

---

### 2. FACTORY METHOD - ViajeFactory
**Problema**: Crear diferentes tipos de viajes sin acoplamiento a clases concretas.
**Solución**: Método estático que retorna Viaje según tipo.

```java
public static Viaje crearViaje(String tipo) {
    return switch (t) {
        case "premium" -> new ViajePremium();
        case "moto" -> new ViajeMoto();
        ...
    };
}
```

**Evidencia en consola**:
```
✓ [Factory] Viaje premium creado
```

---

### 3. BUILDER - ViajeBuilder
**Problema**: Viajes con múltiples opciones configurables.
**Solución**: Construcción paso a paso con setter encadenables.

```java
new ViajeBuilder(viaje)
    .setWifi(true)
    .setAireAcondicionado(true)
    .setEquipaje(true)
    .setNumeroPasajeros(2)
    .build();
```

**Evidencia en consola**:
```
✓ [Builder] Viaje configurado: [WiFi, A/C, Equipaje], pasajeros: 2
```

---

### 4. OBSERVER - Notificaciones
**Problema**: Múltiples objetos deben estar actualizados automáticamente.
**Solución**: Implementar Observable en Viaje, Observer en notificadores.

**Clases**:
- Observable: Interfaz con métodos agregarObservador, eliminarObservador, notificar.
- Observer: Interfaz con método update.
- Pasajero, Conductor, UIObserver: Implementan Observer.

**Evidencia en consola**:
```
→ [Pasajero] Ana González notificado: Conductor asignado: Carlos Mendoza
→ [UI] Actualizando pantalla: Conductor asignado: Carlos Mendoza
→ [Conductor] Carlos Mendoza notificado: Conductor asignado: Carlos Mendoza
```

---

### 5. MEDIATOR - CentralViajesMediator
**Problema**: Evitar comunicación directa entre pasajero, conductor y sistema.
**Solución**: Central que coordina todas las interacciones.

```java
public class CentralViajesMediator {
    public void registrarConductor(Conductor c) { ... }
    public void asignarConductor(Viaje viaje) { ... }
}
```

**Evidencia en consola**:
```
✓ [Mediator] Asignando conductor: Carlos Mendoza
```

---

### 6. STATE - Ciclo de vida del viaje
**Problema**: Comportamiento del viaje cambia según estado.
**Solución**: Interfaz EstadoViaje con implementaciones por estado.

**Estados**:
- Solicitado: permite asignar o cancelar
- Asignado: permite iniciar o cancelar
- EnCamino: permite finalizar
- Finalizado: sin acciones permitidas
- Cancelado: sin acciones permitidas

**Evidencia en consola**:
```
✓ Estado: Solicitado
✓ Estado: Solicitado → Asignado
✓ Estado: Asignado → En camino
✓ Estado: En camino → Finalizado
```

---

## 📋 REQUISITOS CUMPLIDOS

✅ Única instancia central de RideApp (Singleton)
✅ Factory crea viajes sin acoplamiento
✅ Builder configura opciones paso a paso
✅ Observer notifica automáticamente cambios
✅ Mediator coordina interacciones
✅ State controla ciclo de vida del viaje
✅ Flujo completo visible en consola
✅ Arquitectura modular por paquetes
✅ Principios SOLID respetados
✅ Patrones bien integrados

---

## 🎯 FLUJO DE EJECUCIÓN

1. ✓ Pasajero solicita viaje
2. ✓ RideApp recibe solicitud
3. ✓ Factory crea viaje (tipo)
4. ✓ Builder configura opciones
5. ✓ Observadores se registran
6. ✓ Mediator registra conductor
7. ✓ Mediator asigna conductor
8. ✓ State transiciona: Solicitado → Asignado
9. ✓ Observer notifica asignación
10. ✓ Viaje inicia
11. ✓ State transiciona: Asignado → EnCamino
12. ✓ Observer notifica inicio
13. ✓ Viaje en ruta (simulación)
14. ✓ Viaje finaliza
15. ✓ State transiciona: EnCamino → Finalizado
16. ✓ Observer notifica finalización
17. ✓ Estado final: Finalizado

---

## 📦 ESTRUCTURA DE ARCHIVOS

```
src/
├── app/
│   └── RideApp.java              [Singleton]
├── factory/
│   └── ViajeFactory.java         [Factory Method]
├── builder/
│   └── ViajeBuilder.java         [Builder]
├── observer/
│   ├── Observable.java           [Interfaz]
│   ├── Observer.java             [Interfaz]
│   ├── Pasajero.java             [Observador]
│   ├── Conductor.java            [Observador]
│   └── UIObserver.java           [Observador]
├── mediator/
│   └── CentralViajesMediator.java [Mediator]
├── model/
│   ├── Viaje.java                [Clase abstracta]
│   ├── ViajeEconomico.java       [Variante]
│   ├── ViajePremium.java         [Variante]
│   ├── ViajeMoto.java            [Variante]
│   └── ViajeCompartido.java      [Variante]
├── state/
│   ├── EstadoViaje.java          [Interfaz]
│   ├── Solicitado.java           [Estado]
│   ├── Asignado.java             [Estado]
│   ├── EnCamino.java             [Estado]
│   ├── Finalizado.java           [Estado]
│   └── Cancelado.java            [Estado]
└── main/
    └── Main.java                 [Punto de entrada]
```
