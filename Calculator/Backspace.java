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

public class Backspace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Backspace frame = new Backspace();
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
	public Backspace() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6E29\u99A8\u63D0\u793A\uFF1A");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 22));
		lblNewLabel.setBounds(14, 30, 121, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u8BA1\u7B97\u5668\u4E2D\u5DF2\u65E0\u5185\u5BB9\uFF0C\u8BF7\u7EE7\u7EED\u8F93\u5165\uFF01");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(54, 84, 378, 63);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u70B9\u51FB\u6B64\u5904\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculator calculator = new Calculator();
				calculator.setVisible(true);
			}
		});
		btnNewButton.setBounds(282, 213, 136, 27);
		contentPane.add(btnNewButton);
	}

}
