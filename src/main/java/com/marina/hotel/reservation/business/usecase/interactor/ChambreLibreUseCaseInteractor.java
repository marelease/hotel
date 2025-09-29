package com.marina.hotel.reservation.business.usecase.interactor;

import com.marina.hotel.reservation.business.entity.ChambrePourReservation;
import com.marina.hotel.reservation.business.usecase.ChambreLibreUseCase;
import com.marina.hotel.reservation.gateway.ChambreReservationRepository;
import java.util.List;

public class ChambreLibreUseCaseInteractor implements ChambreLibreUseCase {

  private final ChambreReservationRepository repository;

  public ChambreLibreUseCaseInteractor(ChambreReservationRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<ChambrePourReservation> getChambresLibres() {
    return repository.getChambres().stream().filter(ChambrePourReservation::isLibre).toList();
  }
}
