package com.jalautopecas.tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

import com.jalautopecas.models.CotacaoDeProduto;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.VendedorRepository;

public class RepositoryTest {

	private static final long ID_VENDEDOR_SISLON = 1l;
	private static final long ID_VENDEDOR_IRISMAR = 2l;
	private static final long ID_COTACAO_100 = 100l;
	private static final long ID_COTACAO_101 = 101l;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public void run(ApplicationArguments applicationArguments)
	throws Exception{
		Vendedor sislon = new Vendedor(ID_VENDEDOR_SISLON,"Sislon");
		CotacaoDeProduto cotacao = new CotacaoDeProduto(ID_COTACAO_100, "Item 1", "UNO", "FIRE", "2018", "", "", "",sislon);
		CotacaoDeProduto cotacao2 = new CotacaoDeProduto(ID_COTACAO_101, "Item 2", "UNO", "MILLE", "2019", "", "", "",sislon);
		List<CotacaoDeProduto> cotacoes = new ArrayList<CotacaoDeProduto>();
		cotacoes.add(cotacao);
		cotacoes.add(cotacao2);
		

		
	}
}
