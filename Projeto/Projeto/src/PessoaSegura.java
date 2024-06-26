
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe
 */
public class PessoaSegura extends Pessoa{ // subclasse para pessoas seguras, ou seja, que passaram pelo meio de comunicação confiável
    
    public PessoaSegura(int x, int y, String id, ArrayList<String> agenda, int safe) { // construtor parametrizado de PessoaSegura com as variaveis estendidas da classe Pessoa
        super(x, y, 7, id, agenda, safe); // o tempo em que a pessoa fica segura nao é determinado direto, pois será determinado la na classe Pessoa quando for ativa
        // a cor já é determinada como 7 (rosa)
    }
    
}
