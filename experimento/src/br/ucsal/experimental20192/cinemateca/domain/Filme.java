package br.ucsal.experimental20192.cinemateca.domain;

import br.ucsal.experimental20192.cinemateca.enums.GeneroAtorEnum;

import br.ucsal.experimental20192.cinemateca.enums.GeneroFilmeEnum;

public class Filme {

	private String titulo;
    private int codigo;
    private int anoLancamento;
    private String sinopse;
    private int qtdAtores = 20;
    private Ator[] elenco = new Ator[qtdAtores];
    //private int qtdFilmes = 20;
    // private Filme[] filmes = new Filme[qtdFilmes ];
    
   
	public Filme(String titulo, int anoLancamento, String sinopse) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.sinopse = sinopse;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getCodigo() {
        return codigo;
    }

    public Ator[] getElenco() {
        return elenco;
    }
    
    //public Filme[] getFilmes() {
    //	return filmes;
    //}

    //public void setFilme(Filme filme) {
		
    //for(int i = 0; i < qtdFilmes; i++){
    //  if(filmes[i] == null){
    //     filmes[i] = filme;
    //       }
    // }
		
    //}

    public boolean incluirAtorElenco(Ator ator){
        
    	for(Ator a: elenco) {
        if(a != null && ator.getNome().equals(a.getNome())) {
            return false;
        }
        if(ator.getAnoNascimento() > anoLancamento) {
        	return false;
        }
            }
    	
        for(int i = 0; i < qtdAtores; i++){
            if(elenco[i] == null){
                elenco[i] = ator;
                return true;
            }
        }
            return false;
    }

    public boolean removerAtorElenco(String nome){
    	
        for(int i = 0; i < qtdAtores; i++){
        	
            if(elenco[i] != null && elenco[i].getNome().equals(nome)){
                elenco[i] = null;
                return true;
            }
        }
        return false;
    }

    public Ator[] consultarElencoGenero(GeneroAtorEnum genero){
    	
        Ator[] elencoGenero = new Ator[20];
        int cont = 0;
        
            for (int i  = 0; i < qtdAtores; i++){
                if(elenco[i] != null && elenco[i].getGenero().equals(genero)){
                    elencoGenero[cont] = elenco[i];
                    cont++;
                }
            }
            return elencoGenero;
    }

    public Ator pesquisarAtor(String nome){
    	
        for(Ator a: elenco) {
            if(a != null && a.getNome().equals(nome)) {
            	 return a;
            }
        } 
        return null;
    }

    //public Ator[] consultarFilmePorGenero(GeneroFilmeEnum genero){
    	
    // Ator[] filmeGenero = new Ator[20];
    //  int cont = 0;
        
    //  for (int i  = 0; i < qtdFilmes; i++){
    //    if(filmes[i] != null && filmes[i].getGenero().equals(genero)){
    //         filmeGenero[cont] = filmes[i];
    //          cont++;
    //        }
    //    }
    //      return filmeGenero;
    // }
}
