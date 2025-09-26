package com.marina.hotel.facturation.business.entity;

public record Chambre(boolean isLibre, int etage, int numero) {

  public Chambre() {
    this(true);
  }

  public Chambre(boolean isLibre) {
    this(isLibre, 0, -1);
  }

  public static Chambre from(Chambre chambre) {
    if (chambre == null) {
      return null;
    }
    return new Chambre(chambre.isLibre(), chambre.etage(), chambre.numero());
  }

  public String getIdentifiant() {
    return etage + "-" + numero;
  }
}
