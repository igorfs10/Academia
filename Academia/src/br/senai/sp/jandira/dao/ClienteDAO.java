package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ClienteDAO {
	
	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;
	
	
	public void gravar () {
		
		String sql = "INSERT INTO clientes "
				+ "(nome, dtNasc, peso, altura, sexo, niveldeatividade) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setDouble(3, cliente.getPeso());
			stm.setDouble(4, cliente.getAltura());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNivelAtividade());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso",
					"Gravação",
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void atualizar(){

		String sql = "UPDATE clientes set"
				+ " nome = ?, dtnasc = ?, peso = ?, altura = ?, sexo = ?, niveldeatividade = ?"
				+ " WHERE id = ?";
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setDouble(3, cliente.getPeso());
			stm.setDouble(4, cliente.getAltura());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNivelAtividade());
			stm.setInt(7, cliente.getId());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso",
					"Atualização",
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void excluir(){
		
		String sql = "DELETE FROM clientes"
				+ " WHERE id = ?";
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, cliente.getId());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso",
					"Apagar",
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public Cliente getCliente(int id){
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		cliente = new Cliente();
		
		String sql = "SELECT * FROM clientes WHERE id = ?";
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			rs.next();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setDtNasc(df.format(rs.getDate("dtNasc")));
			cliente.setPeso(rs.getDouble("peso"));
			cliente.setAltura(rs.getDouble("altura"));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setNivelAtividade(rs.getString("niveldeatividade"));
			
			Conexao.abrirConexao().close();
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
		}
		
		return cliente;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM clientes ORDER BY nome";
		
		stm = null;
		rs = null;
		
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setDtNasc(rs.getString("dtNasc"));
				cliente.setPeso(rs.getDouble("peso"));
				cliente.setAltura(rs.getDouble("altura"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setNivelAtividade(rs.getString("niveldeatividade"));
				clientes.add(cliente);
			}
			
			Conexao.abrirConexao().close();
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return clientes;
	}
}