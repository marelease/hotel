package com.marina.hotel.facturation.controller;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.business.usecase.ChambreUseCase;
import com.marina.hotel.facturation.business.usecase.interactor.ChambreService;
import com.marina.hotel.facturation.presenter.PrixChambrePresenter;
import com.marina.hotel.facturation.presenter.impl.PrixChambreConsolePresenter;
import com.marina.hotel.serverside.ChambreRepositoryAdapterStub;

public class PrixChambreConsoleController {

  private final ChambreUseCase chambreUseCase;
  private final PrixChambrePresenter presenter;

  public PrixChambreConsoleController(
      ChambreUseCase chambreUseCase, PrixChambrePresenter presenter) {
    this.chambreUseCase = chambreUseCase;
    this.presenter = presenter;
  }

  public void afficherPrixChambre(int etage, int numero) {
    Chambre chambre =
        chambreUseCase
            .findChambre(etage, numero)
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Chambre " + etage + "-" + numero + " n'existe pas"));

    chambreUseCase.getPrix(chambre, presenter);
    System.out.println(((PrixChambreConsolePresenter) presenter).getRepresentation());
  }

  public static void main(String[] args) {
    PrixChambreConsoleController controller =
        new PrixChambreConsoleController(
            new ChambreService(new ChambreRepositoryAdapterStub()),
            new PrixChambreConsolePresenter());

    controller.afficherPrixChambre(1, 7);
  }
}
