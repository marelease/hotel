package com.marina.hotel.facturation.presenter.impl;

import com.marina.hotel.facturation.presenter.PrixChambrePresenter;

public class PrixChambreRestPresenter implements PrixChambrePresenter {

  private String representation;

  @Override
  public void presenter(double prixChambre) {
    representation = "{" + "prix: +" + prixChambre + "}";
  }

  public String getRepresentation() {
    return representation;
  }
}
