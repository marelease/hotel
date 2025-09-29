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

  public double calculerPrix(double prixRDC) {
    double prixCalcule =
        switch (etage) {
          case 0 -> prixRDC;
          case 1 -> prixRDC * 1.07;
          case 2 -> prixRDC * 1.22;
          case 3 -> prixRDC * 1.33;
          default -> throw new IllegalArgumentException("Etage de chambre non valide");
        };
    return Math.min(200, prixCalcule);
  }
}
