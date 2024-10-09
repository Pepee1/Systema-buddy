package SRC;

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Método para agregar un nodo al árbol
    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return new Nodo(valor);
        }

        if (valor < nodoActual.valor) {
            nodoActual.izquierdo = agregarRecursivo(nodoActual.izquierdo, valor);
        } else if (valor > nodoActual.valor) {
            nodoActual.derecho = agregarRecursivo(nodoActual.derecho, valor);
        }

        return nodoActual;
    }

    // Método para buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return false;
        }

        if (valor == nodoActual.valor) {
            return true;
        } 

        return valor < nodoActual.valor
            ? buscarRecursivo(nodoActual.izquierdo, valor)
            : buscarRecursivo(nodoActual.derecho, valor);
    }

    // Método para recorrer el árbol en orden (in-order traversal)
    public void recorrerInOrden(Nodo nodo) {
        if (nodo != null) {
            recorrerInOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorrerInOrden(nodo.derecho);
        }
    }
}
