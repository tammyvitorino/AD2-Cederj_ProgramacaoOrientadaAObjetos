/**
 * Matricula 16213050208
 * Polo Saquarema
 * @author Tamara_Vitorino
 */

import java.io.*;
import java.util.*;

public class Ad220182 {

    public static void main(String[] args) {
        BufferedReader in = null;
        TGrafo g = new TGrafo();
        try {
            // Faz a leitura do arquivo de entradas
            // Para a correta execução do código, o arquivo deve estar no caminho absoluto c:\\entradas.txt
            in = new BufferedReader(new FileReader("c:\\entradas.txt"));
            String s, vs[];
            // a leitura do arquivo é feita enquanto existir conteúdo nele
            while ((s = in.readLine()) != null) {
                vs = s.split(" ");
                // verifica se o segundo item na referida linha é numérico, se for, faz o armazenamento como pessoa
                if (((vs[1].charAt(0) - 48) > 0) && ((vs[1].charAt(0) - 48) < 9)) {
                    g.insere(vs[0], Integer.parseInt(vs[1]));
                // caso seja outra pessoa, chama a função PessoaA segue PessoaB
                } else {
                    g.segue(vs[0], vs[1]);
                }
            }
            in.close();
           
           /*
           // Testes Saídas Pedidas:
           // Questão 1) Quantas pessoas uma determinada pessoa segue? 
           System.out.println("De qual usuário deseja saber o número de pessoas que segue?");
           Scanner entrada1 = new Scanner(System.in);
           String pessoa1 = entrada1.nextLine();
           System.out.println(pessoa1 + " segue " + numero_seguidores(g, pessoa1)+ " pessoas. \n" );
                      
           // Questão 2) Quem são os seguidores de uma determinada pessoa? 
           System.out.println("De qual usuário deseja saber os seguidores?");
           Scanner entrada2 = new Scanner(System.in);
           String pessoa2 = entrada2.nextLine();
           System.out.println("Os seguidores de " + pessoa2 + " são:");
           seguidores(g, pessoa2);
           System.out.println();
           
           // Questão 3) Quem é a pessoa mais popular?
           System.out.println("A(s) pessoa(s) mais popular(es): \n" + mais_popular(g) + "\n");
           
           // Questão 4) Quais são as pessoas que só seguem pessoas mais velhas do que ela própria?
           System.out.println("Usuário(s) que apenas segue(m) pessoas mais velhas:");
           segue_mais_velho(g);        
           */
            
        } catch (Exception e) {
            System.out.println("Exceção");
        }
    }
    // Quantas pessoas uma determinada pessoa segue?
    // Função verifica a lista de pessoas que usuário segue e retorna a quantidade
    public static int numero_seguidores(TGrafo g, String nome) {
        int qtde = 0;
        for (Pessoa usuario : g.usuarios) {
            if (nome.equals(usuario.getNome())) {
                qtde = usuario.getSeguindo().size();
            }
        }
        return qtde;
    }
    
    // Quem são os seguidores de uma determinada pessoa?
    // Função retorna os nomes dos seguidores de determinada pessoa    
    public static void seguidores(TGrafo g, String nome){
        for (Pessoa usuario : g.usuarios) {
            if (nome.equals(usuario.getNome())) {               
                // Verifica se usuário não tem seguidores, se tiver, imprime lista
                if ((usuario.seguidores.size()) == 0){System.out.println(nome + " não tem seguidores.");}
                else{ imprime_lista(usuario.seguidores);}                
            }
        }
    }
    
    // Quem é a pessoa mais popular?
    // Função retorna usuário ou usuários com maior número de seguidores
    public static String mais_popular(TGrafo g){
        String str = null;
        int qtde = 0;
         for (Pessoa usuario : g.usuarios) {
            if ((usuario.seguidores.size()) >= qtde){
                if ((usuario.seguidores.size()) > qtde){
                    qtde = (usuario.seguidores.size());
                    str = usuario.getNome();
                }
                else{ str = str +", "+usuario.getNome();}
            }
        }
        return str;
    }
    
    // Quais são as pessoas que só seguem pessoas  mais velhas do que ela própria
    // Função retorna nomes de usuários que seguem pessoas mais velhas
    public static void segue_mais_velho(TGrafo g){
        List resultado = new ArrayList();
        g.usuarios.forEach(pessoa -> {
           int idade = pessoa.getIdade();
           boolean maisnovo = false;
            for (Pessoa follow : pessoa.seguindo) {
                int idade2 = follow.getIdade();
                if (idade >= idade2) {
                    maisnovo = false;
                    break;}
                else{ maisnovo = true; }
                }
            if (maisnovo == true){
                resultado.add(pessoa);}
            });
        imprime_lista(resultado);
    }
    
    // Função para padronizar impressão de lista
    public static void imprime_lista(List lista){
        String str = "";
        int qtde =lista.size();
        int i = 0;
        while (i < (qtde - 1)){
            str = str + lista.get(i) + ", "; i +=1;            
        }
        str = str + lista.get(i);
        System.out.println(str);
    }
}