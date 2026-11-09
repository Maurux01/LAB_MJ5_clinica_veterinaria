# Sistema de Clínica Veterinaria — VetCare

Laboratorio de práctica (TIFC2DEV-JAVA-MJ5) sobre **herencia, clases abstractas e interfaces** en Java.

## Descripción

Sistema que modela los animales de una clínica veterinaria (perros, gatos y aves), calcula el costo de la consulta según la especie, registra vacunación y gestiona planes de seguro. También incluye la clínica como institución asegurable, demostrando que las interfaces son independientes de la jerarquía de herencia.

## Estructura del proyecto

```
LAB_MJ5_clinica_veterinaria/
├── LAB_MJ5_clinica_veterinaria.pdf   # Enunciado del laboratorio
├── README.md                          # Este archivo
├── .idea/                             # Configuración de IntelliJ (JDK 26)
└── src/                               # Código fuente (default package)
    ├── Animal.java       # Clase base abstracta
    ├── Vacunable.java    # Interfaz de vacunación
    ├── Asegurable.java   # Interfaz de seguro
    ├── Perro.java        # Extiende Animal, implementa Vacunable + Asegurable
    ├── Gato.java         # Extiende Animal, implementa Vacunable + Asegurable
    ├── Ave.java          # Extiende Animal
    ├── Clinica.java      # Implementa Asegurable (no es Animal)
    ├── Conejo.java       # Extiende Animal (verificación de extensibilidad)
    └── Main.java         # Programa de prueba (4 bloques)
```

## Requisitos

- JDK 26 (configurado en `.idea/misc.xml`).
- IntelliJ IDEA (opcional, pero recomendado).

## Cómo compilar y ejecutar

### Desde terminal (Windows / PowerShell)

```powershell
cd LAB_MJ5_clinica_veterinaria
javac -d out src\*.java
java -cp out Main
```

### Desde IntelliJ

1. Abre el proyecto.
2. Verifica que `src` esté marcado como **Source Root** (ya configurado en `.iml`).
3. Ejecuta `Main`.

## Mapa del sistema

| Clase   | Extiende | Implementa           | Abstracta |
|---------|----------|----------------------|-----------|
| Animal  | —        | —                    | Sí        |
| Perro   | Animal   | Vacunable, Asegurable| No        |
| Gato    | Animal   | Vacunable, Asegurable| No        |
| Ave     | Animal   | —                    | No        |
| Clinica | —        | Asegurable           | No        |
| Conejo  | Animal   | —                    | No        |

## Clases y decisiones de diseño

### `Animal` (abstracta)
- Atributos `protected`: `nombre`, `edad`, `nombreDueno` (visibles para subclases, encapsulados).
- Constructor común.
- Método abstracto `calcularCostoConsulta()` → cada especie define su fórmula.
- Método concreto `imprimirFicha()` → formato común que llama al método abstracto (polimorfismo).

### Interfaces
- `Vacunable`: `registrarVacuna(String)`, `getVacunasAplicadas()`.
- `Asegurable`: `calcularPrimaSeguro()`, `obtenerNumeroPoliza()`.

Van en interfaces (no en `Animal`) porque cruzan jerarquías: la vacunación/seguro no aplican a todos los animales ni solo a animales.

### Subclases
| Clase | Atributo propio | Costo consulta | Prima seguro |
|-------|-----------------|----------------|--------------|
| Perro | raza | 45000 + 3000×edad | 80000×edad |
| Gato | esEsterilizado | 38000 fijo | 120000 (esterilizado) / 200000 |
| Ave | pesoGramos | 28000 + 100×peso | — |
| Conejo | — | 35000 fijo | — |

### `Clinica`
No extiende `Animal`. Implementa `Asegurable`: prima fija 5.000.000, póliza `"POL-CLINICA-" + nombre`. Demuestra la diferencia entre herencia (es-un) e interfaces (puede-hacer).

## Pruebas en `Main` (4 bloques)

1. **Fichas polimórficas**: `Animal[]` con Perro, Gato y Ave; recorre e imprime `imprimirFicha()`.
2. **Vacunación**: `Perro` y `Gato` con tipo concreto; registra 2 vacunas al perro y 1 al gato; imprime contadores.
3. **Pólizas**: instancia `Clinica`; `Asegurable[]` con perro, gato y clínica; imprime póliza y prima.
4. **Extensibilidad**: agrega `Conejo` al arreglo `Animal[]` sin modificar clases existentes.

## Salida esperada (resumen)

```
=== Ficha de Firulais ===  Costo de consulta: 60000.0
=== Ficha de Michi ===     Costo de consulta: 38000.0
=== Ficha de Piolin ===    Costo de consulta: 43000.0
Perro vacunas: 2
Gato vacunas: 1
POL-PERRO-Rex -> 320000.0
POL-GATO-Luna -> 200000.0
POL-CLINICA-VetCare -> 5000000.0
... (bloque 4 incluye Conejo con 35000.0)
```

## Checklist de verificación

- [x] `new Animal(...)` no compila (clase abstracta).
- [x] Perro/Gato/Ave no compilan sin implementar el costo de consulta.
- [x] `Clinica` no extiende `Animal` y aun así se asegura.
- [x] `Ave` no implementa `Vacunable` sin error.
- [x] `imprimirFicha()` da salida distinta por especie sin `instanceof` ni casting.
- [x] `Animal[]` mezcla especies; `Asegurable[]` mezcla animales y clínica.
- [x] Agregar `Conejo` solo requiere crear la clase nueva.

## Conceptos Java aplicados

- Herencia (`extends`), clase abstracta (`abstract`), interfaces (`interface`/`implements`).
- Polimorfismo de subtipos y despacho dinámico.
- `@Override`, `super(...)`, atributos `protected`.
- Colecciones (`ArrayList<String>`), ternario.

## Notas

- Proyecto sin Maven/Gradle: Java plano.
- Default package (sin `package`).
- Para limpiar: borrar la carpeta `out/` (IntelliJ la regenera).

## Autor

Laboratorio TIFC2DEV-JAVA-MJ5 — Clínica Veterinaria (Herencia, Clases Abstractas, Interfaces).
```

Creado por Mauro Infante - Maurux01