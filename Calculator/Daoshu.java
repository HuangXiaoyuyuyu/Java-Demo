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

public class Daoshu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daoshu frame = new Daoshu();
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
	public Daoshu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6E29\u99A8\u63D0\u793A\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("华文隶书", Font.PLAIN, 20));
		label.setBounds(14, 13, 100, 32);
		contentPane.add(label);
		
		JLabel lblx = new JLabel("\u6B64\u65F6\u542B\u6709\u4E0D\u5408\u6CD5\u5B57\u7B26\u4E0D\u53EF\u4EE5\u7EE7\u7EED\u8FD0\u7B97\u54E6~");
		lblx.setForeground(Color.RED);
		lblx.setFont(new Font("华文隶书", Font.PLAIN, 22));
		lblx.setBounds(27, 85, 391, 67);
		contentPane.add(lblx);
		
		JButton button = new JButton("\u70B9\u51FB\u6B64\u5904\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculator calculator = new Calculator();
				calculator.setVisible(true);
			}
		});
		button.setBounds(275, 213, 131, 27);
		contentPane.add(button);
	}
}
