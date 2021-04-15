import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BSTTest {

    @Test
    void insertar() {
        BST arbol = new BST("English");
        arbol.insertar("Cat", "Gato", "Chat");
        arbol.traducir(arbol.raiz, "Cat");
        assertEquals("Gato", arbol.getTranslations().get("Spanish"));
    }
}