import static org.junit.jupiter.api.Assertions.*;

class controladorTest {

    @org.junit.jupiter.api.Test
    void traduceme() {
        controlador con = new controlador();
        assertEquals(con.traduceme("English", "Spanish"), " mujer si *do* pueblo");
    }


}