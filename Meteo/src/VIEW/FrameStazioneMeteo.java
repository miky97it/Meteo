package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrameStazioneMeteo extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblTempo;
	private JComboBox comboBox;
	private JLabel lblTemperatura;
	private JTextField textField_1;
	private JButton btnInvia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 414, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Localit\u00E0");
		lblNewLabel.setBounds(10, 24, 65, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 21, 113, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblTempo = new JLabel("Tempo");
		lblTempo.setBounds(10, 71, 46, 14);
		panel.add(lblTempo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Soleggiato", "Nuvoloso", "Piogge deboli", "Piogge forti", "Grandine", "Vento"}));
		comboBox.setBounds(117, 68, 98, 20);
		panel.add(comboBox);
		
		lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(10, 117, 82, 14);
		panel.add(lblTemperatura);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 114, 113, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btnInvia = new JButton("Invia");
		btnInvia.setBounds(126, 184, 89, 23);
		panel.add(btnInvia);
	}
}
