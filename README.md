# Implementación de ArrayList y LinkedList

Proyecto académico de la asignatura **Estructura de Datos**, perteneciente a la
carrera de **Ingeniería Informática**.

El proyecto contiene implementaciones propias de las estructuras de datos
`ArrayList` y `LinkedList` utilizando Java y genéricos. El objetivo es estudiar
cómo funcionan internamente estas listas y practicar sus operaciones básicas,
el manejo de índices y la validación de errores.

## Objetivos

- Implementar una lista basada en un arreglo.
- Implementar una lista basada en nodos enlazados.
- Utilizar una interfaz genérica común para ambas estructuras.
- Comprender las diferencias entre almacenamiento contiguo y enlazado.
- Validar casos correctos y casos con índices fuera de rango.

## Estructura del proyecto

```text
src/
├── ArrayList.java
├── LinkedList.java
├── IList.java
├── Node.java
└── Main.java
```

## Descripción de las clases

### `IList<T>`

Define las operaciones comunes que deben implementar las listas:

- `add(T element)`
- `add(T element, int index)`
- `get(int index)`
- `remove(int index)`
- `size()`
- `clear()`
- `isEmpty()`

### `ArrayList<T>`

Implementa una lista genérica utilizando un arreglo interno de objetos.

- Comienza con una capacidad de 10 elementos.
- Aumenta su capacidad en 10 posiciones cuando el arreglo se llena.
- Desplaza elementos al insertar o eliminar en una posición intermedia.
- Valida los índices y lanza `IndexOutOfBoundsException` cuando son inválidos.

### `LinkedList<T>`

Implementa una lista genérica utilizando nodos enlazados.

- Cada nodo contiene un valor y una referencia al siguiente nodo.
- Mantiene referencias al primer nodo (`head`) y al último nodo (`tail`).
- Permite agregar elementos al final en tiempo constante.
- Recorre los nodos para acceder o modificar posiciones intermedias.
- Valida los índices y lanza `IndexOutOfBoundsException` cuando son inválidos.

### `Node<T>`

Representa un nodo de la lista enlazada. Contiene el valor almacenado y la
referencia al siguiente nodo.

### `Main`

Contiene las pruebas manuales del proyecto. No se utiliza JUnit. Las pruebas
comprueban tanto operaciones válidas como operaciones que deben producir un
error.

## Casos de prueba

Las pruebas de `Main.java` incluyen:

- Verificar que una lista nueva esté vacía.
- Agregar elementos al final.
- Insertar elementos al inicio, en medio y al final.
- Obtener elementos mediante `get`.
- Eliminar elementos y verificar el valor eliminado.
- Comprobar la actualización de `size`.
- Vaciar la lista con `clear`.
- Verificar `isEmpty`.
- Agregar más de 10 elementos al `ArrayList` para comprobar su expansión.
- Probar índices negativos.
- Probar índices mayores o iguales al tamaño de la lista.

Los casos inválidos muestran el mensaje `ERROR esperado` cuando se produce la
excepción correspondiente. Si una operación inválida no produce una excepción,
la prueba muestra un fallo mediante `AssertionError`.

## Requisitos

- Java Development Kit (JDK) 17 o superior.
- No se necesitan dependencias externas ni frameworks de pruebas.

## Compilación y ejecución

Desde la carpeta raíz del proyecto, ejecutar:

```bash
mkdir -p build
javac -d build src/*.java
java -cp build Main
```

La salida mostrará las pruebas de `ArrayList` y `LinkedList` por separado,
indicando las operaciones correctas y los errores esperados. Al finalizar todas
las pruebas correctamente se mostrará:

```text
Todas las pruebas terminaron correctamente.
```
