package tn.esprit.rh.achat.services;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ProduitRepository;


import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
    
    @Mock
    FactureRepository factureRepository;
    @Mock
    DetailFactureRepository detailFactureRepository;
    
    @Mock
    ProduitRepository produitRepository;
    
    @Mock
    CategorieProduitRepository categorieProduitRepository;
    
    @InjectMocks
    FactureServiceImpl factureServiceImpl;
    
    @InjectMocks
    ProduitServiceImpl produitServiceImpl;
    
    @InjectMocks
    CategorieProduitServiceImpl categorieProduitServiceImpl;
    

    
    @Test
    public void sommeFactureTest() {
        log.info("test : sommeFactureTest" );

        Float sum = 0F;

        CategorieProduit cProduit = CategorieProduit.builder().codeCategorie("code1")
                .libelleCategorie("libelle categ").idCategorieProduit(1L).build();
        Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(cProduit));
        Stock stock = Stock.builder().libelleStock("lib stock").qte(10).qteMin(50).idStock(1L).build();
        
        Produit p1 = Produit.builder().codeProduit("code1").libelleProduit("lib1").prix(50.9F).categorieProduit(cProduit).stock(stock)
                .idProduit(1L).build();
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
        p1.setCategorieProduit(cProduit);
        DetailFacture detailFacture = DetailFacture.builder().montantRemise(0F).pourcentageRemise(0).qteCommandee(9).produit(p1).build();
        Facture facture = Facture.builder().dateCreationFacture(new Date()).build();
        HashSet<DetailFacture> detailsList = new HashSet<DetailFacture>();
        detailsList.add(detailFacture);
        
        facture = factureServiceImpl.addDetailsFacture(facture, detailsList);

       
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        
        for (DetailFacture detailFacture2 : detailsList) {
            sum += detailFacture2.getProduit().getPrix()* detailFacture2.getQteCommandee();
        }

        log.info("expected sum="+ sum );
        log.info("actual sum="+ facture.getMontantFacture() );
        log.info("test : finished sommeFactureTest" );


        assertEquals(sum, facture.getMontantFacture());
    }

}
