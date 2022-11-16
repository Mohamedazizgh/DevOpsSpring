//test
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

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;


@ExtendWith(MockitoExtension.class)
class OperateurServiceImpTest {

	@Mock
	OperateurRepository operateurRepository;
	@InjectMocks
	OperateurServiceImpl impl;
	
	//initializer des objet
	Operateur operateur= new Operateur("eee","eee","eee");

	List<Operateur> r = new ArrayList<Operateur>() {
		
		{
			add(new Operateur("eee","eee","eee"));
			add(new Operateur("eee","eee","eee"));
			add(new Operateur("eee","eee","eee"));
		}
	};
	
	
	@Test
	void retrieveOperateur() {
		Mockito.when(operateurRepository.findAll()).thenReturn(r);
		List<Operateur> ops = impl.retrieveAllOperateurs();
		Assertions.assertNotNull(ops);
	}

	@Test
	void addOperateur() {
		Mockito.when(operateurRepository.save(operateur)).thenReturn(operateur);
		Operateur op = impl.addOperateur(operateur);
		Assertions.assertNotNull(op);
	}

	@Test
	void retrieveAllOperators() {
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
		Operateur op=impl.retrieveOperateur((long)2);
		Assertions.assertNotNull(op);
	}

	

	/*@Test
	void getChiffreAffaireEntreDeuxDate() {
		Mockito.doReturn(r).when(reglementRepository).findAll();
		float reg = reglementServiceImpl.getChiffreAffaireEntreDeuxDate(new Date(),new Date());
		Assertions.assertNotNull(reg);
	}*/
}
