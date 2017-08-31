package main;
import java.awt.Color;
import java.text.DecimalFormat;

import ag.*;
import view.tela;
;
public class Principal {
	
	tela telaMain;
	
	public Principal() {	
				
	}
	
	
	public String converteVetIntString(int vetCor[]){
		String conversao = "";
		
		for (int i =0; i< 5; i++){
			String temp = Integer.toBinaryString(vetCor[i]);
			int cond = temp.length();
			for (int j = 0; j < 24 - cond; j++){
				temp = 0+temp;
			}
			conversao = conversao + temp;
		}
		return conversao;
	}
	
	public int[] converteVetCorVetInt(Color vetCor[]){
		
		int[] intCores = new int[5];
	
		for (int i=0; i<5;i++) {
			intCores[i] = 65536 * vetCor[i].getRed() + 256 * vetCor[i].getGreen() + vetCor[i].getBlue();
		}
		
		return intCores;
	}
	
	public int[] converteStringVetInt(String cores){
			
	    	int[] vetCor = new int[5];
	    	int ind = 0;
	    	
			for (int i =0; i< 5; i++){
				for (int j = 0; j < 5; j++){
					vetCor[j] =Integer.parseInt(cores.substring((j*24),(j*24)+24),2);
				}
			}
			return vetCor;
	}
	
	public Color[] converteStringVetCor (String cores) {
		
		int[] vetInt = converteStringVetInt(cores);
		Color [] vetCor = new Color[5];
		
		for (int i=0; i<5; i++) {
			vetCor[i] = new Color(vetInt[i]);
		}
		
		return vetCor;
	}
	
	
	public Color[] execucao(Color[] colors, String caract, double crossover, double mutacao, boolean elitismo, int tamPopulacao, int numGeracao){
		
		
		
		int[] colorsSolutions = converteVetCorVetInt(colors);
		   	
		
    	String solucao = converteVetIntString(colorsSolutions);
    	
    	
    	Algoritmo.setSolucao(solucao);
        Algoritmo.setCaracteres(caract);
        
        Algoritmo.setTaxaDeCrossover(crossover);
        Algoritmo.setTaxaDeMutacao(mutacao);
        boolean eltismo = elitismo;
        int tamPop = tamPopulacao;
        int numMaxGeracoes = numGeracao;
        int numGenes = Algoritmo.getSolucao().length();

        //cria a primeira populacao aleatorio
        Populacao populacao = new Populacao(numGenes, tamPop);

        boolean temSolucao = false;
        int geracao = 0;

        while (!temSolucao && geracao < numMaxGeracoes) {

        	geracao++;
            populacao = Algoritmo.novaGeracao(populacao, eltismo);
            
            Color[] vetIteracao = converteStringVetCor(populacao.getIndividuo(0).getGenes());
        
            for (int i =0; i < 5; i++) {
            	tela.coresSolucao[i].setBackground(vetIteracao[i]);
            }
            
            tela.tfStatus.setText("Aguarde! Geração "+geracao+" (Aptidão = "+populacao.getIndividuo(0).getAptidao()+")");
            
          
              
            temSolucao = populacao.temSolucao(Algoritmo.getSolucao());
        }

        if (geracao == numMaxGeracoes) {
        	tela.tfStatus.setText("Não convergiu para a solução com os parâmetros informados");
        	return null;
        }

        if (temSolucao) {
        	Color[] vetResultado = converteStringVetCor(populacao.getIndividuo(0).getGenes());
        	tela.tfStatus.setText("Convergiu na geração "+geracao);
        	return vetResultado;
        }
        return null;
	}
}