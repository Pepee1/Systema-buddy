package SRC;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
        arbol.agregar(6);
        arbol.agregar(4);
        arbol.agregar(8);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(7);
        arbol.agregar(9);

        System.out.println("Recorrido en orden:");
        arbol.recorrerInOrden(arbol.raiz);

        System.out.println("\nBuscar 5 en el árbol: " + arbol.buscar(5)); // Debería ser true
        System.out.println("Buscar 10 en el árbol: " + arbol.buscar(10)); // Debería ser false
    }
}

