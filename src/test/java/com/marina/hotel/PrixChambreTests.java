package com.marina.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.business.usecase.interactor.ChambrePrixUseCaseInteractor;
import com.marina.hotel.facturation.presenter.impl.PrixChambreConsolePresenter;
import com.marina.hotel.gateway.ChambreRepositoryAdapterFake;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrixChambreTests {

	@Test
	void testRecuperationChambres() {
    ChambreRepositoryAdapterFake repository = new ChambreRepositoryAdapterFake();
    repository.ajouterChambre(0, true);
    ChambrePrixUseCaseInteractor chambreUseCaseInteractor =
        new ChambrePrixUseCaseInteractor(repository);
    List<Chambre> toutesLesChambres = chambreUseCaseInteractor.getAllChambres();
    assertFalse(toutesLesChambres.isEmpty());
	}

	@Test
	void testRecuperationChambres2() {
    ChambreRepositoryAdapterFake repository = new ChambreRepositoryAdapterFake();
    Chambre chambreA = repository.ajouterChambre(0, true);
    Chambre chambreB = repository.ajouterChambre(1, true);
    Chambre chambreC = repository.ajouterChambre(2, true);
    ChambrePrixUseCaseInteractor chambreUseCaseInteractor =
        new ChambrePrixUseCaseInteractor(repository);

    List<Chambre> toutesLesChambres = chambreUseCaseInteractor.getAllChambres();

    List<Chambre> chambresEsperees = List.of(chambreA, chambreB, chambreC);
    assertEquals(chambresEsperees.size(), toutesLesChambres.size());
    assertTrue(toutesLesChambres.containsAll(chambresEsperees));
	}

	@ParameterizedTest(name = "Etage : {0} - prix attendu : {1}, prix RDC : {2}")
  @CsvSource({"0,100,100", "1,107,100", "2,122,100", "3,133,100", "0,170,170", "1,181.9,170", "2,200,170", "3,200,170"})
	void testPrixChambreRDC(int etage, double prixEspere, double prixRDC) {
    ChambreRepositoryAdapterFake repository = new ChambreRepositoryAdapterFake(prixRDC);
    Chambre chambre = repository.ajouterChambre(etage, true);

    ChambrePrixUseCaseInteractor chambreUseCaseInteractor =
        new ChambrePrixUseCaseInteractor(repository);

    assertEquals(
        prixEspere, chambreUseCaseInteractor.getPrix(chambre, new PrixChambreConsolePresenter()));
	}
}
