package com.marina.hotel.facturation.business.usecase;

import com.marina.hotel.facturation.business.entity.Chambre;
import com.marina.hotel.facturation.presenter.PrixChambrePresenter;
import java.util.List;
import java.util.Optional;

public interface ChambrePrixUseCase {

  List<Chambre> getAllChambres();

  double getPrix(Chambre chambre, PrixChambrePresenter presenter);

  Optional<Chambre> findChambre(int etage, int numero);
}
