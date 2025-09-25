package com.marina.hotel;

public class Chambre {

  private final boolean isLibre;

  public Chambre() {
    this(true);
  }

  public Chambre(boolean isLibre) {
    this.isLibre = isLibre;
  }

  public boolean isLibre() {
    return isLibre;
  }
}
