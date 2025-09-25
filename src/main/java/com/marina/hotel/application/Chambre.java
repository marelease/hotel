package com.marina.hotel.application;

public class Chambre {

  private final boolean isLibre;
  private final int etage;

  public Chambre() {
    this(true);
  }

  public Chambre(boolean isLibre) {
    this(isLibre, 0);
  }

  public Chambre(boolean isLibre, int etage) {
    this.isLibre = isLibre;
    this.etage = etage;
  }

  public boolean isLibre() {
    return isLibre;
  }

  public int getEtage() {
    return etage;
  }
}
