package com.marina.hotel.application.port.server;

import com.marina.hotel.application.Chambre;

import java.util.List;

public interface ChambreRepository {

  List<Chambre> getChambres();

  double getPrixRDC();
}
