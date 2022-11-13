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
public class ProductServiceImplMockTest {

	@Mock
	ProduitRepository produitRepo;

	@Mock
	StockRepository stRepo;
	
	@InjectMocks
	ProduitServiceImpl produitService;
	

    @BeforeEach
    void
    setUp() {
        produitRepo.deleteAll();
    }

    @AfterEach
    void
    setDown() {
        produitRepo.deleteAll();
    }
	
	@Test
	@Order(0)
	public void verifierPrixProduit() {
        log.info("MOCK : verifierMaxPrix : verif if price > 0" );
		Produit p1 = Produit.builder().libelleProduit("lib").codeProduit("codeprod").prix(10).build();
	    Assertions.assertTrue(p1.getPrix()>0);
	}
	
	@Test
	@Order(1)
	public void addStockIfMinimumQuantity() {
        log.info("MOCK : addStockIfMinimumQuantity : add stock if minimum quantity" );
        //creating product/stock
		Produit p1 = Produit.builder().libelleProduit("lib").codeProduit("codeprod").prix(10).build();
		Stock s1 = Stock.builder().libelleStock("libstock").qte(0).qteMin(1).build();
		Assertions.assertNotNull(s1);
		Assertions.assertNotNull(p1);
		//affect stock to prod
		p1.setStock(s1);
		//affect product to stock
	    s1.setQte(s1.getQte()+1);
	    //added stock
        Mockito.when(stRepo.save(Mockito.any())).thenReturn(s1);
        var stockadded = stRepo.save(s1);
        
        log.info("Actual quantity : " +stockadded.getQte());
        log.info("Expected minimum quantity : " +stockadded.getQteMin()); 
		Assertions.assertTrue(stockadded.getQte()>=stockadded.getQteMin());
		
	}

	@Test
	@Order(2)
	public void affectStockToProduit() {
        log.info("MOCK : affectStockToProduit : assign right stock to prod" );
        //creating product/stock
		Produit p1 = Produit.builder().libelleProduit("lib").codeProduit("codeprod").prix(10).build();
		Stock s1 = Stock.builder().libelleStock("libstock").qte(0).qteMin(1).build();
		//Making sure not null
		Assertions.assertNotNull(s1);
		Assertions.assertNotNull(p1);
		//Affect stock to prod
		p1.setStock(s1);
		Mockito.when(produitRepo.save(Mockito.any())).thenReturn(p1);
	    var productadded = produitRepo.save(p1);
	        
        //Checking
        log.info("Expected stock : " + s1.getLibelleStock());
        log.info("Affected stock  " + productadded.getStock().getLibelleStock());			
     	Assertions.assertEquals (productadded.getStock(), s1);


	}