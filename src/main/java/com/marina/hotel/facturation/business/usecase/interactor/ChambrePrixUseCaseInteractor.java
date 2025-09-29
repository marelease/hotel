package com.marina.hotel.facturation.business.usecase.interactor;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.business.usecase.ChambrePrixUseCase;
import com.marina.hotel.facturation.gateway.ChambreRepository;
import com.marina.hotel.facturation.presenter.PrixChambrePresenter;
import java.util.List;
import java.util.Optional;

public class ChambrePrixUseCaseInteractor implements ChambrePrixUseCase {

  private final ChambreRepository repository;

  public ChambrePrixUseCaseInteractor(ChambreRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Chambre> getAllChambres() {
    return repository.getChambres();
  }

  @Override
  public double getPrix(Chambre chambre, PrixChambrePresenter presenter) {
    double prix = chambre.calculerPrix(repository.getPrixRDC());
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
