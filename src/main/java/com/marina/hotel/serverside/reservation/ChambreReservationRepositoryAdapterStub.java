package com.marina.hotel.serverside.reservation;

import com.marina.hotel.reservation.business.entity.ChambrePourReservation;
import com.marina.hotel.reservation.gateway.ChambreReservationRepository;
import java.util.List;
import java.util.stream.Stream;

public class ChambreReservationRepositoryAdapterStub implements ChambreReservationRepository {

  private List<ChambrePourReservation> chambres;

  public ChambreReservationRepositoryAdapterStub() {
    this.chambres =
        List.of(
            new ChambrePourReservation(true, 0, 10),
            new ChambrePourReservation(true, 0, 15),
            new ChambrePourReservation(true, 1, 2),
            new ChambrePourReservation(true, 1, 7),
            new ChambrePourReservation(true, 2, 9),
            new ChambrePourReservation(true, 3, 15),
            new ChambrePourReservation(true, 3, 20),
            new ChambrePourReservation(true, 3, 33));
  }

  @Override
  public List<ChambrePourReservation> getChambres() {
    return List.copyOf(chambres);
  }

  @Override
  public void save(ChambrePourReservation chambre) {
    Stream<ChambrePourReservation> chambresNonModifiees =
        getChambres().stream()
            .filter(candidate -> !candidate.getIdentifiant().equals(chambre.getIdentifiant()));
    Stream<ChambrePourReservation> chambreModifiee =
        getChambres().stream()
            .filter(candidate -> candidate.getIdentifiant().equals(chambre.getIdentifiant()))
            .findAny()
            .map(
                candidate ->
                    new ChambrePourReservation(
                        chambre.isLibre(), chambre.etage(), chambre.numero()))
            .stream();
    this.chambres = Stream.concat(chambresNonModifiees, chambreModifiee).toList();
  }
}
