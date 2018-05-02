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
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class FrmCliente extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JFormattedTextField txtDtNasc;
	private JComboBox cbNivelAtividade;
	
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public JFormattedTextField getTxtDtNasc() {
		return txtDtNasc;
	}

	public void setTxtDtNasc(JFormattedTextField txtDtNasc) {
		this.txtDtNasc = txtDtNasc;
	}

	public FrmCliente(String operacao) {
		ButtonGroup btngSexo = new ButtonGroup();
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		setTitle("Dados do Contato");
		setBounds(100, 100, 310, 478);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 304, 66);
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
		painelConteudo.setBorder(new TitledBorder(null, "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelConteudo.setBounds(10, 64, 291, 287);
		painelPrincipal.add(painelConteudo);
		painelConteudo.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 25, 26, 14);
		painelConteudo.add(lblId);
		
		txtId = new JTextField();
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
		lblDataDeNascimento.setBounds(10, 89, 115, 14);
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
		txtDtNasc.setBounds(129, 86, 55, 20);
		painelConteudo.add(txtDtNasc);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 170, 46, 14);
		painelConteudo.add(lblImc);
		
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(10, 237, 46, 14);
		painelConteudo.add(lblFcm);
		
		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(10, 262, 46, 14);
		painelConteudo.add(lblTmb);
		
		cbNivelAtividade = new JComboBox();
		cbNivelAtividade.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		cbNivelAtividade.setBounds(123, 142, 150, 20);
		painelConteudo.add(cbNivelAtividade);
		
		JTextArea txtValorImc = new JTextArea();
		txtValorImc.setEditable(false);
		txtValorImc.setBounds(58, 170, 215, 60);
		painelConteudo.add(txtValorImc);
		
		JLabel lblValorFcm = new JLabel("...");
		lblValorFcm.setBounds(58, 237, 46, 14);
		painelConteudo.add(lblValorFcm);
		
		JLabel lblValorTbm = new JLabel("...");
		lblValorTbm.setBounds(58, 262, 46, 14);
		painelConteudo.add(lblValorTbm);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(164, 21, 51, 23);
		rdbtnM.setActionCommand("M");
		painelConteudo.add(rdbtnM);
		btngSexo.add(rdbtnM);
		rdbtnM.setSelected(true);
		
		JRadioButton rdbtnF = new JRadioButton("F");
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
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 362, 291, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
				
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setDtNasc(dateBanco);
				cliente.setPeso(Integer.parseInt(txtPeso.getText()));
				cliente.setAltura(Integer.parseInt(txtAltura.getText()));
				cliente.setSexo(btngSexo.getSelection().getActionCommand());
				cliente.setNivelAtividade(cbNivelAtividade.getSelectedItem().toString());
				
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.setCliente(cliente);
				
				if(lblOperacao.getText().equals("NOVO")){
					clienteDao.gravar();
					limparControles();
				} else if (lblOperacao.getText().equals("EDITAR")) {
					cliente.setId(Integer.parseInt(txtId.getText()));
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
	
	private void limparControles(){
		txtNome.setText("");
		txtPeso.setText("");
		txtAltura.setText("");
		txtCelular.setText("");
		txtDtNasc.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
		
	}
}
