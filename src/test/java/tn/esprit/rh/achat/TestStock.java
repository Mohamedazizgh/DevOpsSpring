package tn.esprit.rh.achat.services;

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

import tn.esprit.rh.achat.entities.Stock;

import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestStock {

	@InjectMocks
	StockServiceImpl stockServiceImpl ;
	@Mock
	StockRepository stockRepository;
	
	//logging
	Stock stock = new stock(null,100, 10, null, null, null);
	
	List<Stock> list = new ArrayList<Stock>() {
		
		{
			add(new Stock());
			add(new Stock());
			
		}
	};

	@Test
	void test_retrieveAllStocks_ok() {
		
		when(stockRepository.findAll()).thenReturn(new ArrayList());
		List<Stock> response= stockServiceImpl.retrieveAllStocks();
		assertEquals(0, response.size());
	}
	
	@Test
	void test_addStock_ok() {
		Stock s= new Stock();
		s.setIdStock(1L);
		//mock
		when(stockRepository.save(any())).thenReturn(s);	
		//call function 
		stockServiceImpl.addStock(new Stock());
		
		//assert
		assertEquals(1L, s.getIdStock());
		}
	
	
	public void selectOne(){
	Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
	Stock stc = stockServiceImpl.retrieveStock((long) 2 );
	
	Assertions.assertNotNull(stc);
	}
	

	

	
}
