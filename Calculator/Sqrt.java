package Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sqrt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sqrt frame = new Sqrt();
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
	public Sqrt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6E29\u99A8\u63D0\u793A\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("华文隶书", Font.PLAIN, 22));
		label.setBounds(14, 30, 110, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u88AB\u5F00\u65B9\u6570\u4E0D\u80FD\u4E3A\u8D1F\u54E6~~");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("华文隶书", Font.PLAIN, 22));
		label_1.setBounds(94, 102, 262, 49);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u70B9\u51FB\u6B64\u5904\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculator calculator = new Calculator();
				calculator.setVisible(true);
			}
		});
		button.setBounds(277, 213, 130, 27);
		contentPane.add(button);
	}

}
