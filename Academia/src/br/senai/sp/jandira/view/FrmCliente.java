package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class FrmCliente extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JFormattedTextField txtDtNasc;
	private JComboBox<?> cbNivelAtividade;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private JTextArea txtImc;
	private JTextField txtFcm;
	private JTextField txtTmb;
	private Cliente cliente;
	private FrmCadastros frmCadastros;
	
	public void txtIdDisabled(){
		txtId.setEnabled(false);
	}
	
	public void txtNomeDisabled(){
		txtNome.setEnabled(false);
	}
	
	public void txtPesoDisabled(){
		txtPeso.setEnabled(false);
	}
	
	public void txtDtNascDisabled(){
		txtDtNasc.setEnabled(false);
	}
	
	public void cbNivelAtividadeDisabled(){
		cbNivelAtividade.setEnabled(false);
	}
	
	public void rdbtnMDisabled(){
		rdbtnM.setEnabled(false);
	}
	
	public void rdbtnFDisabled(){
		rdbtnF.setEnabled(false);
	}
	
	public void txtAlturaDisabled(){
		txtAltura.setEnabled(false);
	}
	
	public void setTxtId(String txtId) {
		this.txtId.setText(txtId);
	}

	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);
	}

	public void setTxtPeso(String txtPeso) {
		this.txtPeso.setText(txtPeso);
	}

	public void setTxtAltura(String txtAltura) {
		this.txtAltura.setText(txtAltura);
	}

	public void setTxtDtNasc(String txtDtNasc) {
		this.txtDtNasc.setText(txtDtNasc);
	}
	
	public void setCbNivelAtividade(String CbNivelAtividade){
		this.cbNivelAtividade.setSelectedItem(CbNivelAtividade);
	}
	
	public void setRdbtnM(){
		this.rdbtnM.setSelected(true);
	}
	
	public void setRdbtnF(){
		this.rdbtnF.setSelected(true);
	}
	
	public void setTxtImc(String txtImc){
		this.txtImc.setText(txtImc);
	}
	
	public void setTxtFcm(String txtFcm){
		this.txtFcm.setText(txtFcm);
	}
	
	public void setTxtTmb(String txtTmb){
		this.txtTmb.setText(txtTmb);
	}

	public FrmCliente(String operacao) {
		ButtonGroup btngSexo = new ButtonGroup();
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		setTitle("Dados do Contato");
		setBounds(100, 100, 318, 461);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(SystemColor.activeCaption);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 312, 66);
		painelPrincipal.add(painelTitulo);
		
		JLabel lblTitulo = new JLabel("Cliente");
		lblTitulo.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(10, 11, 148, 44);
		painelTitulo.add(lblTitulo);
		
		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setForeground(Color.BLUE);
		lblOperacao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOperacao.setBounds(187, 24, 93, 24);
		painelTitulo.add(lblOperacao);
		
		JPanel painelConteudo = new JPanel();
		painelConteudo.setBackground(SystemColor.activeCaption);
		painelConteudo.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		painelConteudo.setBounds(10, 64, 294, 287);
		painelPrincipal.add(painelConteudo);
		painelConteudo.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 25, 26, 14);
		painelConteudo.add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(58, 22, 46, 20);
		painelConteudo.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 58, 38, 14);
		painelConteudo.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(58, 53, 215, 20);
		painelConteudo.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 117, 38, 14);
		painelConteudo.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(58, 114, 41, 20);
		painelConteudo.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(145, 117, 46, 14);
		painelConteudo.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(187, 114, 46, 20);
		painelConteudo.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNivelAtividade = new JLabel("Nivel De Atividade:");
		lblNivelAtividade.setBounds(10, 145, 104, 14);
		painelConteudo.add(lblNivelAtividade);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 89, 144, 14);
		painelConteudo.add(lblDataDeNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(129, 25, 38, 14);
		painelConteudo.add(lblSexo);
		
		// *** Definir m�scara da data ***
		MaskFormatter dateMask = null;
		
		try {
			dateMask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtDtNasc = new JFormattedTextField(dateMask);
		txtDtNasc.setBounds(184, 86, 89, 20);
		painelConteudo.add(txtDtNasc);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 170, 46, 14);
		painelConteudo.add(lblImc);
		
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(10, 254, 46, 14);
		painelConteudo.add(lblFcm);
		
		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(145, 254, 46, 14);
		painelConteudo.add(lblTmb);
		
		cbNivelAtividade = new JComboBox();
		cbNivelAtividade.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		cbNivelAtividade.setBounds(123, 142, 150, 20);
		painelConteudo.add(cbNivelAtividade);
		
		txtImc = new JTextArea();
		txtImc.setEnabled(false);
		txtImc.setLineWrap(true);
		txtImc.setWrapStyleWord(true);
		txtImc.setEditable(false);
		txtImc.setBounds(58, 170, 215, 73);
		painelConteudo.add(txtImc);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setBackground(SystemColor.activeCaption);
		rdbtnM.setBounds(164, 21, 51, 23);
		rdbtnM.setActionCommand("M");
		painelConteudo.add(rdbtnM);
		btngSexo.add(rdbtnM);
		rdbtnM.setSelected(true);
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setBackground(SystemColor.activeCaption);
		rdbtnF.setBounds(217, 21, 46, 23);
		rdbtnF.setActionCommand("F");
		painelConteudo.add(rdbtnF);
		btngSexo.add(rdbtnF);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKg.setBounds(109, 117, 26, 14);
		painelConteudo.add(lblKg);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCm.setBounds(245, 117, 26, 14);
		painelConteudo.add(lblCm);
		
		txtFcm = new JTextField();
		txtFcm.setEnabled(false);
		txtFcm.setEditable(false);
		txtFcm.setBounds(58, 251, 77, 20);
		painelConteudo.add(txtFcm);
		txtFcm.setColumns(10);
		
		txtTmb = new JTextField();
		txtTmb.setEnabled(false);
		txtTmb.setEditable(false);
		txtTmb.setBounds(187, 251, 86, 20);
		painelConteudo.add(txtTmb);
		txtTmb.setColumns(10);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelBotoes.setBackground(SystemColor.activeCaption);
		painelBotoes.setBounds(12, 358, 290, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setDtNasc(txtDtNasc.getText());
				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setSexo(btngSexo.getSelection().getActionCommand());
				cliente.setNivelAtividade(cbNivelAtividade.getSelectedItem().toString());
				
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.setCliente(cliente);
				
				if(lblOperacao.getText().equals("NOVO")){
					calcularDados();
					clienteDao.gravar();
					dispose();
				} else if (lblOperacao.getText().equals("EDITAR")) {
					cliente.setId(Integer.parseInt(txtId.getText()));
					calcularDados();
					clienteDao.atualizar();
					dispose();
				} else if (lblOperacao.getText().equals("EXCLUIR")) {
					cliente.setId(Integer.parseInt(txtId.getText()));
					int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir "
							+ cliente.getNome()
							+ " ?" , "Aten��o", JOptionPane.YES_NO_OPTION);
					if(resposta == 0){
						clienteDao.excluir();
						dispose();
					}
				}
				frmCadastros.atualizarTabela();
			}
		});
		if (operacao.equals("EXCLUIR")) {
			btnSalvar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/excluir32.png")));
		} else {
			btnSalvar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/salvar32.png")));
		}
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(10, 11, 46, 44);
		painelBotoes.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(226, 11, 44, 44);
		painelBotoes.add(btnSair);
	}
	
	public void calcularDados(){
		
		DecimalFormat semCasa = new DecimalFormat("#");
		DecimalFormat umaCasa = new DecimalFormat("#.#");

		SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000000");
		
		Date usuarioDate = null;
		String dateBanco = null;
		
		try {
			usuarioDate = toDate.parse((txtDtNasc.getText()));
			dateBanco = toDataBase.format(usuarioDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cliente.setImc();
		cliente.setImcDados();
		setTxtImc(umaCasa.format(cliente.getImc()) + cliente.getImcDados());
		
		cliente.setTmb();
		setTxtTmb(semCasa.format(cliente.getTmb()));
		
		cliente.setFcm();
		setTxtFcm(semCasa.format(cliente.getFcm()));
		
		cliente.setDtNasc(dateBanco);
	}
	
	public void setCadastros(FrmCadastros frmCadastros){
		this.frmCadastros = frmCadastros;
		setVisible(true);
	}
}