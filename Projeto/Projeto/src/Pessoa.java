
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
public class Pessoa implements IMovable{ // superclasse de uma pessoa em geral que implementa a interface IMovable
    //assim, obrigando a superclasse Pessoa a implementar um método chamado mover
    
    private int x, y, cor; // define as coordenadas x, y e a cor da pessoa
    private String id; // define o telefone dela
    private int safe; // define a quantidade de segundos em que a pessoa ficará segura
    public ArrayList<String> agenda = new ArrayList<>(); // cria uma agenda de contatos para cada pessoa
    
    private Random numero = new Random(); // ter um número aleatório

    public Pessoa(int x, int y, int cor, String id, ArrayList<String> agenda, int safe) { // construtor parametrizado da superclasse Pessoa
        this.x = x; // coordenada x
        this.y = y; // coordenada y
        this.cor = cor; // cor
        this.id = id; // telefone
        this.agenda = agenda; // agenda de contatos
        this.safe = safe; // tempo de segurança
    }
    
    // getters e setters de x, y, cor, id, safe e agenda
    public Random getNumero() {
        return numero;
    }

    public void setNumero(Random numero) {
        this.numero = numero;
    }

    // gets e sets
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<String> agenda) {
        this.agenda = agenda;
    }  

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
    
    public void mover() { // método para a movimentaçao da pessoa dentro da matriz do mapa
        int move = numero.nextInt(4); // variável para dar um valor aleatório de 0 a 3
        switch(move) { 
            case 0: // caso seja 0, movimento para cima no mapa
                y = y - 1;
                if(y < 1) { // caso y seja menor que 1 vai para a direita do mapa
                    y = 58;
                }
                break;
            case 1: // caso seja 1 movimento para baixo no mapa
                y = y + 1;
                if(y > 58) { // caso y seja maior que 58 vai para a esquerda do mapa
                    y = 1;
                }
                break;
            case 2: // caso seja 2 movimenta para a direita no mapa
                x = x - 1;
                if(x < 1) { // caso x seja menor que 1 vai para baixo do mapa
                    x = 28;
                }
                break;
            case 3: // caso seja 3 movimenta para a esqueda no mapa
                x = x + 1;
                if(x > 28) { // caso x seja maior que 28 vai para cima do mapa
                    x = 1;
                }
                break;
            default:
                break;
        }
    }

}
