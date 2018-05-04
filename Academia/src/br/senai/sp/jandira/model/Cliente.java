package br.senai.sp.jandira.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private int id;
	private String nome;
	private String dtNasc;
	private int peso;
	private int altura;
	private String sexo;
	private String nivelAtividade;
	private double imc;
	private double fcm;
	private double tmb;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNivelAtividade() {
		return nivelAtividade;
	}
	public void setNivelAtividade(String nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = (peso / ((altura / 100) * (altura / 100)));
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm(double fcm) {
		this.fcm = fcm;
	}
	public double getTmb() {
		return tmb;
	}
	public void setTmb() {
		long idade = 0;
		Date dataAtual = new Date();
		SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
		
		Date usuarioDate = null;
		
		try {
			usuarioDate = toDate.parse(dtNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idade = dataAtual.getTime() - usuarioDate.getTime() / 1000 / 60 / 60 / 24 / 365;
		System.out.println(idade);
		if(sexo == "M"){
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		}else{
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		}
		if(nivelAtividade=="Sedentário"){
			this.tmb = tmb * 1.20;
		}else if(nivelAtividade=="Levemente ativo"){
			this.tmb = tmb * 1.37;
		}else if(nivelAtividade=="Moderadamente ativo"){
			this.tmb = tmb * 1.55;
		}else if(nivelAtividade=="Bastante ativo"){
			this.tmb = tmb * 1.72;
		}else{
			this.tmb = tmb * 1.90;
		}
	}
}
