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
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import java.awt.Toolkit;

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
	private JLabel valore;
	private JSeparator separator_1;
	private JSlider slidermesmin;
	private JLabel lblMessec;
	private JLabel lblNewLabel_2;
	
	public FrameStazioneMeteo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameStazioneMeteo.class.getResource("/media/temperature-icon.png")));
		setTitle("Stazione meteo");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 310, 400);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				//tabbedPane.setBounds(5, 5, 478, 247);
				//tabbedPane.setBounds(0, 0, 226, 282);
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				
				
						//tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				contentPane.add(tabbedPane);
				panel = new JPanel();
				tabbedPane.addTab("File", null, panel, null);
				panel.setLayout(new MigLayout("", "[82px,grow][87px,grow][46px,grow 10]", "[44px,grow][20px,grow][20px,grow][20px,grow][20px,grow][20px,grow][34px,grow]"));
				
				lblNewLabel = new JLabel("Localit\u00E0");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblNewLabel, "cell 0 1,growx,aligny center");
				
				textFieldLocalitá = new JTextField();
				panel.add(textFieldLocalitá, "cell 1 1 2 1,growx,aligny center");
				textFieldLocalitá.setColumns(10);
				
				lblTempo = new JLabel("Tempo");
				lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblTempo, "cell 0 2,alignx left,aligny center");
				// versione 1.2
				comboBoxTempo = new JComboBox<>();
				comboBoxTempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				comboBoxTempo.setModel(new DefaultComboBoxModel(new String[] {"soleggiato", "nubi sparse", "cielo coperto di nuvole", "pioggia", "temporale con fulmini", "neve"}));
				panel.add(comboBoxTempo, "cell 1 2 2 1,growx,aligny center");
				
				vento = new JLabel("Vento");
				vento.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(vento, "cell 0 4,growx,aligny center");
				
				spinner_vento = new JSpinner();
				spinner_vento.setModel(new SpinnerNumberModel(0, 0, 200, 1));
				panel.add(spinner_vento, "cell 1 4,growx,aligny center");
				
				btnInvia = new JButton("Invia");
				panel.add(btnInvia, "cell 0 6 3 1,grow");
				
				labelTemperatura = new JLabel("Temperatura");
				labelTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(labelTemperatura, "cell 0 3,growx,aligny center");
				
				spinnerTemperatura = new JSpinner();
				spinnerTemperatura.setModel(new SpinnerNumberModel(new Float(15), new Float(-273), new Float(60), new Float(0.5)));
				panel.add(spinnerTemperatura, "cell 1 3,growx,aligny center");
				
				labelPioggia = new JLabel("Pioggia");
				labelPioggia.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(labelPioggia, "cell 0 5,growx,aligny center");
				
				spinnerpioggia = new JSpinner();
				panel.add(spinnerpioggia, "cell 1 5,growx,aligny center");
				
				lblNewLabel_1 = new JLabel("\u02DAc");
				panel.add(lblNewLabel_1, "cell 2 3,growx,aligny center");
				
				lblKmh = new JLabel("km/h");
				panel.add(lblKmh, "cell 2 4,growx,aligny center");
				
				lblLm = new JLabel("l/m\u00B2");
				panel.add(lblLm, "cell 2 5,growx,aligny center");
				
				lblInserisciIDati = new JLabel("Inserisci i dati meteo");
				lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
				lblInserisciIDati.setFont(new Font("Tahoma", Font.BOLD, 24));
				panel.add(lblInserisciIDati, "cell 0 0 3 1,grow");
				
				panel_1 = new JPanel();
				tabbedPane.addTab("Impostazioni", null, panel_1, null);
				panel_1.setLayout(new MigLayout("", "[45px,grow 50][86px,grow]", "[][grow][grow][grow][grow][grow][grow][grow]"));
				
				lblNewLabel_2 = new JLabel("Generazione e invio casuale (Simulazione sensori)");
				panel_1.add(lblNewLabel_2, "cell 0 0 2 1");
				
				valore = new JLabel("50");
				panel_1.add(valore, "flowx,cell 0 1,alignx left");
				
				separator_1 = new JSeparator();
				panel_1.add(separator_1, "cell 0 2 2 1,growx,aligny center");
				
				lblIndirizzoIpServer = new JLabel("IP Destinatario");
				panel_1.add(lblIndirizzoIpServer, "cell 0 3,alignx left,aligny center");
				
				ip = new JTextField();
				panel_1.add(ip, "cell 1 3,growx,aligny center");
				
				ip.setText("127.0.0.1");
				ip.setColumns(10);
				
				btnip = new JButton("Salva");
				panel_1.add(btnip, "cell 0 4 2 1,growx,aligny top");
				
				separator = new JSeparator();
				panel_1.add(separator, "cell 0 5 2 1,growx,aligny center");
				
				lblInformazioni = new JLabel("I tuoi IP sono:");
				panel_1.add(lblInformazioni, "cell 0 6 2 1,alignx center");
				
				scrollPane = new JScrollPane();
				panel_1.add(scrollPane, "cell 0 7 2 1,grow");
				
				listIP = new JList();
				scrollPane.setViewportView(listIP);
				
				slidermesmin = new JSlider();
				panel_1.add(slidermesmin, "flowx,cell 1 1,growx");
				
				lblMessec = new JLabel("messaggi/minuto");
				panel_1.add(lblMessec, "cell 0 1,growx");
				btnip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
		

		
		this.setVisible(true);
	}


	public JLabel getValore() {
		return valore;
	}


	public void setValore(JLabel valore) {
		this.valore = valore;
	}


	public JSlider getSlidermesmin() {
		return slidermesmin;
	}

	public void setSlidermesmin(JSlider slidermesmin) {
		this.slidermesmin = slidermesmin;
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
