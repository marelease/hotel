package com.marina.hotel;

public class Chambre {

  private final boolean isLibre;

  private float prix;

  public Chambre() {
    this(true);
  }

  public Chambre(boolean isLibre) {
    this.isLibre = isLibre;
  }

  public Chambre(boolean isLibre, float prix) {
    this.isLibre = isLibre;
    this.prix = prix;
  }

  public boolean isLibre() {
    return isLibre;
  }

  public float getPrix() {
    return prix;
  }
}
