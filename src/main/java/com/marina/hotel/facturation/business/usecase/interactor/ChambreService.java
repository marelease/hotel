package com.marina.hotel.facturation.business.usecase.interactor;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.business.usecase.ChambreUseCase;
import com.marina.hotel.facturation.gateway.ChambreRepository;
import com.marina.hotel.facturation.presenter.PrixChambrePresenter;
import java.util.List;
import java.util.Optional;

public class ChambreService implements ChambreUseCase {

  private final ChambreRepository repository;

  public ChambreService(ChambreRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Chambre> getAllChambres() {
    return repository.getChambres();
  }

  @Override
  public List<Chambre> getChambresLibres() {
    return getAllChambres().stream().filter(Chambre::isLibre).toList();
  }

  @Override
  public double getPrix(Chambre chambre, PrixChambrePresenter presenter) {
    double prixRDC = repository.getPrixRDC();
    double prixCalcule = switch (chambre.etage()) {
      case 0 -> prixRDC;
      case 1 -> prixRDC * 1.07;
      case 2 -> prixRDC * 1.22;
      case 3 -> prixRDC * 1.33;
      default -> throw new IllegalArgumentException("Etage de chambre non valide");
    };
    double prix = Math.min(200, prixCalcule);
    presenter.presenter(prix);
    return prix;
  }

  @Override
  public Optional<Chambre> findChambre(int etage, int numero) {
    return getAllChambres().stream()
        .filter(chambre -> chambre.etage() == etage && chambre.numero() == numero)
        .findAny();
  }
}
