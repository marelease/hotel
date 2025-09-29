package com.marina.hotel.reservation.business.usecase.interactor;

import com.marina.hotel.reservation.business.entity.ChambrePourReservation;
import com.marina.hotel.reservation.business.usecase.ChambreReservationUseCase;
import com.marina.hotel.reservation.gateway.ChambreReservationRepository;

public class ChambreReservationUseCaseInteractor implements ChambreReservationUseCase {

  private final ChambreReservationRepository repository;

  public ChambreReservationUseCaseInteractor(ChambreReservationRepository repository) {
    this.repository = repository;
  }

  @Override
  public void reserverChambre(int numero, int etage) {
    repository.getChambres().stream()
        .filter(
            chambre -> chambre.isLibre() && chambre.etage() == etage && chambre.numero() == numero)
        .findAny()
        .map(chambre -> new ChambrePourReservation(false, chambre.etage(), chambre.numero()))
        .ifPresent(repository::save);
  }
}
