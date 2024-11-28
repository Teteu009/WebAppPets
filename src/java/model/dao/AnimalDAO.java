/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Animal;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import util.ConectaDB;
/**
 *
 * @author alunocmc
 */
public class AnimalDAO {
   //Atributos
    // Sem atributos
    
    //Métodos
    public boolean insPesq(Animal p_anim) throws ClassNotFoundException {
        //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();
                        //INSERT INTO pesquisa(dt_pesq, nome, email, q1, q2, q3, q4) VALUES ('2024-10-23', 'Ana Maria','ana@umc.br', 2, 1, 5, 3);           
                        
            String sql = "INSERT INTO pesquisa(id, nome, especie, reca,tamanho, idade, peso) VALUES ('" + p_anim.getId()+
                                                                                    "','" + p_anim.getNome()+
                                                                                    "', '" + p_anim.getEspecie() + 
                                                                                    "'," + p_anim.getRaca()+ 
                                                                                    "," + p_anim.getTamanho()+ 
                                                                                    "," + p_anim.getIdade()+ 
                                                                                  "," + p_anim.getPeso() + ")";
                           
            stmt.executeUpdate(sql); // Executa o SQL: Insert / Delete ou Update
                        
            conexao.close();
            return true;
        }catch(SQLException ex){
            System.out.println(" Exception: " + ex.toString());
            return false;
        }                 
    }  
    
    public Animal consPesqReg(Animal animal) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pesquisa where nome = '" + animal.getNome() + "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                animal.setId( Integer.parseInt(rs.getString("id")));
                animal.setNome(rs.getString("nome"));  
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setTamanho(rs.getString("tamanho"));
                animal.setIdade( Integer.parseInt(rs.getString("idade")));                
                animal.setPeso(Double.parseDouble(rs.getString("peso")));
                  
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return animal;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }   
    
    public List consPesqLista() throws ClassNotFoundException{
    //Connectar
        List lista = new ArrayList(); // Minha Lista
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pesquisa";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                Animal animal = new Animal();
                animal.setId( Integer.parseInt(rs.getString("id")));
                animal.setNome(rs.getString("nome"));  
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setTamanho(rs.getString("tamanho"));
                animal.setIdade( Integer.parseInt(rs.getString("idade")));                
                animal.setPeso(Double.parseDouble(rs.getString("peso")));
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return lista;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }   
}
