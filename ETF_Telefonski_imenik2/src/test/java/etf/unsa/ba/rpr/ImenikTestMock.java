package etf.unsa.ba.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTestMock {
    public static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup() {
        imenik.dodaj("Hamza", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj("Amna", new FiksniBroj(Grad.ZENICA, "225-884"));
        imenik.dodaj("Muhamed", new MobilniBroj(61, "225-885"));
        imenik.dodaj("Elvedin", new MedunarodniBroj("+44", "7768878794"));
    }

    @Test
    public void testMockExternal(){
        // mock setup stage
        Imenik i = Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Hamza")).thenReturn("Nema nista");

        // test stage
        String test = i.dajBroj("Hamza");
        assertEquals(test, "Nema nista");
    }

    @Test
    public void testMockInternal(){
        Map<String, TelefonskiBroj> mapa = Mockito.mock(Map.class);
        Mockito.when(mapa.get("Hamza")).thenReturn(new FiksniBroj(Grad.MOSTAR, "225-883"));
        imenik.setBrojevi(mapa);

        String br = imenik.dajBroj("Hamzahamza2002" +
                "");
        assertNotEquals(br, "033/225-883");
    }

}