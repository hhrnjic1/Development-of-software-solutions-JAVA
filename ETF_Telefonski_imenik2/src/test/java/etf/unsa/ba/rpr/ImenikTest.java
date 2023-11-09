package etf.unsa.ba.rpr;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import etf.unsa.ba.rpr.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    public static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup()
    {
        imenik.dodaj("Hamza", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj("Muhamed", new FiksniBroj(Grad.ZENICA, "225-884"));
        imenik.dodaj("Amna", new MobilniBroj(61, "225-885"));
        imenik.dodaj("Denan", new MedunarodniBroj("+44", "7768878794"));
    }
    @Test
    public void dajBroj(){
        String broj = imenik.dajBroj("Hamza");
        assertEquals(broj,"033/225-883" );
    }
    @Test
    public void dodajBroj(){
        TelefonskiBroj br = new MobilniBroj(61, "507-855");
        imenik.dodaj("Esma", br);
        String brojStr = imenik.dajBroj("Esma");
        assertEquals(brojStr, "+61/507-855");
    }
    @Test
    public void FixniException(){
        assertThrows(BrojException.class, ()-> {new FiksniBroj(null,"432-432");});
    }
}