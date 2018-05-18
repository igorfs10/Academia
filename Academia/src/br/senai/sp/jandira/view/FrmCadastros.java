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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class FrmCadastros extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;
	private DefaultTableModel modeloTabela;
	private DecimalFormat semCasa = new DecimalFormat("#");
	private DecimalFormat umaCasa = new DecimalFormat("#.#");
	private FrmCliente frmCliente;

	public FrmCadastros() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/gym32.png")));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 378);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(SystemColor.activeCaption);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 434, 66);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Boa Forma");
		lblTituloTela.setIcon(new ImageIcon(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/gym32.png")));
		lblTituloTela.setFont(new Font("Arial", Font.BOLD, 28));
		lblTituloTela.setBounds(10, 11, 414, 44);
		painelTitulo.add(lblTituloTela);
		
		JLabel lblData = new JLabel("New label");
		lblData.setBounds(338, 11, 86, 28);
		
		Date dataAtual = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		lblData.setText(df.format(dataAtual));
		
		painelTitulo.add(lblData);
		
		painelTabela = new JPanel();
		painelTabela.setBackground(SystemColor.activeCaption);
		painelTabela.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Clientes:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		painelTabela.setBounds(10, 74, 414, 187);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(SystemColor.activeCaption);
		painelBotoes.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelBotoes.setBounds(12, 272, 410, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCliente = new FrmCliente("NOVO");
				frmCliente.setCadastros(FrmCadastros.this);
			}
		});
		
		btnNovo.setToolTipText("Adicionar cliente");
		btnNovo.setIcon(new ImageIcon(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/novo32.png")));
		btnNovo.setBounds(10, 11, 44, 44);
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				abrirJanelaCliente("EDITAR");
				
			}
		});
		
		btnEditar.setToolTipText("Editar cliente");
		btnEditar.setIcon(new ImageIcon(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		btnEditar.setBounds(64, 11, 44, 44);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				abrirJanelaCliente("EXCLUIR");
				
			}
		});
		
		btnExcluir.setToolTipText("Excluir cliente");
		btnExcluir.setIcon(new ImageIcon(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/excluir32.png")));
		btnExcluir.setBounds(118, 11, 44, 44);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setBounds(360, 11, 44, 44);
		painelBotoes.add(btnSair);
		
		criarTabela();
	
	}
	
	public void criarTabela(){
		
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 394, 154);
		painelTabela.add(scrollTabela);
		
		tabelaClientes = new JTable();
		
		modeloTabela = new DefaultTableModel()
		{ 
		      @Override
		      public boolean isCellEditable(int row, int col) 
		      { 
		             return false; 
		      } 
		};
		String[] nomesColunas = {"ID", "NOME"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		gerarClientes();
		tabelaClientes.setModel(modeloTabela);
		
		tabelaClientes.setBackground(SystemColor.info);
		tabelaClientes.setGridColor(Color.black);
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		tabelaClientes.getColumnModel().getColumn(0).setMinWidth(95);
		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(1).setMinWidth(300);
		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		scrollTabela.setViewportView(tabelaClientes);
	}
	
	private void abrirJanelaCliente(String operacao){
		try {
			int linha;
			
			linha = tabelaClientes.getSelectedRow();
			
			int id;
			
			id = (int) tabelaClientes.getValueAt(linha, 0);
			
			ClienteDAO clienteDao = new ClienteDAO();
			Cliente cliente = clienteDao.getCliente(id);
							
			frmCliente = new FrmCliente(operacao);
			frmCliente.setCadastros(FrmCadastros.this);
			frmCliente.setTxtId(String.valueOf(cliente.getId()));
			frmCliente.setTxtNome(cliente.getNome());
			frmCliente.setTxtDtNasc(cliente.getDtNasc());
			frmCliente.setTxtPeso(semCasa.format(cliente.getPeso()));
			frmCliente.setTxtAltura(semCasa.format(cliente.getAltura()));
			
			if (cliente.getSexo().equals("M")) {
				frmCliente.setRdbtnM();
			} else {
				frmCliente.setRdbtnF();
			}
			
			frmCliente.setCbNivelAtividade(cliente.getNivelAtividade());
			
			cliente.setImc();
			cliente.setImcDados();
			frmCliente.setTxtImc(umaCasa.format(cliente.getImc()) + cliente.getImcDados());
			
			cliente.setTmb();
			frmCliente.setTxtTmb(semCasa.format(cliente.getTmb()));
			
			cliente.setFcm();
			frmCliente.setTxtFcm(semCasa.format(cliente.getFcm()));
						
			if(operacao.equals("EXCLUIR")){
				frmCliente.txtNomeDisabled();
				frmCliente.txtPesoDisabled();
				frmCliente.txtAlturaDisabled();
				frmCliente.txtDtNascDisabled();
				frmCliente.cbNivelAtividadeDisabled();
				frmCliente.rdbtnFDisabled();
				frmCliente.rdbtnMDisabled();
			}
			
		} catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Por favor selecione um cliente!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void atualizarTabela(){
		modeloTabela.setRowCount(0);
		gerarClientes();
		}	
	
	private void gerarClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.getClientes();
		
		Object[] linha = new Object[2];
		for(Cliente cliente : clientes){
			linha[0] = cliente.getId();
			linha[1] = cliente.getNome();
			modeloTabela.addRow(linha);
		}
	}
}