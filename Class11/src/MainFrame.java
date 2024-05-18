import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
	
	int x = 0;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setForeground(new Color(128, 128, 0));
		setBackground(new Color(255, 255, 0));
		setTitle("Title set thru code");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 363);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setTitle("" + getWidth() + " x " + getHeight());
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donovan");
		lblNewLabel.setBounds(393, 39, 76, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Click Me!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println();
			}
		});
		btnNewButton.setBounds(404, 294, 89, 23);
		contentPane.add(btnNewButton);
		
		txtTextField = new JTextField();
		txtTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				System.out.println(e.getKeyCode());
			}
			
		});
		txtTextField.setEditable(true);
		txtTextField.setText("Text Field");
		txtTextField.setBounds(10, 265, 132, 50);
		contentPane.add(txtTextField);
		txtTextField.setColumns(10);
		
		JCheckBox checkBox1 = new JCheckBox("big booty");
		checkBox1.setBounds(71, 53, 99, 23);
		contentPane.add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("fat tits");
		checkBox2.setBounds(71, 79, 99, 23);
		contentPane.add(checkBox2);
		
		JCheckBox checkBox3 = new JCheckBox("personality");
		checkBox3.setBounds(71, 105, 99, 23);
		contentPane.add(checkBox3);
		
		JButton btnNewButton_1 = new JButton("No click me!");
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("hovering");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("big booty: " + checkBox1.isSelected() + "\nfat tits: " + checkBox2.isSelected() + "\npersonality: " + checkBox3.isSelected());
			}
		});
		btnNewButton_1.setBounds(193, 176, 124, 23);
		contentPane.add(btnNewButton_1);
	}
}
