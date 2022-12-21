package com.example.boenke_bic3_slm_exam.controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MarkControllerTest {
    @Test
    void returnMark() {
        // arrange (z.B. einen Instanz der Klasse erstellen
        var controller = new MarkController();
        // act (Methode mit Testdaten ausführen)
        var eins = controller.returnMark("89");
        var zwei = controller.returnMark("76");
        var drei = controller.returnMark("65");
        var vier = controller.returnMark("52");
        var fünf = controller.returnMark("3");
        // assert (Vergleichen ob Ergebnis mit Erwartung übereinstimmt)
        assertEquals("1", eins);
        assertEquals("2", zwei);
        assertEquals("3", drei);
        assertEquals("4", vier);
        assertEquals("5", fünf);
    }

    @Test
    void returnErrorMessageOnInvalidInput() {
        // arrange (z.B. einen Instanz der Klasse erstellen
        var controller = new MarkController();
        // act (Methode mit Testdaten ausführen)
        var error = controller.returnMark("cthulu");
        // assert (Vergleichen ob Ergebnis mit Erwartung übereinstimmt)
        assertEquals("invalid input", error);
    }

}