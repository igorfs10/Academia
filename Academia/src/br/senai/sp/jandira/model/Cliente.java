package br.senai.sp.jandira.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private int id;
	private String nome;
	private String dtNasc;
	private double peso;
	private double altura;
	private String sexo;
	private String nivelAtividade;
	private double imc;
	private String imcDados;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
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
	public void setImc() {
		this.imc = peso / ((altura / 100) * (altura / 100));
	}
	public String getImcDados() {
		return imcDados;
	}
	public void setImcDados() {
		if (imc < 17) {
			this.imcDados =		"\nMuito abaixo do peso"
								+ "\nQueda de cabelo, infertilidade, ausência menstrual.";
		} else if (imc < 18.5) {
			this.imcDados =		"\nAbaixo do peso"
								+ "\nFadiga, stress, ansiedade.";
		} else if (imc < 25) {
			this.imcDados =		"\nPeso Normal"
								+ "\nMenor risco de doenças cardíacas e vasculares.";
		} else if (imc < 30) {
			this.imcDados =		"\nAcima do peso"
								+ "\nFadiga, má circulação, varizes.";
		} else if (imc < 35) {
			this.imcDados = 	 "\nObesidade Grau I"
								+ "\nDiabetes, angina, infarto, aterosclerose";
		} else if (imc < 40) {
			this.imcDados = 	"\nObesidade Grau II"
								+ "\nApneia do sono, falta de ar.";
		} else {
			this.imcDados = 	"\nObesidade Grau III"
								+ "\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
		}
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm() {
		long idade = getIdade();
		if(sexo.equals("M")){
			this.fcm = ((210 - (0.5 * idade)) - 0.1 * peso) + 4;
		}else{
			this.fcm = (210 - (0.5 * idade)) - 0.1 * peso;
		}
	}
	public double getTmb() {
		return tmb;
	}
	public void setTmb() {
		long idade = getIdade();
		if(sexo.equals("M")){
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		}else{
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		}
		if(nivelAtividade.equals("Sedentário")){
			this.tmb = tmb * 1.20;
		}else if(nivelAtividade.equals("Levemente ativo")){
			this.tmb = tmb * 1.37;
		}else if(nivelAtividade.equals("Moderadamente ativo")){
			this.tmb = tmb * 1.55;
		}else if(nivelAtividade.equals("Bastante ativo")){
			this.tmb = tmb * 1.72;
		}else{
			this.tmb = tmb * 1.90;
		}
	}
	
	public long getIdade(){
		long idade = 0;
		Date dataAtual = new Date();
		SimpleDateFormat paraData = new SimpleDateFormat("dd/MM/yyyy");
		
		Date clienteData = null;
		
		try {
			clienteData = paraData.parse(dtNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idade = (dataAtual.getTime() - clienteData.getTime()) / 1000 / 60 / 60 / 24 / 365;
		
		return idade;
	}
}
