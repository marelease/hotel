package com.marina.hotel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HotelApplicationTests {

	@Test
	void testRecuperationChambres() {
    ChambreService chambreService =
        new ChambreService(new ChambreRepository(List.of(new Chambre())));
    List<Chambre> toutesLesChambres = chambreService.getAllChambres();
    assertFalse(toutesLesChambres.isEmpty());
	}

	@Test
	void testRecuperationChambres2() {
    Chambre chambreA = new Chambre();
    Chambre chambreB = new Chambre();
    Chambre chambreC = new Chambre();
    ChambreService chambreService = new ChambreService(new ChambreRepository(List.of(chambreA, chambreB, chambreC)));

    List<Chambre> toutesLesChambres = chambreService.getAllChambres();

    List<Chambre> chambresEsperees = List.of(chambreA, chambreB, chambreC);
    assertEquals(chambresEsperees.size(), toutesLesChambres.size());
    assertTrue(toutesLesChambres.containsAll(chambresEsperees));
	}

	@Test
	void testRecuperationChambresLibres() {
    Chambre chambreA = new Chambre(false);
    Chambre chambreB = new Chambre(true);
    Chambre chambreC = new Chambre(false);
    ChambreService chambreService = new ChambreService(new ChambreRepository(List.of(chambreA, chambreB, chambreC)));

    List<Chambre> chambresLibres = chambreService.getChambresLibres();

    List<Chambre> chambresEsperees = List.of(chambreB);
    assertEquals(chambresEsperees.size(), chambresLibres.size());
    assertTrue(chambresLibres.containsAll(chambresEsperees));
	}

    @Test
    void testRecuperationChambresPrixInferieur() {
        Chambre chambreA = new Chambre(true, 50.0f);
        Chambre chambreB = new Chambre(true, 150.0f);
        Chambre chambreC = new Chambre(true, 80.0f);
        ChambreService chambreService = new ChambreService(new ChambreRepository(List.of(chambreA, chambreB, chambreC)));

        List<Chambre> chambresPrixInferieur = chambreService.getChambresPrixInferieur(100.0f);

        List<Chambre> chambresEsperees = List.of(chambreA, chambreC);
        assertEquals(chambresEsperees.size(), chambresPrixInferieur.size());
        assertTrue(chambresPrixInferieur.containsAll(chambresEsperees));
    }
}
