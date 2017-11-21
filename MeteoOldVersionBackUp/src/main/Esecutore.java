package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Esecutore extends JFrame {

	private JPanel contentPane;
	private JButton stazione;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Esecutore frame = new Esecutore();
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
	public Esecutore() {
		setTitle("Seleziona come procedere");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Esecutore.class.getResource("/media/5temporale.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		stazione = new JButton("Stazione");
	/*	Image img = null;
		try {
			img = ImageIO.read(new File("/media/temperature-icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERRORE] File immagine non caricato");
		}
		img=img.getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon iconaStazione= new ImageIcon(img);
		stazione.setIcon(iconaStazione);*/
		stazione.setBounds(10, 11, 120, 120);
		contentPane.add(stazione);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Esecutore.class.getResource("/media/temperature-icon.png")));
		lblNewLabel.setBounds(0, 142, 108, 108);
		contentPane.add(lblNewLabel);
	}
}
