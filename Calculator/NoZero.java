package Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoZero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoZero frame = new NoZero();
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
	public NoZero() {
		setTitle("警告 警告！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u53CB\u60C5\u63D0\u9192\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("华文行楷", Font.PLAIN, 22));
		label.setBounds(14, 13, 110, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5F53\u8FDB\u884C\u9664\u6CD5\u6216\u6C42\u5012\u6570\u7684\u65F6\u5019\u5206\u6BCD\u4E0D\u80FD\u4E3A0\u54E6\uFF01");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 22));
		label_1.setBounds(0, 66, 432, 123);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u70B9\u51FB\u6B64\u5904\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculator calculator = new Calculator();
				calculator.setVisible(true);
			}
		});
		button.setBounds(295, 213, 123, 27);
		contentPane.add(button);
		
	}
}
