package tn.esprit.rh.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@ExtendWith(MockitoExtension.class)
public class fournisseur {

	@InjectMocks
	FournisseurServiceImpl fournisseurServiceImpl;
	@Mock
	FournisseurRepository fournisseurRepository;

	//logging
	Fournisseur fornisseur = new Fournisseur(null,"100", "10", null, null, null,null);

	List<Fournisseur> list = new ArrayList<Fournisseur>() {

		{
			add(new Fournisseur());
			add(new Fournisseur());

		}
	};

	@Test
	void test_retrieveAllFournisseur_ok() {

		when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
		List<Fournisseur> response= fournisseurServiceImpl.retrieveAllReglements();
		assertEquals(0, response.size());
	}



}
