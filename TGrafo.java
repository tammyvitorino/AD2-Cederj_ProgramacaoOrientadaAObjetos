/**
 * Matricula 16213050208
 * Polo Saquarema
 * @author Tamara_Vitorino
 */

import java.util.*;

// Classe TGrafo
public class TGrafo {
    List<Pessoa> usuarios = new ArrayList();    
    
    //Insere usuário no grafo
    void insere(String nome, int idade){
        Pessoa user = new Pessoa(nome);
        user.setIdade(idade);
        this.usuarios.add(user);       
    }
    
    //Insere relação no grafo
    void segue(String verticeA, String verticeB){     
        this.usuarios.forEach((Pessoa seguidor) ->{
           if (verticeA.equals(seguidor.getNome())){               
               this.usuarios.forEach((Pessoa seguido) ->{
                   if (verticeB.equals(seguido.getNome())){
                       seguidor.setSeguindo(seguido);
                       seguido.setSeguidores(seguidor);
                   }});}
        });        
    }
    
    // Método toString retorna usuários presentes no grafo
    @Override
    public String toString() {
        return  "usuarios : " + usuarios ;
    } 
}