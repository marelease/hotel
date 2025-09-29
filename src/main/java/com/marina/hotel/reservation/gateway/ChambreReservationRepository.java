package com.marina.hotel.reservation.gateway;

import com.marina.hotel.reservation.business.entity.ChambrePourReservation;
import java.util.List;

public interface ChambreReservationRepository {

  void save(ChambrePourReservation chambre);

  List<ChambrePourReservation> getChambres();
}
