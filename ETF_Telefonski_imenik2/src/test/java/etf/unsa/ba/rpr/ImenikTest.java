package etf.unsa.ba.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;


public class ImenikTest {

    public static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup() {
        imenik.dodaj("Hamza", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj("Amna", new FiksniBroj(Grad.ZENICA, "225-884"));
        imenik.dodaj("Muhamed", new MobilniBroj(61, "225-885"));
        imenik.dodaj("Elvedin", new MedunarodniBroj("+44", "7768878794"));
    }

    @Test
    public void dajBrojFound() {
        String broj = imenik.dajBroj("Hamza");
        assertEquals(broj, "033/225-883");
    }

    @Test
    public void dajBrojNotFound() {
        String broj = imenik.dajBroj("Asim");
        assertNull(broj);
    }

    @Test
    public void dodajTestPositive() {
        TelefonskiBroj br = new MobilniBroj(61, "507-855");
        imenik.dodaj("Esma", br);

        String brojStr = imenik.dajBroj("Esma");
        assertEquals(brojStr, "+61/507-855");
    }

    @Test
    public void dodajFiksniException(){
    assertThrows(BrojException.class, () -> {new FiksniBroj(null, "123-123");});
}


}