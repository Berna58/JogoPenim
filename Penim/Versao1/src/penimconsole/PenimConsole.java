package penimconsole;

import java.util.Scanner;	//o scanner é importado para fazer a entrada de dados.

public class PenimConsole {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);	//o scanner é instanciado com o buffer de entrada System.in.
		PecasManager pecas;                             //o gerenciador de peças é criado
                
                int opc;
		int dificuldade = 1;            //variável responsável por guardar a dificuldade do jogo.
		int player = 1;                 //variável que indica o jogador ativo.
		int peca;                       //variável que indica a peça a ser removida.
		int quantidade;			//variável que indica a quantidade de peças a serem removidas.
                
                boolean opcMenu1;
                do{
                    System.out.println("-- PENIM MENU --");
                    System.out.println(
                        "Seleciona a opção: \n" +
                        "  1) Jogar\n" +
                        "  2) Instruções\n" +
                        "  3) Sair\n "
                    );
                    opc = entrada.nextInt();

                    if(opc < 1 || opc > 3){
                        opcMenu1 = false;
                        System.out.println("Introduza uma opção correcta!");
                    }
                    else {
                        opcMenu1 = true;
                    }
                } while (opcMenu1 == false);   
                
                estadoMenu: while(true){
                switch (opc) {
                case 1: //Opção Jogar
                    System.out.println("ESCOLHA A DIFICULDADE");	//o primeiro menu é responsável por mostrar as dificuldades.
                    System.out.println("1 - Fácil.");
                    System.out.println("2 - Médio.");
                    System.out.println("3 - Difícil.");
                    System.out.println("4 - Sair.");
                    System.out.println("=====================");
                    dificuldade = entrada.nextInt();
                    break;
                case 2: //Opção Instruções
                    System.out.println(
                        "Instruções: \n"+
                        "Cada jogador, alternadamente, retira uma ou mais peças de jogo, \n"+
                        "mas de cada vez só podem ser retiradas peças do mesmo tipo em cada \n" +
                        "jogada realizada. \n"+
                        "Em cada jogada o jogadro é detentor de todas as peças em jogo, isto é, \n"+
                        "todas as peças que ainda não foram retiradas de jogo podem ser \n"+
                        "retiradas pelo jogador detentor da jogada.\n"+
                        "Ganha o jogador que realizar a última jogada, isto é, o jogador que \n"+
                        "retirar a última peça de jogo ou as últimas peças do jogo.");
                  break estadoMenu;
                case 3: //Opção Sair
                  break estadoMenu;
                default:
                  System.out.println("Opção Incorreta");
                  break;
            }
            
                	//a entrada é transformada de texto para inteiro, e guardada na variável dificuldade.
				
		if(dificuldade == 4){                                   //se a váriável possuir o valor 4, o jogo é cancelado, e o programa encerra.
                    System.exit(1);                               //encerra o jogo com valor 1, de bem sucedido.
		}
                pecas = new PecasManager(dificuldade);                          //o gerenciador de peças é instanciado com a dificuldade indicada.
		
		while(true) {                                                   //o loop continua até algo interrompê-lo.
			System.out.println("Jogador: " + player);               //mostra o jogador ativo
			System.out.println("Qual peça deseja remover? ");	//pergunta qual peça deve ser removida.
			pecas.showRestantes();					//mostra as peças que ainda estão no jogo.
			peca = entrada.nextInt();		//recebe a peça a ser removida.
			System.out.println("Quantas peças deseja remover?");    //pergunta a quantidade a ser removida.
			quantidade = entrada.nextInt();	//recebe a quantidade a ser removida.
			pecas.remove(peca, quantidade);                         //utiliza a função do gerenciador de peças responsável por remover peças, com as váriáveis recebidas.
			if(pecas.isEmpty()) {                                   //se não houver mais peças após isso
				System.out.println("Jogador " + player + " vence!");	//o programa avisa que o jogador atual, venceu.
				entrada.nextLine();                             //ao esperar uma entrada do usuário, impede que o jogo feche instantaneamente impedindo a visualização da mensagem de fim de jogo.
				System.exit(1);						//fecha o jogo com valor 1, de bem sucedido.
			} else {                                                //se o jogo ainda possuir peças
				player = player==1?2:1;                             //o jogador é trocado
			}
		} 	//e o loop reinicia.
	}
        }
}
