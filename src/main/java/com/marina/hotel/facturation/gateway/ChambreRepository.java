package com.marina.hotel.facturation.gateway;

import com.marina.hotel.facturation.business.entity.Chambre;
import java.util.List;

public interface ChambreRepository {

  List<Chambre> getChambres();

  double getPrixRDC();

}
