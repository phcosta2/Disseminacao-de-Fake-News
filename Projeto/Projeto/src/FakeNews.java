/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unifflanzara
 */
public class FakeNews { // classe para contar a quantidade de fake news
    
    private static int baseNumeroFake = 0; // variável static
    private int numeroFake; // variável para contar a quantidade de fakenews
    
    public FakeNews(){ // contrutor 
        baseNumeroFake++; // vai aumentar em 1 a cada vez que for chamada
        this.numeroFake = baseNumeroFake; // numeroFake vai ter o valor da variável acima
    } 
    
    // get
    public int getNumeroFake() {
        return numeroFake;
    }

}
