package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Tela01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela01 frame = new Tela01();
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
	public Tela01() {
		int largura=400,altura=500;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, largura, altura);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Import ImageIcon     
		

		
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				menuMouseDragged(e);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menuMousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				menuMouseReleased(e);
			}
		});
	
		
		panel.setBounds(0, 0, largura, altura);
		panel.setBackground(new Color(72 ,118 ,255,100));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
//		ImageIcon iconLogo = new ImageIcon("/img/user.png");
		 ImageIcon iconLogo = new ImageIcon(getClass().getResource("/img/user128.png"));
	        		lblImagem.setIcon(iconLogo);
		lblImagem.setBounds(12, 31, 376, 141);
		
		panel.add(lblImagem);
		
		JLabel lblExit = new JLabel("");
		ImageIcon iconExit = new ImageIcon(getClass().getResource("/img/close.png"));
		lblExit.setIcon(iconExit);
		lblExit.setBounds(364, 12, 24, 31);
		panel.add(lblExit);
		
		textField = new JTextField();
		textField.setBounds(12, 246, 376, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 305, 376, 19);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 340, 376, 25);
		panel.add(btnNewButton);
		
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBackground(new Color(72 ,118 ,255,100));
	}
	int xMouse = 0, yMouse = 0; //variáveis
	private JTextField textField;
	private JPasswordField passwordField;

	private void menuMouseDragged(MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();

	        this.setLocation(x - xMouse, y - yMouse);
	    }

	    private void menuMouseReleased(MouseEvent evt) {
	        setOpacity((float) 1.0);
	    }

	    private void menuMousePressed(MouseEvent evt) {
	        setOpacity((float) 0.8);
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }
}
