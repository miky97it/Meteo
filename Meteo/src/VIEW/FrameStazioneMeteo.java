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

public class FrameStazioneMeteo extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldLocalitá;
	private JLabel lblTempo;
	private JComboBox<JLabel> comboBoxTempo;
	private JLabel vento;
	private JSpinner textField_vento;
	private JButton btnInvia;
	private JLabel labelTemperatura;
	private JSpinner spinnerTemperatura;
	private JLabel labelPioggia;
	private JSpinner spinner;
	private JLabel lblNewLabel_1;
	private JLabel lblKmh;
	private JLabel lblLm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 226, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Localit\u00E0");
		lblNewLabel.setBounds(10, 15, 65, 14);
		panel.add(lblNewLabel);
		
		textFieldLocalitá = new JTextField();
		textFieldLocalitá.setBounds(102, 12, 113, 20);
		panel.add(textFieldLocalitá);
		textFieldLocalitá.setColumns(10);
		
		lblTempo = new JLabel("Tempo");
		lblTempo.setBounds(10, 47, 46, 14);
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
		comboBoxTempo.setBounds(102, 44, 113, 20);
		panel.add(comboBoxTempo);
		
		vento = new JLabel("vento");
		vento.setBounds(10, 111, 82, 14);
		panel.add(vento);
		
		textField_vento = new JSpinner();
		textField_vento.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		textField_vento.setBounds(102, 108, 87, 20);
		panel.add(textField_vento);
		
		btnInvia = new JButton("Invia");
		btnInvia.setBounds(10, 168, 205, 34);
		panel.add(btnInvia);
		
		labelTemperatura = new JLabel("Temperatura");
		labelTemperatura.setBounds(10, 79, 82, 14);
		panel.add(labelTemperatura);
		
		spinnerTemperatura = new JSpinner();
		spinnerTemperatura.setModel(new SpinnerNumberModel(new Float(15), new Float(-273), new Float(60), new Float(0.5)));
		spinnerTemperatura.setBounds(102, 77, 87, 20);
		panel.add(spinnerTemperatura);
		
		labelPioggia = new JLabel("pioggia");
		labelPioggia.setBounds(10, 143, 82, 14);
		panel.add(labelPioggia);
		
		spinner = new JSpinner();
		spinner.setBounds(102, 139, 87, 20);
		panel.add(spinner);
		
		lblNewLabel_1 = new JLabel("\u02DAc");
		lblNewLabel_1.setBounds(192, 79, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblKmh = new JLabel("km/h");
		lblKmh.setBounds(192, 111, 46, 14);
		panel.add(lblKmh);
		
		lblLm = new JLabel("l/m\u00B2");
		lblLm.setBounds(192, 143, 46, 14);
		panel.add(lblLm);
		

		
		this.setVisible(true);
	}

	public JTextField getTextFieldLocalitá() {
		return textFieldLocalitá;
	}

	public JComboBox<JLabel> getComboBoxTempo() {
		return comboBoxTempo;
	}

	public JTextField getTextField_vento() {
		return textField_vento;
	}

	public JButton getBtnInvia() {
		return btnInvia;
	}

	public JSpinner getSpinnerTemperatura() {
		return spinnerTemperatura;
	}

}
