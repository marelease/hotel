package com.marina.hotel.facturation.presenter.impl;

import com.marina.hotel.facturation.presenter.PrixChambrePresenter;

public class PrixChambreConsolePresenter implements PrixChambrePresenter {

  private String representation;

  @Override
  public void presenter(double prixChambre) {
    representation = "Prix Chambre: " + prixChambre + " €";
  }

  public String getRepresentation() {
    return representation;
  }
}
