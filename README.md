# Implementacion de ArrayList y LinkedList

Proyecto academico de la asignatura **Estructura de Datos**, perteneciente a la
carrera de **Ingenieria Informatica**.

El proyecto contiene implementaciones propias de las estructuras de datos
`ArrayList` y `LinkedList` utilizando Java y genericos. El objetivo es estudiar
como funcionan internamente estas listas y practicar sus operaciones basicas,
el manejo de indices y la validacion de errores.

## Objetivos

- Implementar una lista basada en un arreglo.
- Implementar una lista basada en nodos enlazados.
- Utilizar una interfaz generica comun para ambas estructuras.
- Comprender las diferencias entre almacenamiento contiguo y enlazado.
- Validar casos correctos y casos con indices fuera de rango.

## Estructura del proyecto

```text
src/
├── ArrayList.java
├── LinkedList.java
├── IList.java
├── Node.java
└── Main.java
```

## Descripcion de las clases

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

Implementa una lista generica utilizando un arreglo interno de objetos.

- Comienza con una capacidad de 10 elementos.
- Aumenta su capacidad en 10 posiciones cuando el arreglo se llena.
- Desplaza elementos al insertar o eliminar en una posicion intermedia.
- Valida los indices y lanza `IndexOutOfBoundsException` cuando son invalidos.

### `LinkedList<T>`

Implementa una lista generica utilizando nodos enlazados.

- Cada nodo contiene un valor y una referencia al siguiente nodo.
- Mantiene referencias al primer nodo (`head`) y al ultimo nodo (`tail`).
- Permite agregar elementos al final en tiempo constante.
- Recorre los nodos para acceder o modificar posiciones intermedias.
- Valida los indices y lanza `IndexOutOfBoundsException` cuando son invalidos.

### `Node<T>`

Representa un nodo de la lista enlazada. Contiene el valor almacenado y la
referencia al siguiente nodo.

### `Main`

Contiene las pruebas manuales del proyecto. No se utiliza JUnit. Las pruebas
comprueban tanto operaciones validas como operaciones que deben producir un
error.

## Casos de prueba

Las pruebas de `Main.java` incluyen:

- Verificar que una lista nueva este vacia.
- Agregar elementos al final.
- Insertar elementos al inicio, en medio y al final.
- Obtener elementos mediante `get`.
- Eliminar elementos y verificar el valor eliminado.
- Comprobar la actualizacion de `size`.
- Vaciar la lista con `clear`.
- Verificar `isEmpty`.
- Agregar mas de 10 elementos al `ArrayList` para comprobar su expansion.
- Probar indices negativos.
- Probar indices mayores o iguales al tamano de la lista.

Los casos invalidos muestran el mensaje `ERROR esperado` cuando se produce la
excepcion correspondiente. Si una operacion invalida no produce una excepcion,
la prueba muestra un fallo mediante `AssertionError`.

## Requisitos

- Java Development Kit (JDK) 17 o superior.
- No se necesitan dependencias externas ni frameworks de pruebas.

## Compilacion y ejecucion

Desde la carpeta raiz del proyecto, ejecutar:

```bash
mkdir -p build
javac -d build src/*.java
java -cp build Main
```

La salida mostrara las pruebas de `ArrayList` y `LinkedList` por separado,
indicando las operaciones correctas y los errores esperados. Al finalizar todas
las pruebas correctamente se mostrara:

```text
Todas las pruebas terminaron correctamente.
```
