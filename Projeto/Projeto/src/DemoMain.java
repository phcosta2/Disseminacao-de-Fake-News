
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe
 */
public class DemoMain { // main do projeto
    
    public static void main(String[] args) { // main
        
        int contbi = 0, contmi = 0, contse = 0, ptotal = 0; // variáveis para a contagem de pessoas seguras, bem e mau informadas e pessoas totais
        
        Random numero = new Random(); // número aleatório
        
        ArrayList<Pessoa> pessoa = new ArrayList<>(); // cria um arraylist para armazenar todas as pessoas do mundo
        Mundo mundo = new Mundo(); // cria um objeto da classe mundo
        Date tempo_inicial = new Date(); // inicia um tempo inicial
        
        for(int i = 0; i < 100; i++) { // for para criar todas as 100 pessoas do mundo por meio de Polimorfismo
            pessoa.add(new PessoaBemInformada(numero.nextInt(1, 29), numero.nextInt(1, 59), String.valueOf(i), new ArrayList<>())); 
            // x e y aleatório, o telefone vai ser o i do for (vai de 0 a 99) e vai criar um arraylist para a agenda de cada pessoa
        }
        
        while(true) { // o programa vai rodar em um while true, que será infinito, já que nao haverá break, a não ser que o programa seja encerrado
            mundo.desenhaMapa(); // chama o método para desenhar o mapa, com a matriz
            
            for(int i = 0; i < pessoa.size(); i++) { // for para percorrer todo o arraylist de pessoas
                pessoa.get(i).mover(); // chama o método para movimentar todas as pessoas do mundo de forma aleatória (cima, baixo, esquerda, direita)
            }
            
            mundo.colocaMapa(pessoa); // chama o método que coloca as pessoas dentro da matriz, com seus respectivos valores
            
            contbi = 0; // setar o valor como zero para a cada vez que o while true rodar, não ficar somando a quantidade de pessoas bem informadas
            contmi = 0; // setar o valor como zero para a cada vez que o while true rodar, não ficar somando a quantidade de pessoas mau informadas
            contse = 0; // setar o valor como zero para a cada vez que o while true rodar, não ficar somando a quantidade de pessoas seguras
            ptotal = 0; // setar o valor como zero para a cada vez que o while true rodas, não ficar somando a quantidade de pessoas totais
            
            for(int i = 0; i < pessoa.size(); i++) { // for para perccorer todo o arraylist de pessoas e para saber quantas pessoas sao bem informadas, mau informadas ou seguras
                if(pessoa.get(i) instanceof PessoaBemInformada) { // se a pessoa pertencer a subclasse PessoaBemInformada
                    contbi++; // aumenta o contador de pessoas bem informadas
                    ptotal++; // aumenta o contador de pessoas totais
                }
                if(pessoa.get(i) instanceof PessoaMauInformada) { // se a pessoa perterncer a subclasse PessoaMauInformada
                    contmi++; // aumenta o contadord de pessoas mau informadas
                    ptotal++; // aumenta o contador de pessoas totais
                }
                if(pessoa.get(i) instanceof PessoaSegura) { // se a pessoa pertencer a subclasse PessoaSegura
                    contse++; // aumenta o contador de pessoas seguras
                    ptotal++; // aumenta o contador de pessoas totais
                }
            }
            
            Date tempo = new Date(); // cria um novo objeto para representar o tempo
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("===================================");
            System.out.println("Tempo de simulacao: " + (tempo.getTime() - tempo_inicial.getTime()) / 1000); // calcula o tempo em que o programa está rodando
            System.out.println();
            System.out.println("\u001b[42m \033[0m IA Destruidora de Fake News"); // printa a cor da IA Destruidora de Fake News
            System.out.println("\u001b[41m \033[0m IA Geradora de Fake News"); // printa a cor da IA Geradora de Fake News
            System.out.println("\u001b[46m \033[0m IA Meio de Comunicacao Confiavel"); // printa a cor da IA Meio de Comunicação Confiável
            System.out.println();
            System.out.println("Total de pessoas: " + ptotal); // printa quantas pessoa tem no total
            System.out.println("\u001b[43m \033[0m Pessoas Bem Informadas: " + contbi); // printa quantas pessoas são bem informadas
            System.out.println("\u001b[44m \033[0m Pessoas Mau Informadas: " + contmi); // printa quantas pessoas são mau informadas
            System.out.println("\u001b[45m \033[0m Pessoas Seguras: " + contse); // printa quantas pessoa estão seguras
            System.out.println("Quantidade de Fake News Geradas: " + mundo.getQuantidadefakenews()); // printa a quantidade de fake news 
            System.out.println();
            System.out.println();
            System.out.println();
            
            mundo.desenhaMundo(); // chama o método para dar cor a cada elemento da matriz
            
            mundo.colisaoIas(pessoa); // chama o método para a colisão das IAs
            
            mundo.colisaoPessoas(pessoa); // chama o método para a colisão entre pessoas
            
            try { // try e catch para dizer que o programa irá carregar novamente a cada 1 segundo
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
    
}
