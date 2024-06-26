
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe
 */
public class Mundo { // classe para montar o mundo
    
    private int[][] mapa; // cria a matriz do mundo
    
    int quantidadefakenews = 0; // variável para contar a quantidade de fakenews que é gerada

    //get
    public int getQuantidadefakenews() {
        return quantidadefakenews;
    }
    
    ArrayList<Pessoa> pessoa = new ArrayList<>(); // arraylist para a superclasse pessoa
    Random numero = new Random(); // número aleatório
    
    IAGeradoraFakeNews mau = new IAGeradoraFakeNews(); // cria um objeto de IAGeradoraFakeNews
    IADestruidoraFakeNews bem = new IADestruidoraFakeNews(); // cria um objeto de IADestruidoraFakeNews
    MeioComunicacaoConfiavel confiavel = new MeioComunicacaoConfiavel(); // cria um objeto de MeioComunicacaoConfiavel
    
    public void desenhaMapa() { // método para criar a matriz do mundo, sendo 1 a borda, 0 espaços em branco, e 2, 3 e 4 as IAs
        mapa = new int[][] {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
    }
    
    public void desenhaMundo() { // método para desenhar a matriz do mundo, dando cor para cada elemento
        for(int i = 0; i < mapa.length; i++) { // for para percorrer toda a matriz
            for(int j = 0; j < mapa[i]. length; j++) {
                switch(mapa[i][j]) {
                    case 0: // caso o elemento da matriz seja 0, terá lugares em branco
                        System.out.print(" "); // print espaço vago
                        break;
                    case 1: // caso o elemento da matriz seja 1, será a borda do mapa
                        System.out.print("\033[047m \033[0m"); // printa a borda com a cor cinza
                        break;
                    case 2: // caso o elemento da matriz seja 2, será a IA do mau
                        mau.iadoMaucor(); // chama um método da classe IAGeradoraFakeNews que printa da cor vermelha a IA do mau como vermelha
                        break;
                    case 3: // caso o elemento da matriz seja 3, será a IA do bem
                        bem.iadoBemcor(); // chama um método da classe IADestruidoraFakeNews que printa da cor verde a IA do bem como verde
                        break;
                    case 4: // caso o elemento da matriz seja 4, será a IA do Meio de comunicação confiável
                        confiavel.iaConfiavelcor(); // chama um método da classe MeioComunicacaoConfiavel que printa da cor azul marinho a IA do meio de comumicação confiável
                        break;
                    case 5: // caso o elemento da matriz seja 5, representará as pessoas bem informadas
                        System.out.print("\033[043m \033[0m"); // printa as pessoas bem informadas da cor amarela
                        break;
                    case 6: //  caso o elemento da matriz seja 6, representará as pessoas mau informadas
                        System.out.print("\033[044m \033[0m"); // printa as pessoas mau informadas da cor azul escuro
                        break;
                    case 7: // caso o elemento da matriz seja 7, representará as pessoas seguras pelo meio de comunicação confiavél 
                        System.out.print("\033[045m \033[0m"); // printa as pessoas seguras da cor rosa
                        break;
                    default:
                        break;
                }
            } System.out.println(" ");
        } 
        System.out.println("");
    }
    
    
    public void colocaMapa(ArrayList<Pessoa> pessoabem) { // método para colocar as pessoas dentro da matriz, dependendo se são seguras, mau ou bem informadas
        int xAtual, yAtual; // variáveis para as coordenadas atuais de x e y
        for(int i = 0; i < pessoabem.size(); i++) { // for para percorrer toda a lista de pessoas
            xAtual = pessoabem.get(i).getX(); // determina qual a coordenada x atual
            yAtual = pessoabem.get(i).getY(); // determina qual a coordenada y atual
            mapa[xAtual][yAtual] = pessoabem.get(i).getCor(); // vai determinar o elemento da matriz como sendo a cor da pessoa
        }
    }   
    
    public void colisaoIas(ArrayList<Pessoa> pessoa) { // vai fazer a colisao com as IAs
        int x, y; // variável para as coordenadas x e y
        int cont = 32; // variável para um contador que representará o tempo em que a pessoa ficará segura
        
        for(int i = 0; i < pessoa.size(); i++) { // for para percorrer todo o arraylist de pessoas
            x = pessoa.get(i).getX(); // determina o valor atual da coordenda x
            y = pessoa.get(i).getY(); // determina o valor atual da coordenada y
            if(x > 5 && x < 12 && y > 4 && y < 17) { // caso isso aconteça, a pessoa colidirá com a IA do bem
                if(pessoa.get(i) instanceof PessoaMauInformada) { // se a pessoa tocar na IA do bem e for MauInformada, ela virará BemInformada
                    pessoa.set(i, new PessoaBemInformada(x, y, pessoa.get(i).getId(), pessoa.get(i).getAgenda())); // é para mudar a cor de azul escuro para amarelo (ta setado na classe já)
                }
                for(int j = 0; j < pessoa.size(); j++) { // percorre de novo o arraylist de pessoas, mas agora é para analisar a lista de contatos de cada pessoa
                    // caso o telefone(Id) da pessoa esteja na agenda de quem tococu na IA do bem e a pessoa seja mau informada
                    if(pessoa.get(i).getAgenda().contains(pessoa.get(j).getId()) && (pessoa.get(j) instanceof PessoaMauInformada)) { 
                        pessoa.set(j, new PessoaBemInformada(pessoa.get(j).getX(), pessoa.get(j).getY(), pessoa.get(j).getId(), pessoa.get(j).getAgenda())); // a pessoa vira bem informada
                    }
                }
            }
            
            if(x > 5 && x < 12 && y > 42 && y < 55) { // caso isso aconteça, a pessoa colidirá com a IA do mau
                FakeNews novaFakeNews = new FakeNews(); // cria objeto da classe Fake News
                this.quantidadefakenews = novaFakeNews.getNumeroFake(); // a cada vez que alguém é denomindado mau informada, cria-se uma nova fake news
                if(pessoa.get(i) instanceof PessoaBemInformada) { // se a pessoa tocar na IA no mau e for BemInformada, ela virará MauInformada
                    pessoa.set(i, new PessoaMauInformada(x, y, pessoa.get(i).getId(), pessoa.get(i).getAgenda(), novaFakeNews)); // é para mudar a cor de amarelo pra azul escuro (te setado na classe já)
                }
                for(int j = 0; j < pessoa.size(); j++) { // percorre de novo o arraylist de pessoas, mas agora é para analisar a lista de contatos de cada pessoa
                    // caso o telefone(Id) da pessoa esteja na agenda de quem tocou na IA do mau e a pessoa seja bem informada
                    if(pessoa.get(i).getAgenda().contains(pessoa.get(j).getId()) && (pessoa.get(j) instanceof PessoaBemInformada)) { 
                        pessoa.set(j, new PessoaMauInformada(pessoa.get(j).getX(), pessoa.get(j).getY(), pessoa.get(j).getId(), pessoa.get(j).getAgenda(), novaFakeNews)); // a pessoa vira mau informada
                    }
                }
            }
            
            if(x > 17 && x < 24 && y > 23 && y < 36) { // caso isso aconteça, a pessoa colidirá com a IA segura
                pessoa.set(i, new PessoaSegura(x, y, pessoa.get(i).getId(), pessoa.get(i).getAgenda(), cont)); 
                // ao colidir com a IA, a pessoa automaticamente vira uma pessoa segura e fica com a cor rosa
            }
            
            if(pessoa.get(i).getSafe() > 1) { // enquanto o tempo de segurança da pessoa seja maior que 1 
                pessoa.get(i).setSafe(pessoa.get(i).getSafe()-1); // o tempo de segurança vai diminuindo em 1 segundo a cada segundo que passa
            }
            
            if(pessoa.get(i).getSafe() == 1) { // quando o tempo de segurança for igual a 1
                pessoa.set(i, new PessoaBemInformada(x, y, pessoa.get(i).getId(), pessoa.get(i).getAgenda())); // a pessoa deixa de ser segura e vira uma pessoa bem informada
            }
            // System.out.println("Tempo= " + pessoa.get(i).getSafe());
        }
    }
    
    
    public void colisaoPessoas(ArrayList<Pessoa> pessoabem) { // vai analisar a colisão entre as pessoas e irá adiciona-las em suas respectivas agendas
        for(int i = 0; i < pessoabem.size(); i++) { // arraylist das pessaos - pessoa i
            for(int j = i+1; j < pessoabem.size(); j++) { // arraylist de pessoas - pessoa j
                if(pessoabem.get(i).getX() == (pessoabem.get(j).getX()) && pessoabem.get(i).getY() == pessoabem.get(j).getY()) { // mesma posição
                    if(!(pessoabem.get(i).getAgenda().contains(pessoabem.get(j).getId()))){ // se o telefone(Id) ainda não estiver na agenda
                        pessoabem.get(i).getAgenda().add(pessoabem.get(j).getId()); // adiciona o telefone da pessoa j na agenda da pessoa i
                        pessoabem.get(j).getAgenda().add(pessoabem.get(i).getId()); // adiciona o telefone da pessoa i na agenda da pessoa j
                    }
                      
                }
                else if(pessoabem.get(i).getX() == (pessoabem.get(j).getX()-1) && pessoabem.get(i).getY() == pessoabem.get(j).getY()) { // pessoa i embaixo, pessoa j em cima
                    if(!(pessoabem.get(i).getAgenda().contains(pessoabem.get(j).getId()))){ // se o telefone(Id) ainda não estiver na agenda
                        pessoabem.get(i).getAgenda().add(pessoabem.get(j).getId()); // adiciona o telefone da pessoa j na agenda da pessoa i
                        pessoabem.get(j).getAgenda().add(pessoabem.get(i).getId()); // adiciona o telefone da pessoa i na agenda da pessoa j
                    }
                }
                else if(pessoabem.get(i).getX() == (pessoabem.get(j).getX()+1) && pessoabem.get(i).getY() == pessoabem.get(j).getY()) { // pessoa i em cima, pessoa j embaixo
                    if(!(pessoabem.get(i).getAgenda().contains(pessoabem.get(j).getId()))){ // se o telefone(Id) ainda não estiver na agenda
                        pessoabem.get(i).getAgenda().add(pessoabem.get(j).getId()); // adiciona o telefone da pessoa j na agenda da pessoa i
                        pessoabem.get(j).getAgenda().add(pessoabem.get(i).getId()); // adiciona o telefone da pessoa i na agenda da pessoa j
                    }
                }
                else if(pessoabem.get(i).getX() == pessoabem.get(j).getX() && pessoabem.get(i).getY() == (pessoabem.get(j).getY()-1)) { // pessoa i na direita, pessoa j na esquerda
                    if(!(pessoabem.get(i).getAgenda().contains(pessoabem.get(j).getId()))){ // se o telefone(Id) ainda não estiver na agenda
                        pessoabem.get(i).getAgenda().add(pessoabem.get(j).getId()); // adiciona o telefone da pessoa j na agenda da pessoa i
                        pessoabem.get(j).getAgenda().add(pessoabem.get(i).getId()); // adiciona o telefone da pessoa i na agenda da pessoa j
                    }
                }
                else if(pessoabem.get(i).getX() == pessoabem.get(j).getX() && pessoabem.get(i).getY() == (pessoabem.get(j).getY()+1)) { // pessoa i na esquerda, pessoa j na direita
                    if(!(pessoabem.get(i).getAgenda().contains(pessoabem.get(j).getId()))){ // se o telefone(Id) ainda não estiver na agenda
                        pessoabem.get(i).getAgenda().add(pessoabem.get(j).getId()); // adiciona o telefone da pessoa j na agenda da pessoa i
                        pessoabem.get(j).getAgenda().add(pessoabem.get(i).getId()); // adiciona o telefone da pessoa i na agenda da pessoa j
                    }
                }
            }
        }
    }
    
}
