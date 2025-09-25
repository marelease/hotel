package com.marina.hotel;

import com.marina.hotel.application.Chambre;
import com.marina.hotel.application.port.server.ChambreRepository;

import java.util.ArrayList;
import java.util.List;

public class ChambreRepositoryAdapterFake implements ChambreRepository {

  private final double prixRDC;
  private List<Chambre> chambres;

  public ChambreRepositoryAdapterFake() {
    this(100);
  }

  public ChambreRepositoryAdapterFake(double prixRDC) {
    this.chambres = new ArrayList<>();
    this.prixRDC = prixRDC;
  }

  public Chambre ajouterChambre(int etage, boolean isLibre) {
    etage = Math.max(etage, 0);
    Chambre chambre = new Chambre(isLibre, etage);
    this.chambres.add(chambre);
    return chambre;
  }

  public void clear() {
    this.chambres.clear();
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
