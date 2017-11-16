package VIEW;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
public class FinestraMeteo extends JFrame{
	private JPanel contentPane,panel_1;
	private JLabel lblImmettiIlLuogo;
	private JTextField textField;
	private JButton btnInvia;
	private JPanel panel;
	public JLabel lblIlMeteoDi;
	public  JLabel lblTemperatura;
	public  JLabel lblIcona;
	public  JLabel lblVento;
	public  JLabel lblPioggia;
	public  JLabel lblNonHoQuesto;
	public FinestraMeteo(){
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FinestraMeteo.class.getResource("/media/1sole.png")));
		this.setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 252, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 252, 268);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblImmettiIlLuogo = new JLabel("Di dove vuoi sapere il meteo ?");
		lblImmettiIlLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmettiIlLuogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblImmettiIlLuogo.setBounds(10, 12, 232, 31);
		panel_1.add(lblImmettiIlLuogo);
		
		textField = new JTextField();
		textField.setBounds(10, 55, 113, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnInvia = new JButton("invia");
		btnInvia.setBounds(133, 54, 109, 31);
		panel_1.add(btnInvia);
		
		lblIlMeteoDi = new JLabel("il meteo di \u00E9");
		lblIlMeteoDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMeteoDi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIlMeteoDi.setBounds(10, 98, 232, 28);
		panel_1.add(lblIlMeteoDi);
		
		lblTemperatura = new JLabel("temperatura:");
		lblTemperatura.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTemperatura.setBounds(10, 138, 199, 31);
		panel_1.add(lblTemperatura);
		
		lblVento = new JLabel("vento:");
		lblVento.setHorizontalAlignment(SwingConstants.LEFT);
		lblVento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVento.setBounds(10, 181, 126, 31);
		panel_1.add(lblVento);
		
		lblPioggia = new JLabel("pioggia");
		lblPioggia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPioggia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPioggia.setBounds(10, 224, 126, 28);
		panel_1.add(lblPioggia);
		
		lblNonHoQuesto = new JLabel("Non ho questo dato");
		lblNonHoQuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonHoQuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNonHoQuesto.setBounds(10, 113, 232, 31);
		panel_1.add(lblNonHoQuesto);
		
		lblIcona = new JLabel("");
		lblIcona.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcona.setIcon(new ImageIcon(FinestraMeteo.class.getResource("/media/1sole.png")));
		lblIcona.setBounds(133, 137, 109, 106);
		panel_1.add(lblIcona);
		
		this.setVisible(true);
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setBtnInvia(JButton btnInvia) {
		this.btnInvia = btnInvia;
	}

	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnInvia() {
		return btnInvia;
	}
}