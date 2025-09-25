package com.marina.hotel;

import java.util.List;

public class ChambreService {

  private ChambreRepository repository;

  public ChambreService(ChambreRepository repository) {
    this.repository = repository;
  }

  public List<Chambre> getAllChambres() {
    return repository.getChambres();
  }

  public List<Chambre> getChambresLibres() {
    return repository.getChambres().stream().filter(Chambre::isLibre).toList();
  }
}
