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

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmCadastros extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;
	private DecimalFormat semCasa = new DecimalFormat("#");
	private DecimalFormat umaCasa = new DecimalFormat("#.#");

	public FrmCadastros() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCadastros.class.getResource("/br/senai/sp/jandira/imagens/agenda32.png")));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 390);
		painelPrincipal = new JPanel();
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
		painelTabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 204)));
		painelTabela.setBounds(10, 64, 414, 197);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBotoes.setBounds(10, 272, 414, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente cliente = new FrmCliente("NOVO");
				cliente.setVisible(true);
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
		
		// Cria e adiciona um scroll no painel da table
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 32, 394, 154);
		painelTabela.add(scrollTabela);
		
		tabelaClientes = new JTable();
		
		// Define o modelo da tabela
		DefaultTableModel modeloTabela = new DefaultTableModel()
		{ 
		      @Override
		      public boolean isCellEditable(int row, int col) 
		      { 
		             return false; 
		      } 
		};
		String[] nomesColunas = {"ID", "NOME"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		// Recupera os dados e poe na array para mostrar na tabela
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.getClientes();
		
		// Cria cada linha que ira compor a tabela
		Object[] linha = new Object[2];
		for(Cliente cliente : clientes){
			linha[0] = cliente.getId();
			linha[1] = cliente.getNome();
			modeloTabela.addRow(linha);
		}
		
		tabelaClientes.setModel(modeloTabela);
		
		tabelaClientes.getTableHeader().setReorderingAllowed(false);;
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(31);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
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
							
			FrmCliente frmCliente = new FrmCliente(operacao);
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
			
			frmCliente.setVisible(true);
			
		} catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Por favor selecione um cliente!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
}