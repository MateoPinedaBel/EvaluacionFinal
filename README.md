# Analizador de Texto en Java

## Descripción
Este proyecto es una aplicación de consola en Java que permite analizar textos de manera automática. El usuario puede ingresar un texto manualmente, usar un texto predeterminado o leerlo desde un archivo `.txt`. El programa genera estadísticas detalladas sobre palabras y frases, incluyendo la frecuencia de palabras, la longitud promedio y la cantidad de frases.

El proyecto combina **Programación Orientada a Objetos** y **Programación Funcional** usando Streams, ofreciendo un código modular y eficiente.

---

## Funcionalidades
- Ingresar texto manualmente, usar un texto predeterminado o leer un archivo `.txt`.
- Limpiar y normalizar el texto (eliminando puntuación y convirtiendo a minúsculas).
- Contar palabras y frases.
- Mostrar la palabra más frecuente y su porcentaje respecto al total.
- Mostrar todas las palabras con sus frecuencias en columnas.
- Mostrar las N palabras más frecuentes.
- Submenú interactivo para buscar la frecuencia de palabras específicas.
- Manejo de errores y validación de entradas del usuario.

---

## Estructura del proyecto
- `Main.java` → Controla el flujo principal del programa.
- `Menu.java` → Gestiona la interacción con el usuario.
- `TextoProcesador.java` → Limpia el texto y lo divide en palabras.
- `EstadisticasTexto.java` → Calcula y muestra estadísticas del texto.

---

## Tecnologías y conceptos
- Java 21  
- Programación Orientada a Objetos (POO)  
- Programación funcional con Streams (`Collectors`)  
- Manejo de archivos con `java.nio.file.Files`  
- Manejo de errores y validación de entradas  
- Formateo de salida en consola  

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone <URL_DEL_REPOSITORIO>
```

2. Compilar los archivos Java:
```bash
javac -d bin src/org/example/*.java
```

3. Ejecutar la aplicación:
```bash
java -cp bin org.example.Main
```

---

## Uso
1. Al iniciar, se mostrará el menú principal:
   - `1` Ingresar texto manualmente.
   - `2` Usar texto predeterminado.
   - `3` Leer texto desde archivo.
   - `4` Salir.

2. Luego de procesar el texto, se mostrarán estadísticas y un submenú para buscar palabras específicas.

3. Se puede volver al menú principal para analizar otros textos o salir de la aplicación.

---

## Ejemplo de salida
```
Cantidad de palabras distintas: 54
Longitud promedio de palabras: 4.23
Cantidad de frases: 12

Listado de Palabras:
la             : 5       el             : 3       y              : 7
...
Palabra más frecuente: 'y' aparece 7 veces (8.24% del total)

--- Palabras más frecuentes ---
y: 7
la: 5
el: 3
...
```

---

Desarrollador: Mateo Andrés Pineda Beltrán

Resumen:

En éste curso he aprendido tres diferentes paradigmas de programación:
	** Programación Orientada a Objetos (POO) **
	** Programación Funcional **
	** Programación estructural **
	
Además de aprender buenas prácticas de nomenclatura al nombrar variables, funciones y clases.
