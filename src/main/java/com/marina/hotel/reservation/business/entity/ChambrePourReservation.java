package com.marina.hotel.reservation.business.entity;

public record ChambrePourReservation(boolean isLibre, int etage, int numero) {

  public ChambrePourReservation() {
    this(true);
  }

  public ChambrePourReservation(boolean isLibre) {
    this(isLibre, 0, -1);
  }

  public ChambrePourReservation changerStatut(boolean isLibre) {
    return new ChambrePourReservation(isLibre, etage, numero);
  }

  public String getIdentifiant() {
    return etage + "-" + numero;
  }
}
