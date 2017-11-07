package VIEW;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class FinestraMeteo extends JFrame{
	private JPanel contentPane,panel_1,panel_2;
	private JTabbedPane tabbedPane;
	private JLabel lblImmettiIlLuogo;
	private JTextField textField;
	private JButton btnInvia;
	public FinestraMeteo(){
		this.setTitle("Richiedente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 240);
		contentPane.add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("request", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblImmettiIlLuogo = new JLabel("immetti il luogo per ottenere le informazioni");
		lblImmettiIlLuogo.setBounds(10, 11, 264, 31);
		panel_1.add(lblImmettiIlLuogo);
		
		textField = new JTextField();
		textField.setBounds(284, 16, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnInvia = new JButton("invia");
		btnInvia.setBounds(178, 147, 89, 23);
		panel_1.add(btnInvia);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("stampa", null, panel_2, null);
		panel_2.setLayout(null);
		
		this.setVisible(true);
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnInvia() {
		return btnInvia;
	}
}