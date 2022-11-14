package tn.esprit.rh.achat;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class testProduit {

	
	  @InjectMocks
	    ProduitServiceImpl  produitService ;

	    @Mock
	    ProduitRepository produitRepository ;

	    @Test
	    public void testGetallProducts(){
	        when(produitRepository. findAll()).thenReturn(Stream
	                .of(new Produit(), new Produit()).collect(Collectors.toList()));
	        assertEquals(2, produitService.retrieveAllProduits().size());
	    }

	    @Test
	    public void addProduitTest(){
	        Produit prod = new Produit();
	        when(produitRepository.save(prod)).thenReturn(prod);
	        assertEquals(prod, produitService.addProduit(prod));
	    }

	    @Test
	    public void deleteUserTest(){
	        Produit prod = new Produit();
	        produitService.deleteProduit(prod.getIdProduit());
	        verify(produitRepository, times(1)).deleteById(prod.getIdProduit());
	    }

	    @Test
	    public void testUpdateProduct(){
	        Produit prod = new Produit();
	        when(produitRepository.save(prod)).thenReturn(prod);
	        assertEquals(prod, produitService.updateProduit(prod));
	    }

	    @Test
	    public void testGetProduct(){
	        Produit prod = new Produit();
	        when(produitRepository.findById(prod.getIdProduit())).thenReturn(Optional.of(prod));
	        assertEquals(prod, produitService.retrieveProduit(prod.getIdProduit()));
	    }

	}
