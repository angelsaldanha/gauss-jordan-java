# Métodos Numéricos: Solución de Sistemas de Ecuaciones Lineales

Implementación modular en Java de los métodos de **Eliminación Gaussiana Simple** y **Gauss-Jordan con Reutilización de Software** para la resolución de sistemas de ecuaciones lineales algebraicas.

---

## 1. Lenguaje y entorno
* **Lenguaje:** Java (compatible con Java SE 17, 21 o superior).
* **Paradigma:** Modular / Programación estructurada orientada a métodos estáticos.
* **Control de versiones:** Git y GitHub.

---

## 2. Estructura modular del proyecto

El proyecto se organiza en dos paquetes para evidenciar el principio de reutilización de software:

### Paquete `programagauss` (Práctica 1 - Base):
* `MetodoGauss.java`: Contiene la triangulación inferior (eliminación hacia adelante) y la sustitución regresiva.
* `Matriz.java`: Definición de la matriz aumentada inicial $[A \mid b]$.
* `Main.java`: Ejecución del método de Gauss tradicional.

### Paquete `programagaussjordan` (Práctica 2 - Extensión):
* `MetodoGaussJordan.java`: **Módulo central de procesamiento numérico**. Reutiliza el método `MetodoGauss.eliminacionGaussiana` para obtener la matriz triangular superior e implementa:
    * **Normalización de pivotes:** Convierte cada elemento diagonal en 1 dividiendo la fila entre el pivote.
    * **Barrido superior:** Elimina los coeficientes ubicados por encima de la diagonal principal.
    * **Lectura directa:** Extrae el vector de soluciones directamente de la última columna sin requerir sustitución regresiva.
* `Matriz.java`: Provee el sistema de ecuaciones para su resolución.
* `Main.java`: Orquestador que ejecuta el flujo de Gauss-Jordan y presenta los resultados.

---

## 3. Compilación y ejecución

### Opción A: Desde la terminal (Línea de comandos)

1. Abrir una terminal y ubicarse en el directorio `src/` del proyecto:
   ```bash
   cd src
   ```

2. Compilar los paquetes del proyecto:
   ```bash
   javac programagauss/*.java programagaussjordan/*.java
   ```

3. Ejecutar el módulo principal de Gauss-Jordan:
   ```bash
   java programagaussjordan.Main
   ```

*(Opcional: Para ejecutar la práctica previa de Gauss simple, usar: `java programagauss.Main`)*

### Opción B: Desde IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. En el panel de navegación (`Project`), desplegar la ruta:
   `src` $\rightarrow$ `programagaussjordan` $\rightarrow$ `Main`.
3. Hacer clic derecho sobre `Main` y seleccionar **Run 'Main.main()'** (o presionar `Shift + F10`).

---

## 4. Ejemplo de prueba y salida por consola

### Sistema de ecuaciones evaluado
Sistema de 3 ecuaciones lineales con 3 incógnitas:

$$\begin{aligned} 3.0x_1 - 0.1x_2 - 0.2x_3 &= 7.85 \\ 0.1x_1 + 7.0x_2 - 0.3x_3 &= -19.3 \\ 0.3x_1 - 0.2x_2 + 10.0x_3 &= 71.4 \end{aligned}$$

Representación inicial en matriz aumentada $[A \mid b]$:

```text
[  3.0  -0.1  -0.2 |   7.85 ]
[  0.1   7.0  -0.3 | -19.30 ]
[  0.3  -0.2  10.0 |  71.40 ]
```

Tras la ejecución de Gauss-Jordan, la matriz aumentada se transforma directamente en la matriz identidad $[I \mid s]$ en memoria RAM.

```text
[  1.0   0.0   0.0 |   3.00 ]
[  0.0   1.0   0.0 |  -2.50 ]
[  0.0   0.0   1.0 |   7.000000000000002]
```

### Salida obtenida por consola (Texto plano)

```text
Soluciones del sistema (Método de Gauss-Jordan):
x1 = 3.0
x2 = -2.5
x3 = 7.000000000000002
```

> El valor obtenido en $x_3$ ($7.000000000000002$) refleja el error por redondeo propio de la aritmética de punto flotante de doble precisión tras las operaciones sucesivas de normalización y eliminación de renglones.