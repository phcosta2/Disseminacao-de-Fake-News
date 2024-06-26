
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe
 */
public class PessoaMauInformada extends Pessoa{ // subclasse para pessoas mau informadas
    
    private FakeNews fakeNewsRecebida; // variável para as fakenews recebidas

    public PessoaMauInformada(int x, int y, String id, ArrayList<String> agenda, FakeNews fakeNewsRecebida) { // construtor parametrizado de PessoaMauInformada com as variaveis estendidas da classe Pessoa
        // além disso ele pega por agregação da classe FakeNews
        super(x, y, 6, id, agenda, 0); // a cor já é determinada como 6 (azul escrura) e o tempo em que a pessoa estará segura também já é determinada como 0
        // o tempo já é determinado como 0, justamente pois a pessoa não está segura
        this.fakeNewsRecebida = fakeNewsRecebida;
    }
    

    
}
