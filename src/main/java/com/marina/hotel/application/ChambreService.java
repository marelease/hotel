package com.marina.hotel.application;

import com.marina.hotel.application.port.server.ChambreRepository;

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
    return getAllChambres().stream().filter(Chambre::isLibre).toList();
  }

  public double getPrix(Chambre chambre) {
    double prixRDC = repository.getPrixRDC();
    double prixCalcule = switch (chambre.getEtage()) {
      case 0 -> prixRDC;
      case 1 -> prixRDC * 1.07;
      case 2 -> prixRDC * 1.22;
      case 3 -> prixRDC * 1.33;
      default -> throw new IllegalArgumentException("Etage de chambre non valide");
    };
    return Math.min(200, prixCalcule);
  }
}
