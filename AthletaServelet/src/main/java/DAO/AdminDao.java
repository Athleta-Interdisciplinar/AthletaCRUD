package DAO;
import java.sql.*;

public class AdminDao {
    private PreparedStatement pstm;
    private ResultSet rset;
    private Conexao conexao = new Conexao(); //Instanciando a classe Conexao.env

//  METODO DE CADASTRO DE ADMINISTRADOR
    public int cadastrarAdm(int id_admin, String nome, String email, String senha){
        try {
            conexao.conectar();//Abrindo conexao
            pstm = conexao.getConn().prepareStatement("INSERT INTO ADMIN(ID, NOME, EMAIL, SENHA) VALUES(?, ?, ?, ?)");

            pstm.setInt(1, id_admin);
            pstm.setString(2, nome);
            pstm.setString(3, email);
            pstm.setString(4, senha);

            return pstm.executeUpdate();
        } catch (SQLException sql){
            sql.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();//Fechando conexao
        }
    }

//  METODO DE EXCLUSAO ADMINISTRADOR
    public int excluirAdm(int cod_admin){
        try {
            conexao.conectar();//Abrindo conexao
            pstm = conexao.getConn().prepareStatement("DELETE FROM ADMIN WHERE ID = ?");

            pstm.setInt(1, cod_admin);

            return cod_admin;
        } catch (SQLException sql){
            sql.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();//Fechando conexao
        }
    }

//  METODO QUE VERIFICA UMA SENHA E EMAIL NO BANCO
    public ResultSet verificarSenha(String email, String senha){
        try {
            conexao.conectar();//Abrindo conexao

            pstm = conexao.getConn().prepareStatement("SELECT CASE WHEN SENHA = ? THEN TRUE ELSE FALSE END AS SENHA FROM ADMIN WHERE EMAIL = ?");

            pstm.setString(1, senha);
            pstm.setString(2, email);

            rset = pstm.executeQuery();
            return rset;
        } catch (SQLException sql){
            sql.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();//Fechando conexao
        }
    }

//   METODO TROCAR SENHA
    public int trocarSenha(String senha, String senhaAtual, String email){
        try {
            conexao.conectar();//Abrindo conexao
            ResultSet resultSet = verificarSenha(email,senha);//Pega o resultado da consulta
            if (resultSet.next()) {
                boolean verificacao = resultSet.getBoolean("SENHA");//Transformando o resultado da consulta em um Boolean
                if (verificacao) {
                    pstm = conexao.getConn().prepareStatement("UPDATE ADMIN SET SENHA = ? WHERE EMAIL = ?");

                    pstm.setString(1, senhaAtual);
                    pstm.setString(2, email);
                }
            }else{
                return -1;
            }
            return pstm.executeUpdate();
        } catch (SQLException sql){
            sql.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();//Fechar conexao
        }
    }
//  METODO PARA TROCAR O NOME
    public int trocarNomeAdm(String nome, String email){
        try {
            conexao.conectar();//Abrindo conexao
            pstm = conexao.getConn().prepareStatement("UPDATE ADMIN SET NOME = ? WHERE EMAIL = ?");

            pstm.setString(1, nome);
            pstm.setString(2, email);

            return pstm.executeUpdate();
        } catch (SQLException sql){
            sql.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();//Fechando conexao
        }
    }
}
