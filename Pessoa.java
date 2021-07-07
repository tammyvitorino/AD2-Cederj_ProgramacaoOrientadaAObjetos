/**
 * Matricula 16213050208
 * Polo Saquarema
 * @author Tamara_Vitorino
 */

import java.util.*;

// Classe Pessoa
public class Pessoa {
    String nome;
    int idade;
    List<Pessoa> seguindo;
    List<Pessoa> seguidores;
    
    // Construtor da Classe
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.seguindo = new ArrayList();
        this.seguidores = new ArrayList();
    }   
  
    // Armazena idade do usuário
    public void setIdade(int idade) {
        this.idade = idade;
    }  
    
    // Adiciona usuário na lista seguindo
    public void setSeguindo(Pessoa nome){
        this.seguindo.add(nome);        
    }
        
    public void setSeguidores(Pessoa nome){
        this.seguidores.add(nome);        
    }    
    
    // Métodos Gets (Nome e Idade)
    public String getNome() {
        return nome;
    }
        
    public int getIdade() {
        return idade;
    }    
    
    // Cria listas de pessoas que usuário segue e de seus seguidores
    public List<Pessoa> getSeguindo() {
        return seguindo;
    }
    
     public List<Pessoa> getSeguidores() {
        return seguidores;
    }
     
    // Método toString
    @Override
    public String toString() {
        return nome;
    }               
}