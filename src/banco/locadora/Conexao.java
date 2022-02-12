/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author sabri
 */
public class Conexao {
    private String url;
    private String usuario;
    private String senha;
    private Connection con;
    
    Conexao(){
        url = "jdbc:postgresql://localhost:5432/banco_de_dados_ufjf";
        usuario = "postgres";
        senha = "aluno123";
        
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int executeSQL(String sql){
        try{
            Statement afirmacao = con.createStatement();
            int res = afirmacao.executeUpdate(sql);
            con.close();
            return res;            
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
            
    }
}