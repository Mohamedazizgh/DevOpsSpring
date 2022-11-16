package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;


@ExtendWith(MockitoExtension.class)
class SecteurActiviteTest {

	@Mock
	SecteurActiviteRepository secteurRepository;
	@InjectMocks
	SecteurActiviteServiceImpl secteurServiceImpl;
	
	//initializer des objet
	SecteurActivite secteuractivite= new SecteurActivite ((long)1,"sec 1 ","sec 1 ",null);

	List<SecteurActivite> r = new ArrayList<SecteurActivite>() {
		
		{
			add(new SecteurActivite((long)1,"Prod 1 ","Prod 1 ",null));
			add(new SecteurActivite((long)1,"Prod 1 ","Prod 1 ",null));
			add(new SecteurActivite((long)1,"Prod 1 ","Prod 1 ", null));
		}
	};
	
	
	@Test
	void retrieveAllReglements() {
		Mockito.doReturn(r).when(secteurRepository).findAll();
		List<SecteurActivite> prods = secteurServiceImpl.retrieveAllSecteurActivite();
		Assertions.assertNotNull(prods);
	}

	@Test
	void addReglement() {
		SecteurActivite secteur=new SecteurActivite();
		Mockito.when(secteurRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(secteuractivite);
		SecteurActivite sec = secteurServiceImpl.addSecteurActivite(secteur);
		Assertions.assertNotNull(sec);
	}

	@Test
	void retrieveReglement() {
		Mockito.when(secteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteuractivite));
		SecteurActivite sec1=secteurServiceImpl.retrieveSecteurActivite((long)2);
		Assertions.assertNotNull(sec1);
	}

	@Test
	void retrieveReglementByFacture() {
		Mockito.when(secteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteuractivite));
		SecteurActivite sec1=secteurServiceImpl.retrieveSecteurActivite((long)2);
		Assertions.assertNotNull(sec1);

	}

	/*@Test
	void getChiffreAffaireEntreDeuxDate() {
		Mockito.doReturn(r).when(reglementRepository).findAll();
		float reg = reglementServiceImpl.getChiffreAffaireEntreDeuxDate(new Date(),new Date());
		Assertions.assertNotNull(reg);
	}*/
}