
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe
 */
public class PessoaBemInformada extends Pessoa{ // subclasse para pessoas bem informadas que estende pessoa

    public PessoaBemInformada(int x, int y, String id, ArrayList<String> agenda) { // construtor parametrizado de PessoaBemInformada com as variaveis estendidas da classe Pessoa
        super(x, y, 5, id, agenda, 0); // a cor já é determinada como 5 (amarelo) e o tempo que fica segura como 0
        // o tempo já é determinado como 0, justamente pois a pessoa não está segura
    }  
    
}
