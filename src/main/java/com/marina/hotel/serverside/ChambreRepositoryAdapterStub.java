package com.marina.hotel.serverside;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.gateway.ChambreRepository;
import java.util.List;

public class ChambreRepositoryAdapterStub implements ChambreRepository {

  private final double prixRDC;
  private final List<Chambre> chambres;

  public ChambreRepositoryAdapterStub() {
    this(100);
  }

  public ChambreRepositoryAdapterStub(double prixRDC) {
    this.chambres =
        List.of(
            new Chambre(true, 0, 10),
            new Chambre(true, 0, 15),
            new Chambre(true, 1, 2),
            new Chambre(true, 1, 7),
            new Chambre(true, 2, 9),
            new Chambre(true, 3, 15),
            new Chambre(true, 3, 20),
            new Chambre(true, 3, 33));
    this.prixRDC = prixRDC;
  }

  @Override
  public List<Chambre> getChambres() {
    return List.copyOf(chambres);
  }

  @Override
  public double getPrixRDC() {
    return prixRDC;
  }
}
