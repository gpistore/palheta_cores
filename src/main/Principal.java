package main;
import java.awt.Color;

import ag.*;
import view.tela;
;
public class Principal {
	
	tela telaMain;
	
	public Principal() {
		
		telaMain = new tela();
		
		
	}
	
	
	public int[] configurar(){
		

    	// RGB = 65536 * r + 256 * g + b;

    	
    	//Define a solu��o
    	int colorSolution = 65536 * 255 + 256 * 255 + 0;
        Algoritmo.setSolucao(Integer.toBinaryString(colorSolution));
        //Define os caracteres existentes
        Algoritmo.setCaracteres("1001");
        //taxa de crossover de 60% - diminui o crossover para pegar os melhores. 0.99
        Algoritmo.setTaxaDeCrossover(0.1);
        //taxa de muta��o de 3% 0.5
        Algoritmo.setTaxaDeMutacao(0.8);
        //elitismo
        boolean eltismo = true;
        //tamanho da popula��o 200
        int tamPop = 50;
        //numero máximo de gera��es
        int numMaxGeracoes = 150;

        //define o número de genes do indivíduo baseado na solu��o
        int numGenes = Algoritmo.getSolucao().length();

        //cria a primeira popula��o aleatérioa
        Populacao populacao = new Populacao(numGenes, tamPop);

        boolean temSolucao = false;
        int geracao = 0;

        System.out.println("Iniciando... Aptid�o da solu��o: "+Algoritmo.getSolucao().length());
        
        //loop até o critério de parada
        while (!temSolucao && geracao < numMaxGeracoes) {
            geracao++;

            //cria nova populacao
            populacao = Algoritmo.novaGeracao(populacao, eltismo);

            System.out.println("Gera��o " + geracao + " | Aptid�o: " + populacao.getIndividuo(0).getAptidao() + " | Melhor: " + populacao.getIndividuo(0).getGenes());
            
            //Printa na tela o progresso
            telaMain.setaCorProgresso(Integer.parseInt(populacao.getIndividuo(0).getGenes(),2));
            
            try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            //verifica se tem a solucao
            temSolucao = populacao.temSolucao(Algoritmo.getSolucao());
        }

        if (geracao == numMaxGeracoes) {
            System.out.println("Número Maximo de Gera��es | " + populacao.getIndividuo(0).getGenes() + " " + populacao.getIndividuo(0).getAptidao());
        }

        if (temSolucao) {
            System.out.println("Encontrado resultado na gera��o " + geracao + " | " + populacao.getIndividuo(0).getGenes() + " (Aptidão: " + populacao.getIndividuo(0).getAptidao() + ")");
        }
        
        
        System.out.println("------------------------------------");
        System.out.println("Melhores individuos para a palheta");
        System.out.println("------------------------------------");
        
       	int[] results = new int[9];
        
        for (int i = 0; i<9; i++) {
        
        	int iGen = Integer.parseInt(populacao.getIndividuo(i).getGenes(),2);
           
        	Color cGen = new Color (iGen, true);
        	results[i] = iGen;
        	
        	System.out.println(cGen.toString()+" |Aptidao = "+populacao.getIndividuo(i).getAptidao()+" | Lumin = "+populacao.getIndividuo(i).getLuminosidade() );
        }
        System.out.println("------------------------------------");
        
        
        return results;
		
	}

    public static void main(String[] args) {
    	
    		
    		
    		main.Principal algoritmo = new Principal();
    		
    		int [] results = algoritmo.configurar();
    		
    		
    		algoritmo.telaMain.setaCorDegrade(results);
    		
    	
    		
    }
}

   


