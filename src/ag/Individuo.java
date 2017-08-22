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

    /*gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
        String solucao = Algoritmo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }
        System.out.println(genes+" | Aptidao = "+aptidao);
    }*/
    
    
    //Realiza o calculo de aptidao e quanto MENOR a aptidao, mais proximas sao as cores
    //https://stackoverflow.com/questions/2103368/color-logic-algorithm
    private void geraAptidao() {
    
    	int iSolucao = Integer.parseInt(Algoritmo.getSolucao(),2);       
    	int iGenes = Integer.parseInt(genes,2);
       
    	
    	Color cSolucao = new Color (iSolucao, true);
    	Color cGenes = new Color (iGenes, true);
    	
    	//System.out.println(cSolucao.toString());
    	
    	
    	double rmean = ( cSolucao.getRed() + cGenes.getRed() )/2;
    	  int r = cSolucao.getRed() - cGenes.getRed();
    	  int g = cSolucao.getGreen() - cGenes.getGreen();
    	  int b = cSolucao.getBlue() - cGenes.getBlue();
    	  double weightR = 2 + rmean/256;
    	  double weightG = 4.0;
    	  double weightB = 2 + (255-rmean)/256;
    	  aptidao = (int) Math.sqrt(weightR*r*r + weightG*g*g + weightB*b*b);
    	  
    	  //Calula luminosidade
    	  int lumin = iGenes;
    	  luminosidade = (   77  * ((lumin>>16)&255) 
                  + 150 * ((lumin>>8)&255) 
                  + 29  * ((lumin)&255))>>8;
    	  
    	  
    	  System.out.println(cGenes.toString()+" | Aptidao = "+aptidao+" | Lumin = "+luminosidade);
    	  
    	
    	  
    	  
    	  
    	  
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
}