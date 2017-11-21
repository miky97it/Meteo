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
import java.awt.Color;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

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
	private JButton btnip;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JLabel lblInformazioni;
	private JList listIP;
	private JScrollPane scrollPane;
	private JSeparator separator;
	
	public FrameStazioneMeteo() {
		setTitle("Stazione meteo");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 226, 282);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("File", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Localit\u00E0");
		lblNewLabel.setBounds(10, 66, 65, 14);
		panel.add(lblNewLabel);
		
		textFieldLocalitá = new JTextField();
		textFieldLocalitá.setBounds(102, 63, 113, 20);
		panel.add(textFieldLocalitá);
		textFieldLocalitá.setColumns(10);
		
		lblTempo = new JLabel("Tempo");
		lblTempo.setBounds(10, 96, 46, 14);
		panel.add(lblTempo);
		// versione 1.2
		comboBoxTempo = new JComboBox<>();
		comboBoxTempo.setModel(new DefaultComboBoxModel(new String[] {"soleggiato", "nubi sparse", "cielo coperto di nuvole", "pioggia", "temporale con fulmini", "neve"}));
		comboBoxTempo.setBounds(102, 93, 113, 20);
		panel.add(comboBoxTempo);
		
		vento = new JLabel("vento");
		vento.setBounds(10, 156, 82, 14);
		panel.add(vento);
		
		spinner_vento = new JSpinner();
		spinner_vento.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spinner_vento.setBounds(102, 153, 87, 20);
		panel.add(spinner_vento);
		
		btnInvia = new JButton("Invia");
		btnInvia.setBounds(10, 213, 205, 34);
		panel.add(btnInvia);
		
		labelTemperatura = new JLabel("Temperatura");
		labelTemperatura.setBounds(10, 126, 82, 14);
		panel.add(labelTemperatura);
		
		spinnerTemperatura = new JSpinner();
		spinnerTemperatura.setModel(new SpinnerNumberModel(new Float(15), new Float(-273), new Float(60), new Float(0.5)));
		spinnerTemperatura.setBounds(102, 123, 87, 20);
		panel.add(spinnerTemperatura);
		
		labelPioggia = new JLabel("pioggia");
		labelPioggia.setBounds(10, 186, 82, 14);
		panel.add(labelPioggia);
		
		spinnerpioggia = new JSpinner();
		spinnerpioggia.setBounds(102, 183, 87, 20);
		panel.add(spinnerpioggia);
		
		lblNewLabel_1 = new JLabel("\u02DAc");
		lblNewLabel_1.setBounds(189, 128, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblKmh = new JLabel("km/h");
		lblKmh.setBounds(189, 156, 46, 14);
		panel.add(lblKmh);
		
		lblLm = new JLabel("l/m\u00B2");
		lblLm.setBounds(189, 188, 46, 14);
		panel.add(lblLm);
		
		lblInserisciIDati = new JLabel("Inserisci i dati meteo");
		lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciIDati.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInserisciIDati.setBounds(10, 11, 206, 44);
		panel.add(lblInserisciIDati);
				
				panel_1 = new JPanel();
				tabbedPane.addTab("Impostazioni", null, panel_1, null);
				panel_1.setLayout(new MigLayout("", "[45px,grow 50][86px,grow]", "[grow][grow][grow][grow][grow]"));
				
				lblIndirizzoIpServer = new JLabel("IP Destinatario");
				panel_1.add(lblIndirizzoIpServer, "cell 0 0,alignx left,aligny center");
				
				ip = new JTextField();
				panel_1.add(ip, "cell 1 0,growx,aligny center");
				
						ip.setText("127.0.0.1");
						ip.setColumns(10);
						
						btnip = new JButton("Salva");
						panel_1.add(btnip, "cell 0 1 2 1,growx,aligny top");
						
						separator = new JSeparator();
						panel_1.add(separator, "cell 0 2 2 1,growx,aligny center");
						
						lblInformazioni = new JLabel("I tuoi IP sono:");
						panel_1.add(lblInformazioni, "cell 0 3 2 1,alignx center");
						
						scrollPane = new JScrollPane();
						panel_1.add(scrollPane, "cell 0 4 2 1,grow");
						
						listIP = new JList();
						scrollPane.setViewportView(listIP);
				btnip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
		

		
		this.setVisible(true);
	}

	public JList getListIP() {
		return listIP;
	}

	public void setListIP(JList listIP) {
		this.listIP = listIP;
	}

	public JButton getBtnip() {
		return btnip;
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
