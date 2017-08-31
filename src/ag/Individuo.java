package ag;
import java.awt.Color;
import java.util.Random;

public class Individuo {

    private String genes = "";
    private int aptidao = 0;
    private int luminosidade = 0;

    //gera um indivíduo aleatório
    public Individuo(int numGenes) {
        genes = "";
        Random r = new Random();
        
        String caracteres = Algoritmo.getCaracteres();
        
        for (int i = 0; i < numGenes; i++) {
            genes += caracteres.charAt(r.nextInt(caracteres.length()));
        }
     
        geraAptidao();        
    }

    //cria um indivíduo com os genes definidos
    public Individuo(String genes) {    
        this.genes = genes;
        
        Random r = new Random();
        //se for mutar, cria um gene aleatório
        if (r.nextDouble() <= Algoritmo.getTaxaDeMutacao()) {
            String caracteres = Algoritmo.getCaracteres();
            String geneNovo="";
            int posAleatoria = r.nextInt(genes.length());
            for (int i = 0; i < genes.length(); i++) {
                if (i==posAleatoria){
                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo += genes.charAt(i);
                }
                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }

   
    
  
    //Realiza o calculo de aptidao e quanto MENOR a aptidao, mais proximas sao as cores
    //https://stackoverflow.com/questions/2103368/color-logic-algorithm
    private void geraAptidao2() {
    
    	int[]iSolucao = converte(Algoritmo.getSolucao());
    	int []iGenes = converte(genes);
    	Color[] cSolucao = new Color[5];
    	Color[] cGenes = new Color[5];
    	
    	for (int i =0; i<5;i++){
    		cSolucao[i] = new Color(iSolucao[i],true);
    	}
    	for (int i =0; i<5;i++){
    		cGenes[i] = new Color(iGenes[i],true);
    	}
    	for (int i = 0; i<5;i++ ){
    		
    		double rmean = ( cSolucao[i].getRed() + cGenes[i].getRed() )/2;
    		int r = cSolucao[i].getRed() - cGenes[i].getRed();
    		int g = cSolucao[i].getGreen() - cGenes[i].getGreen();
    		int b = cSolucao[i].getBlue() - cGenes[i].getBlue();
    		double weightR = 2 + rmean/256;
    		double weightG = 4.0;
    		double weightB = 2 + (255-rmean)/256;
    	 
    		int tmpAptidao = (int) Math.sqrt(weightR*r*r + weightG*g*g + weightB*b*b);
    		if (tmpAptidao > aptidao ) {
    			aptidao = tmpAptidao;
    		}
    	}
    	  
    }
    
    private void geraAptidao() {
        String solucao = Algoritmo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }
    }
    public int getAptidao() {
        return aptidao;
    }

    public String getGenes() {
        return genes;
    }
    
    public int getLuminosidade() {
    	return luminosidade;
    }
    public int[] converte(String cores){
		
    	int[] vetCor = new int[5];
    	int ind = 0;
    	
    	for (int i =0; i< 5; i++){
			for (int j = 0; j < 5; j++){
				vetCor[j] =Integer.parseInt(cores.substring((j*24),(j*24)+24),2);
			}
		}
		return vetCor;
    }
}