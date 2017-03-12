package pucrs.carol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.awt.Color;

public class Banco extends JFrame {
	
	private ConcurrentLinkedQueue<Cliente> regular = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<Cliente> idoso = new ConcurrentLinkedQueue();

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField txtNomeCaixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banco frame = new Banco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void preencherPainel(Cliente c, JButton b) {
        if(c == null) {
        	txtNomeCaixa.setText("Não há clientes em espera.");
        } else {
        	txtNomeCaixa.setText(c.getNome() + " - Caixa " + b.getText());
        }
    }

	/**
	 * Create the frame.
	 */
	public Banco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Para entrar na fila, preencha os dados cadastrais:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 389, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(24, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade");
		lblNewLabel_2.setBounds(24, 72, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNome = new JTextField();
		textNome.setBounds(80, 44, 261, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(80, 69, 261, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 142, 331, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Caixas preferenciais");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 141, 241, 25);

		JButton btnCaixa1 = new JButton("1");
		btnCaixa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoPreferencial();
		        preencherPainel(c, btnCaixa1);
			}
		});
		btnCaixa1.setBounds(10, 177, 60, 41);
		contentPane.add(btnCaixa1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 300, 331, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("Aguarde a chamada pelo nome:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 313, 389, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblCaixasChamada = new JLabel("Caixas - chamada por ordem de chegada");
		lblCaixasChamada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaixasChamada.setBounds(10, 222, 288, 25);
		contentPane.add(lblCaixasChamada);
		
		JButton btnCadastrar = new JButton("Cadastrar cliente");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cliente c = new Cliente();
				c.setNome(textNome.getText());
				c.setIdade(Integer.parseInt(textIdade.getText()));
				textNome.setText("");
				textIdade.setText("");
				if(c.getIdade()>65){
					idoso.add(c);
				}
						
				regular.add(c);
			}
		});
		

		btnCadastrar.setBounds(186, 108, 145, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCaixa2 = new JButton("2");
		btnCaixa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoPreferencial();
		        preencherPainel(c, btnCaixa2);
			}
		});
		btnCaixa2.setBounds(80, 177, 60, 41);
		contentPane.add(btnCaixa2);
		
		JButton btnCaixa3 = new JButton("3");
		btnCaixa3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoPreferencial();
		        preencherPainel(c, btnCaixa3);
			}
		});
		btnCaixa3.setBounds(150, 177, 60, 41);
		contentPane.add(btnCaixa3);
		
		JButton btnCaixa4 = new JButton("4");
		btnCaixa4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoPreferencial();
		        preencherPainel(c, btnCaixa4);
			}
		});
		btnCaixa4.setBounds(221, 177, 60, 41);
		contentPane.add(btnCaixa4);
		
		JButton btnCaixa5 = new JButton("5");
		btnCaixa5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoPreferencial();
		        preencherPainel(c, btnCaixa5);
			}
		});
		btnCaixa5.setBounds(289, 177, 60, 41);
		contentPane.add(btnCaixa5);
		
		JButton btnCaixa6 = new JButton("6");
		btnCaixa6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoTempo();
		        preencherPainel(c, btnCaixa6);
			}
		});
		btnCaixa6.setBounds(10, 248, 60, 41);
		contentPane.add(btnCaixa6);
		
		JButton btnCaixa7 = new JButton("7");
		btnCaixa7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoTempo();
		        preencherPainel(c, btnCaixa7);
			}
		});
		btnCaixa7.setBounds(80, 248, 60, 41);
		contentPane.add(btnCaixa7);
		
		JButton btnCaixa8 = new JButton("8");
		btnCaixa8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoTempo();
		        preencherPainel(c, btnCaixa8);
			}
		});
		btnCaixa8.setBounds(150, 248, 60, 41);
		contentPane.add(btnCaixa8);
		
		JButton btnCaixa9 = new JButton("9");
		btnCaixa9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoTempo();
		        preencherPainel(c, btnCaixa9);
			}
		});
		btnCaixa9.setBounds(221, 248, 60, 41);
		contentPane.add(btnCaixa9);
		
		JButton btnCaixa10 = new JButton("10");
		btnCaixa10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = getProximoClienteConsiderandoTempo();
		        preencherPainel(c, btnCaixa10);
			}
		});
		btnCaixa10.setBounds(289, 248, 60, 41);
		contentPane.add(btnCaixa10);
		
		txtNomeCaixa = new JTextField();
		txtNomeCaixa.setForeground(Color.BLUE);
		txtNomeCaixa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtNomeCaixa.setText("Nome - Caixa");
		txtNomeCaixa.setBounds(10, 349, 331, 20);
		contentPane.add(txtNomeCaixa);
		txtNomeCaixa.setColumns(10);
		
		JLabel lblCaixasPreferenciais = new JLabel("Caixas Preferenciais");
		lblCaixasPreferenciais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaixasPreferenciais.setBounds(10, 152, 288, 25);
		contentPane.add(lblCaixasPreferenciais);
	}
	
	private Cliente getProximoClienteConsiderandoPreferencial(){
        Cliente c;
        if(idoso.isEmpty()) {
            c = regular.poll();
        } else {
            c = idoso.poll();
            regular.remove(c);
        }
        return c;
    }
    
    private Cliente getProximoClienteConsiderandoTempo(){
        Cliente c;
        c = regular.poll();
        idoso.remove(c);
        return c;
    }
}
