package br.ucsal.experimental20192.cinemateca.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ucsal.experimental20192.cinemateca.enums.GeneroAtorEnum;

public class ExemploTest {

	@Before
	public void setUp() {
		// TODO: Se necessario realizar setUp antes do teste
	}

	// Método que deverá ser testado
	@Test
	public void metodoTest() {
		// Dados de Entrada

		// Valor Esperado

		// Execução do método a ser testado

		// Comparação do valor retornado com o esperado

	}
	
	@Test 
	public void incluirAtorElenco(){
	
		Ator ator = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);
		
		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");
	
		Assert.assertTrue(filme.incluirAtorElenco(ator));
	}

	@Test
	public void incluirAtorMaisNovoFilme(){
		
		Ator ator = new Ator("CJ", 2008, GeneroAtorEnum.MASCULINO);
		
		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");
		
		Assert.assertFalse(filme.incluirAtorElenco(ator));
	}

	@Test 
	public void incluirAtorRepetido(){
		
        Ator ator = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);
        Ator ator1 = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);
        
		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");
		filme.incluirAtorElenco(ator1);
		
		Assert.assertFalse(filme.incluirAtorElenco(ator));
	}
	
	@Test 
	public void removerAtorElenco(){
		
		Ator ator = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);

		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");
		filme.incluirAtorElenco(ator);
		
		Assert.assertTrue(filme.removerAtorElenco("CJ"));
	}

	//
	@SuppressWarnings("deprecation")
	@Test
	public void consultarElencoGeneroMasc(){
		
		Ator ator = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);
		Ator ator2 = new Ator("CJx", 1998, GeneroAtorEnum.MASCULINO);
		Ator ator3 = new Ator("CJxx", 1998, GeneroAtorEnum.FEMININO);
		
		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");
		
		filme.incluirAtorElenco(ator);
		filme.incluirAtorElenco(ator2);
		filme.incluirAtorElenco(ator3);
		
		Ator[] esperado = {ator, ator2, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null};
		
		Assert.assertEquals(esperado, filme.consultarElencoGenero(GeneroAtorEnum.MASCULINO));
	}
	
	@Test
	public void pesquisarAtor(){
		
		Ator ator = new Ator("CJ", 1998, GeneroAtorEnum.MASCULINO);
		Filme filme = new Filme("GTA", 2006, "san andreas city bad stuffs");

		filme.incluirAtorElenco(ator);
		
		Assert.assertEquals(ator, filme.pesquisarAtor("CJ"));

	}
}
