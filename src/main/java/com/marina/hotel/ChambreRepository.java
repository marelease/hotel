package com.marina.hotel;

import java.util.List;

public class ChambreRepository {

  private List<Chambre> chambres;

  ChambreRepository(List<Chambre> chambres) {
    this.chambres = chambres;
  }

  public List<Chambre> getChambres() {
    return List.copyOf(chambres);
  }
}
