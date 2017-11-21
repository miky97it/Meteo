package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameStazioneMeteo extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldLocalitá;
	private JLabel lblTempo;
	private JComboBox<JLabel> comboBoxTempo;
	private JLabel vento;
	private JSpinner spinner_vento;
	private JButton btnInvia;
	private JLabel labelTemperatura;
	private JSpinner spinnerTemperatura;
	private JLabel labelPioggia;
	private JSpinner spinnerpioggia;
	private JLabel lblNewLabel_1;
	private JLabel lblKmh;
	private JLabel lblLm;
	private JLabel lblInserisciIDati;
	private JTextField ip;
	private JLabel lblIndirizzoIpServer;
	private JSeparator separator;
	private JButton btnInvia_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStazioneMeteo frame = new FrameStazioneMeteo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameStazioneMeteo() {
		setTitle("Stazione meteo");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 226, 357);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Localit\u00E0");
		lblNewLabel.setBounds(10, 149, 65, 14);
		panel.add(lblNewLabel);
		
		textFieldLocalitá = new JTextField();
		textFieldLocalitá.setBounds(102, 146, 113, 20);
		panel.add(textFieldLocalitá);
		textFieldLocalitá.setColumns(10);
		
		lblTempo = new JLabel("Tempo");
		lblTempo.setBounds(10, 179, 46, 14);
		panel.add(lblTempo);
		/*

        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(200, 130));
        petList.setRenderer(renderer);
        petList.setMaximumRowCount(3);
		*/
		// versione 1.2
		comboBoxTempo = new JComboBox<>();
		comboBoxTempo.setModel(new DefaultComboBoxModel(new String[] {"soleggiato", "nubi sparse", "cielo coperto di nuvole", "pioggia", "temporale con fulmini", "neve"}));
		comboBoxTempo.setBounds(102, 176, 113, 20);
		panel.add(comboBoxTempo);
		
		vento = new JLabel("vento");
		vento.setBounds(10, 239, 82, 14);
		panel.add(vento);
		
		spinner_vento = new JSpinner();
		spinner_vento.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spinner_vento.setBounds(102, 236, 87, 20);
		panel.add(spinner_vento);
		
		btnInvia = new JButton("Invia");
		btnInvia.setBounds(10, 296, 205, 34);
		panel.add(btnInvia);
		
		labelTemperatura = new JLabel("Temperatura");
		labelTemperatura.setBounds(10, 209, 82, 14);
		panel.add(labelTemperatura);
		
		spinnerTemperatura = new JSpinner();
		spinnerTemperatura.setModel(new SpinnerNumberModel(new Float(15), new Float(-273), new Float(60), new Float(0.5)));
		spinnerTemperatura.setBounds(102, 206, 87, 20);
		panel.add(spinnerTemperatura);
		
		labelPioggia = new JLabel("pioggia");
		labelPioggia.setBounds(10, 269, 82, 14);
		panel.add(labelPioggia);
		
		spinnerpioggia = new JSpinner();
		spinnerpioggia.setBounds(102, 266, 87, 20);
		panel.add(spinnerpioggia);
		
		lblNewLabel_1 = new JLabel("\u02DAc");
		lblNewLabel_1.setBounds(192, 269, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblKmh = new JLabel("km/h");
		lblKmh.setBounds(192, 204, 46, 14);
		panel.add(lblKmh);
		
		lblLm = new JLabel("l/m\u00B2");
		lblLm.setBounds(192, 236, 46, 14);
		panel.add(lblLm);
		
		lblInserisciIDati = new JLabel("Inserisci i dati meteo");
		lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciIDati.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInserisciIDati.setBounds(10, 94, 206, 44);
		panel.add(lblInserisciIDati);
		
		ip = new JTextField();

		ip.setText("192.168.4.22");
		ip.setColumns(10);
		ip.setBounds(102, 8, 113, 20);
		panel.add(ip);
		
		lblIndirizzoIpServer = new JLabel("IP Server");
		lblIndirizzoIpServer.setBounds(10, 11, 82, 14);
		panel.add(lblIndirizzoIpServer);
		
		separator = new JSeparator();
		separator.setBounds(9, 81, 206, 2);
		panel.add(separator);
		
		btnInvia_1 = new JButton("Salva");
		btnInvia_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvia_1.setBounds(10, 36, 206, 34);
		panel.add(btnInvia_1);
		

		
		this.setVisible(true);
	}

	public JTextField getIp() {
		return ip;
	}

	public JSpinner getSpinner_vento() {
		return spinner_vento;
	}

	public JTextField getTextFieldLocalitá() {
		return textFieldLocalitá;
	}

	public JComboBox<JLabel> getComboBoxTempo() {
		return comboBoxTempo;
	}

	public JButton getBtnInvia() {
		return btnInvia;
	}

	public JSpinner getSpinnerTemperatura() {
		return spinnerTemperatura;
	}

	public JSpinner getSpinner() {
		return spinnerpioggia;
	}
}
