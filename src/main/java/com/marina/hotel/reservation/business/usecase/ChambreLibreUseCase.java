package com.marina.hotel.reservation.business.usecase;

import com.marina.hotel.reservation.business.entity.ChambrePourReservation;
import java.util.List;

public interface ChambreLibreUseCase {

  List<ChambrePourReservation> getChambresLibres();
}
