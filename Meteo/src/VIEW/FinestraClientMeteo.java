package VIEW;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
public class FinestraClientMeteo extends JFrame{
	private JPanel contentPane,panel_1;
	private JLabel lblImmettiIlLuogo;
	private JTextField textField;
	private JButton btnInvia;
	public JLabel lblIlMeteoDi;
	public  JLabel lblTemperatura;
	public  JLabel lblIcona;
	public  JLabel lblVento;
	public  JLabel lblPioggia;
	public  JLabel lblNonHoQuesto;
	private JTabbedPane tabbedPane;
	private JTextField ip;
	private JLabel lblIndirizzoIpServer;
	private JButton btnip;
	private JLabel lblInformazioni;
	private JList listIP;
	private JScrollPane scrollPane;
	private JSeparator separator;
	
	public FinestraClientMeteo(){
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FinestraClientMeteo.class.getResource("/media/1sole.png")));
		this.setTitle("Client");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(285, 0, 310, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("File", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[113px,grow][10px,grow][109px,grow]", "[31px,grow][32px,grow][28px,grow][32px,grow][31px,grow][28px,grow]"));
		
		lblImmettiIlLuogo = new JLabel("Di dove vuoi sapere il meteo ?");
		lblImmettiIlLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmettiIlLuogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblImmettiIlLuogo, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 0 1,grow");
		textField.setColumns(10);
		
		btnInvia = new JButton("invia");
		panel_1.add(btnInvia, "cell 2 1,grow");
		
		lblIlMeteoDi = new JLabel("il meteo di \u00E9");
		lblIlMeteoDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMeteoDi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblIlMeteoDi, "cell 0 2 3 1,grow");
		
		lblTemperatura = new JLabel("temperatura:");
		lblTemperatura.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblTemperatura, "cell 0 3 3 1,grow");
		
		lblVento = new JLabel("vento:");
		lblVento.setHorizontalAlignment(SwingConstants.LEFT);
		lblVento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblVento, "cell 0 4 3 1,alignx left,growy");
		
		lblPioggia = new JLabel("pioggia");
		lblPioggia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPioggia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblPioggia, "cell 0 5 3 1,alignx left,growy");
		
		lblNonHoQuesto = new JLabel("Non ho questo dato");
		lblNonHoQuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonHoQuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNonHoQuesto, "cell 0 2 3 3,growx,aligny center");
		
		lblIcona = new JLabel("");
		lblIcona.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcona.setIcon(new ImageIcon(FinestraClientMeteo.class.getResource("/media/1sole.png")));
		panel_1.add(lblIcona, "cell 2 3 1 3,grow");
		panel_1 = new JPanel();
		tabbedPane.addTab("Impostazioni", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[45px,grow 50][86px,grow]", "[grow][grow][grow][grow][grow]"));
		
		lblIndirizzoIpServer = new JLabel("IP Server");
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

		this.setVisible(true);
	}

	public JButton getBtnip() {
		return btnip;
	}

	public void setBtnip(JButton btnip) {
		this.btnip = btnip;
	}

	public JList getListIP() {
		return listIP;
	}

	public JTextField getIp() {
		return ip;
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
	public void setListIP(JList listIP) {
		this.listIP = listIP;
	}

	public JButton getBtnInvia() {
		return btnInvia;
	}
}