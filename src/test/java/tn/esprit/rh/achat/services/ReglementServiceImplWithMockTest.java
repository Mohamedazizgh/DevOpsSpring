// write test for reglement service with mockito
/*package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;

@RunWith(MockitoJUnitRunner.class)
// @ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ReglementServiceImplWithMockTest {
    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementService;

    @BeforeEach
    void setUp() {
        reglementRepository.deleteAll();
    }

    @AfterEach
    void setDown() {
        reglementRepository.deleteAll();
    }

    @Test
    public void GIVEN_3_REGLEMENTS_WHEN_retrieveAllReglements_THEN_EXPECT_3() {
        var listReglements = new ArrayList<Reglement>();
        Calendar firstDate = Calendar.getInstance();
        Calendar secondDate = Calendar.getInstance();
        Calendar thirdDate = Calendar.getInstance();
        firstDate.set(Calendar.YEAR, 1988);
        firstDate.set(Calendar.MONTH, Calendar.JANUARY);
        firstDate.set(Calendar.DAY_OF_MONTH, 1);
        secondDate.set(Calendar.YEAR, 2010);
        secondDate.set(Calendar.MONTH, Calendar.FEBRUARY);
        secondDate.set(Calendar.DAY_OF_MONTH, 20);
        thirdDate.set(Calendar.YEAR, 2020);
        thirdDate.set(Calendar.MONTH, Calendar.NOVEMBER);
        thirdDate.set(Calendar.DAY_OF_MONTH, 22);
        var reglement1 = new Reglement(500.03F, 200.2F, false, firstDate.getTime());
        var reglement2 = new Reglement(1000.300F, 0F, true, secondDate.getTime());
        var reglement3 = new Reglement(0F, 1500.2F, false, thirdDate.getTime());
        listReglements.add(reglement1);
        listReglements.add(reglement2);
        listReglements.add(reglement3);
        Mockito.when(reglementRepository.findAll()).thenReturn(listReglements);
        var res = reglementService.retrieveAllReglements();
        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void GIVEN_FACTURE_WHEN_addReglement_THEN_EXPECT_reglement_added() {
        var listReglements = new ArrayList<Reglement>();
        var f = new Facture();
        Calendar firstDate = Calendar.getInstance();
        firstDate.set(Calendar.YEAR, 2022);
        firstDate.set(Calendar.MONTH, Calendar.JANUARY);
        firstDate.set(Calendar.DAY_OF_MONTH, 1);
        f.setIdFacture(1L);
        f.setMontantRemise(5000F);
        f.setMontantFacture(90000F);
        var reglement1 = new Reglement((float) 1000.300, (float) 0, true, firstDate.getTime());
        reglement1.setFacture(f);
      //  Mockito.when(reglementRepository.save(Mockito.any())).thenReturn(reglement1);
        // var res = reglementService.addReglement(reglement1);
        Assertions.assertEquals(5000F, res.getFacture().getMontantRemise(), 0.0001);
        // check if reglement is added
        listReglements.add(reglement1);

        Mockito.when(reglementRepository.findAll()).thenReturn(listReglements);
        var res2 = reglementService.retrieveAllReglements();
        Assertions.assertEquals(1, res2.size());
    }
}*/
