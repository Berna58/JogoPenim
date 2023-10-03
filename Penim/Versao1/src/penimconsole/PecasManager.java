package penimconsole;

import java.util.ArrayList;                 

public class PecasManager {                  //esta classe gerencia as listas de peças
    Lista quadroGrande;        //cria as listas de acordo com cada tipo de peça
    Lista ovalGrande;          
    Lista quadroPequeno;
    Lista ovalPequeno;
    Lista circPequeno;
            
    PecasManager(int dificuldade){                  //o construtor recebe um nível de dificuldade
        quadroGrande = new Lista();    //as listas ligadas sao instanciadas.
        ovalGrande = new Lista();
        quadroPequeno = new Lista();
        ovalPequeno = new Lista();
        circPequeno = new Lista();
        
        for(int i=0;i<3;i++) quadroGrande.add(1);           //adiciona as peças padrão em cada lista, de acordo com seu tipo.
    	for(int i=0;i<5;i++) ovalGrande.add(2);
    	for(int i=0;i<7;i++) quadroPequeno.add(3);
		
	    switch(dificuldade) {                           //de acordo com a dificuldade, adiciona as peças.
            case 2:{
		          for(int i=0;i<9;i++) ovalPequeno.add(4);          //se a dificuldade for 2, adiciona as peças ovais pequenas.
		          break;
            }
            case 3:{
		          for(int i=0;i<9;i++) ovalPequeno.add(4);          //se a dificuldade for 3, adiciona tanto as ovais como as circulares.
		          for(int i=0;i<11;i++) circPequeno.add(5);
		          break;
            }
        }	
    }

    void showRestantes() {                      //esta função mostra quais peças ainda estão no jogo.
       if(!quadroGrande.isEmpty()) System.out.println("1 - Quadrado Grande: " + quadroGrande.size() + " peças restantes.");         //se houver peças quadradas grandes, isso indica a quantidade existente.
	   if(!ovalGrande.isEmpty()) System.out.println("2 - Oval Grande: " + ovalGrande.size() + " peças restantes.");             //o mesmo para os outros tipos de peça
	   if(!quadroPequeno.isEmpty()) System.out.println("3 - Quadrado Pequeno: " + quadroPequeno.size() + " peças restantes.");
	   if(!ovalPequeno.isEmpty()) System.out.println("4 - Oval Pequeno: " + ovalPequeno.size() + " peças restantes.");
	   if(!circPequeno.isEmpty()) System.out.println("5 - Circulo Pequeno: " + circPequeno.size() + " peças restantes.");
    }
    
    void remove(int peca, int quantidade){              //esta função remove uma determinada quantidade de peças de um determinado tipo.
        switch(peca) {                                  //de acordo com o tipo de peça
                case 1:{
                        if(quadroGrande.size()<quantidade) quantidade = quadroGrande.size();        //se houver menos peças do que a quantidade removida, todas as peças serão removidas.
                        if(quantidade<1) quantidade = 1;                                            //se o valor a ser removido for 0 ou menos, uma peça é removida.
                        for (int i = 0; i < quantidade; i++) {                                      //fora isso, são removidos a quantidade especificada de peças.
                                quadroGrande.remove();                                             //a peça removida é a do index(0), logo, a primeira peça da lista ligada.
                        }
                        break;
                }
                case 2:{                        //o mesmo processo se repete para as outras peças.
                        if(ovalGrande.size()<quantidade) quantidade = ovalGrande.size();
                        if(quantidade<1) quantidade = 1;
                        for (int i = 0; i < quantidade; i++) {
                                ovalGrande.remove();
                        }
                        break;
                }
                case 3:{
                        if(quadroPequeno.size()<quantidade) quantidade = quadroPequeno.size();
                        if(quantidade<1) quantidade = 1;
                        for (int i = 0; i < quantidade; i++) {
                                quadroPequeno.remove();
                        }
                        break;
                }
                case 4:{
                        if(ovalPequeno.size()<quantidade) quantidade = ovalPequeno.size();
                        if(quantidade<1) quantidade = 1;
                        for (int i = 0; i < quantidade; i++) {
                                ovalPequeno.remove();
                        }
                        break;
                }
                case 5:{
                        if(circPequeno.size()<quantidade) quantidade = circPequeno.size();
                        if(quantidade<1) quantidade = 1;
                        for (int i = 0; i < quantidade; i++) {
                                circPequeno.remove();
                        }
                        break;
                }
        }
    }

    boolean isEmpty() {             //esta função determina se ainda há peças no jogo, se todas as listas ligadas estiverem vazias.
        return quadroGrande.isEmpty()&&ovalGrande.isEmpty()&&quadroPequeno.isEmpty()&&ovalPequeno.isEmpty()&&circPequeno.isEmpty();
    }
}
