public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS ARRAYLIST ===");
        probarArrayList();

        System.out.println();
        System.out.println("=== PRUEBAS LINKEDLIST ===");
        probarLinkedList();

        System.out.println("Todas las pruebas terminaron correctamente.");
    }

    private static void probarArrayList() {
        ArrayList<Integer> lista = new ArrayList<>();

        probarOperaciones(lista, "ArrayList");

        ArrayList<Integer> listaGrande = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            listaGrande.add(i);
        }

        verificar(listaGrande.size() == 25,
                "ArrayList aumenta su capacidad al superar 10 elementos");
        verificar(listaGrande.get(0) == 0 && listaGrande.get(24) == 24,
                "ArrayList conserva los elementos al aumentar su capacidad");
    }

    private static void probarLinkedList() {
        probarOperaciones(new LinkedList<>(), "LinkedList");
    }

    private static void probarOperaciones(IList<Integer> lista, String nombre) {
        verificar(lista.isEmpty(), nombre + " comienza vacia");
        verificar(lista.size() == 0, nombre + " comienza con size 0");

        lista.add(10);
        lista.add(30);
        lista.add(20, 1);
        lista.add(5, 0);
        lista.add(40, lista.size());

        verificar(lista.size() == 5, nombre + " agrega elementos");
        verificar(lista.get(0) == 5, nombre + " agrega correctamente al inicio");
        verificar(lista.get(1) == 10, nombre + " obtiene el primer elemento");
        verificar(lista.get(2) == 20, nombre + " inserta correctamente en medio");
        verificar(lista.get(4) == 40, nombre + " agrega correctamente al final");

        int eliminado = lista.remove(2);
        verificar(eliminado == 20, nombre + " devuelve el elemento eliminado");
        verificar(lista.size() == 4, nombre + " actualiza size al eliminar");
        verificar(lista.get(2) == 30, nombre + " desplaza elementos al eliminar");

        verificarError(() -> lista.add(99, -1),
                nombre + " rechaza insertar con indice negativo");
        verificarError(() -> lista.add(99, lista.size() + 1),
                nombre + " rechaza insertar fuera de rango");
        verificarError(() -> lista.get(-1),
                nombre + " rechaza obtener con indice negativo");
        verificarError(() -> lista.get(lista.size()),
                nombre + " rechaza obtener fuera de rango");
        verificarError(() -> lista.remove(-1),
                nombre + " rechaza eliminar con indice negativo");
        verificarError(() -> lista.remove(lista.size()),
                nombre + " rechaza eliminar fuera de rango");

        lista.clear();
        verificar(lista.isEmpty(), nombre + " queda vacia despues de clear");
        verificar(lista.size() == 0, nombre + " actualiza size despues de clear");
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError("FALLO: " + mensaje);
        }

        System.out.println("OK: " + mensaje);
    }

    private static void verificarError(Runnable operacion, String mensaje) {
        try {
            operacion.run();
            throw new AssertionError("FALLO: no se produjo el error: " + mensaje);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR esperado: " + mensaje
                    + " (" + e.getClass().getSimpleName() + ")");
        }
    }
}
