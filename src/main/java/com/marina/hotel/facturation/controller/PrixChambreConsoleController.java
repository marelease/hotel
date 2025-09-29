package com.marina.hotel.facturation.controller;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.business.usecase.ChambrePrixUseCase;
import com.marina.hotel.facturation.business.usecase.interactor.ChambrePrixUseCaseInteractor;
import com.marina.hotel.facturation.presenter.PrixChambrePresenter;
import com.marina.hotel.facturation.presenter.impl.PrixChambreConsolePresenter;
import com.marina.hotel.serverside.facturation.ChambreFacturationRepositoryAdapterStub;

public class PrixChambreConsoleController {

  private final ChambrePrixUseCase chambrePrixUseCase;
  private final PrixChambrePresenter presenter;

  public PrixChambreConsoleController(
      ChambrePrixUseCase chambrePrixUseCase, PrixChambrePresenter presenter) {
    this.chambrePrixUseCase = chambrePrixUseCase;
    this.presenter = presenter;
  }

  public void afficherPrixChambre(int etage, int numero) {
    Chambre chambre =
        chambrePrixUseCase
            .findChambre(etage, numero)
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "ChambrePourReservation " + etage + "-" + numero + " n'existe pas"));

    chambrePrixUseCase.getPrix(chambre, presenter);
    System.out.println(((PrixChambreConsolePresenter) presenter).getRepresentation());
  }

  public static void main(String[] args) {
    PrixChambreConsoleController controller =
        new PrixChambreConsoleController(
            new ChambrePrixUseCaseInteractor(new ChambreFacturationRepositoryAdapterStub()),
            new PrixChambreConsolePresenter());

    controller.afficherPrixChambre(1, 7);
  }
}
