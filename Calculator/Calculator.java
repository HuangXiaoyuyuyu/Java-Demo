package Calculator;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class Calculator extends JFrame {
	 
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton btnNewButton_1;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton btnBackapace;
	private JButton btnNewButton;
	private JButton btnMc;
	private JButton btnC;
	private JButton btnCe;
	private JButton btnx;
	private JButton btnSqrt;
	private JButton btnM;
	private JButton btnMr;
	private JButton btnMs;
	private int pos = 0;
	private double num = 0;
	private double mNum = 0;
	private String temp = "";
	private String temp2 = "";
	private String string = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 550, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7F16\u8F91");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u67E5\u770B");
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(42, 13, 445, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string =string + button.getText();
				textField.setText(string);		 
			}
		});
		button.setBounds(131, 235, 60, 40);
		contentPane.add(button);
		
		button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_1.getText();
				textField.setText(string);		
			}
		});
		button_1.setBounds(205, 235, 60, 40);
		contentPane.add(button_1);
		
		button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_2.getText();
				textField.setText(string);
			}
		});
		button_2.setBounds(279, 235, 60, 40);
		contentPane.add(button_2);
		
		button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_3.getText();
				textField.setText(string);
			}
		});
		button_3.setBounds(131, 182, 60, 40);
		contentPane.add(button_3);
		
		button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_4.getText();
				textField.setText(string);
			}
		});
		button_4.setBounds(205, 182, 60, 40);
		contentPane.add(button_4);
		
		button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_5.getText();
				textField.setText(string);
			}
		});
		button_5.setBounds(279, 182, 60, 40);
		contentPane.add(button_5);
		
		button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_6.getText();
				textField.setText(string);
			}
		});
		button_6.setBounds(131, 129, 60, 40);
		contentPane.add(button_6);
		
		button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_7.getText();
				textField.setText(string);
			}
		});
		button_7.setBounds(205, 129, 60, 40);
		contentPane.add(button_7);
		
		button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_8.getText();
				textField.setText(string);
			}
		});
		button_8.setBounds(279, 129, 60, 40);
		contentPane.add(button_8);
		
		button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = string + button_9.getText();
				textField.setText(string);
			}
		});
		button_9.setBounds(131, 288, 60, 40);
		contentPane.add(button_9);
		
	    btnNewButton = new JButton(".");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (string == "") {
					string = string + "0" + btnNewButton.getText();
					textField.setText(string);
				}else {
					string =  string + btnNewButton.getText();
					textField.setText(string);
				}
			}
		});
		btnNewButton.setBounds(205, 288, 60, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos = 1;
				temp = textField.getText();
				string = string + btnNewButton_1.getText();
				textField.setText(string);
			}
		});
		btnNewButton_1.setBounds(353, 288, 60, 40);
		contentPane.add(btnNewButton_1);
		
	    button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos = 2;
				temp = textField.getText();
				string = string + button_10.getText();
				textField.setText(string);
			}
		});
		button_10.setBounds(353, 235, 60, 40);
		contentPane.add(button_10);
		
		button_11 = new JButton("*");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos = 3;
				temp = textField.getText();
				string = string + button_11.getText();
				textField.setText(string);
			}
		});
		button_11.setBounds(353, 182, 60, 40);
		contentPane.add(button_11);
		
		button_12 = new JButton("/");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos = 4;
				temp = textField.getText();
				string = string + button_12.getText();
				textField.setText(string);
			}
		});
		button_12.setBounds(353, 129, 60, 40);
		contentPane.add(button_12);
		
		button_13 = new JButton("=");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (pos) {
				case 1:temp2 = textField.getText().substring(temp.length()+1);
						   num =  Double.parseDouble(temp) + Double.parseDouble(temp2);
						   string = String.valueOf(num);
						   textField.setText(string);
					       break;
				case 2:temp2 = textField.getText().substring(temp.length()+1);
						   num =  Double.parseDouble(temp) - Double.parseDouble(temp2);
						   string = String.valueOf(num);
						   textField.setText(string);
						   break;
				case 3:temp2 = textField.getText().substring(temp.length()+1);
				 		   num =  Double.parseDouble(temp) * Double.parseDouble(temp2);
					       string = String.valueOf(num);
					       textField.setText(string);
					       break;
				case 4:temp2 = textField.getText().substring(temp.length()+1);
							if (Integer.parseInt(temp2) == 0) {
								dispose();
								NoZero noZero = new NoZero();
								noZero.setVisible(true);
							}else {
								num =  Double.parseDouble(temp) / Double.parseDouble(temp2);
					       		 string = String.valueOf(num);
					       		 textField.setText(string);
							}
			       		   break;				       
				case 5:if (temp.indexOf("+") > 0) {
									String[] strings = temp.split("[+]");
									num = Double.parseDouble(strings[0])+Double.parseDouble(strings[0])*(Double.parseDouble(strings[1]))/100;
									string = String.valueOf(num);
									textField.setText(string);
							}else if (temp.indexOf("-") > 0) {
									String[] strings = temp.split("[-]");
									num = Double.parseDouble(strings[0])-Double.parseDouble(strings[0])*(Double.parseDouble(strings[1]))/100;
									string = String.valueOf(num);
									textField.setText(string);
							}else if (temp.indexOf("*") > 0) {
									String[] strings = temp.split("[*]");
									num = Double.parseDouble(strings[0])*Double.parseDouble(strings[0])*(Double.parseDouble(strings[1]))/100;
									string = String.valueOf(num);
									textField.setText(string);
							}else if (temp.indexOf("/") > 0) {
									String[] strings = temp.split("[/]");
									num = Double.parseDouble(strings[0])/(Double.parseDouble(strings[0])*(Double.parseDouble(strings[1]))/100);
									string = String.valueOf(num);
									textField.setText(string);
							}else {
									string = 0 + "";
									textField.setText(string);
							}
							 
		 		   		   break;
				default:
						   break;
				}
			}
		});
		button_13.setBounds(427, 288, 60, 40);
		contentPane.add(button_13);
		
		btnx = new JButton("1/x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (string.indexOf("+")>0||string.indexOf("-")>0||string.indexOf("*")>0||string.indexOf("/")>0) {
					dispose();
					Daoshu daoshu = new Daoshu();
					daoshu.setVisible(true);
				}else {
					if (Double.parseDouble(string) == 0) {
						dispose();
						NoZero noZero = new NoZero();
						noZero.setVisible(true);
					}
					double d = 1 / Double.parseDouble(string);
					string = String.valueOf(d);
					textField.setText(string);
				}
			}
		});
		btnx.setBounds(427, 235, 60, 40);
		contentPane.add(btnx);
		
		btnSqrt = new JButton("sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (string.indexOf("+")>0||string.indexOf("-")>0||string.indexOf("*")>0||string.indexOf("/")>0) {
					dispose();
					Daoshu daoshu = new Daoshu();
					daoshu.setVisible(true);
				}else {
					if (Double.parseDouble(string) < 0) {
						dispose();
						Sqrt sqrt = new Sqrt();
						sqrt.setVisible(true);
					}else {
						double d1 = Math.sqrt(Double.parseDouble(string));
						string = String.valueOf(d1);
						textField.setText(string);
					}
				}
			}
		});
		btnSqrt.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
		btnSqrt.setBounds(427, 129, 60, 40);
		contentPane.add(btnSqrt);
		
		button_14 = new JButton("%");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos = 5;
				temp = textField.getText();
				string = string + button_14.getText();
				textField.setText(string);
			}
		});
		button_14.setBounds(427, 182, 60, 40);
		contentPane.add(button_14);
		
		button_15 = new JButton("+/-");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (string.indexOf("+") > 0) {
					String[] strings = string.split("[+]");
					double d = -Double.parseDouble(strings[1]);
					string = strings[0] + "+" + String.valueOf(d);
					textField.setText(string);
				} else if (string.indexOf("-") > 0) {
					String[] strings1 = string.split("[-]");
					double d = -Double.parseDouble(strings1[1]);
					string = strings1[0] + "-" + String.valueOf(d);
					textField.setText(string);
				} else if (string.indexOf("*") > 0) {
					String[] strings2 = string.split("[*]");
					double d = -Double.parseDouble(strings2[1]);
					string = strings2[0] + "*" + String.valueOf(d);
					textField.setText(string);
				} else if (string.indexOf("/") > 0) {
					String[] strings3 = string.split("[/]");
					double d = -Double.parseDouble(strings3[1]);
					string = strings3[0] + "/" + String.valueOf(d);
					textField.setText(string);
				} else {
					num = -Double.parseDouble(textField.getText());
					string = String.valueOf(num);
					textField.setText(String.valueOf(string));
				}
			}
		});
		button_15.setBounds(279, 288, 60, 40);
		contentPane.add(button_15);
		
		btnM = new JButton("M+");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (string.indexOf("+") > 0) {
					String[] strings = string.split("[+]");
					mNum = mNum + Double.parseDouble(strings[0]) + Double.parseDouble(strings[1]);
					string = "";
					textField.setText(string);
				} else if (string.indexOf("-") > 0) {
					String[] strings1 = string.split("[-]");
					mNum = mNum + Double.parseDouble(strings1[0]) - Double.parseDouble(strings1[1]);
					string = "";
					textField.setText(string);
				} else if (string.indexOf("*") > 0) {
					String[] strings2 = string.split("[*]");
					mNum = mNum + Double.parseDouble(strings2[0]) * Double.parseDouble(strings2[1]);
					string = "";
					textField.setText(string);
				} else if (string.indexOf("/") > 0) {
					String[] strings3 = string.split("[/]");
					mNum = mNum + Double.parseDouble(strings3[0]) + Double.parseDouble(strings3[1]);
					string = "";
					textField.setText(string);
				}else {
					mNum = mNum + Double.parseDouble(string);
					string = "";
					textField.setText(string);
				}
			}
		});
		btnM.setBounds(42, 288, 60, 40);
		contentPane.add(btnM);
		
		btnMs = new JButton("MS");
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mNum = mNum + Double.parseDouble(string);
				string = "";
				textField.setText(string);
			}
		});
		btnMs.setBounds(42, 235, 60, 40);
		contentPane.add(btnMs);
		
		btnMr = new JButton("MR");
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = String.valueOf(mNum);
				textField.setText(string);
			}
		});
		btnMr.setBounds(42, 182, 60, 40);
		contentPane.add(btnMr);
		
		btnMc = new JButton("MC");
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mNum = 0;
				string = "";
				textField.setText(string);
			}
		});
		btnMc.setBounds(42, 129, 60, 40);
		contentPane.add(btnMc);
		
		btnBackapace = new JButton("Backapace");
		btnBackapace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() == 0) {
					dispose();
					Backspace backspace = new Backspace();
					backspace.setVisible(true);
				}else {
					string = textField.getText().substring(0, textField.getText().length()-1);
				}
				textField.setText(string);
			}
		});
		btnBackapace.setBounds(129, 71, 110, 45);
		contentPane.add(btnBackapace);
		
		btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (string.indexOf("+") > 0) {
				String[] strings = string.split("[+]");
				string = strings[0] + "+";
				textField.setText(string);
			} else if (string.indexOf("-") > 0) {
				String[] strings1 = string.split("[-]");
				string = strings1[0] + "-";
				textField.setText(string);
			} else if (string.indexOf("*") > 0) {
				String[] strings2 = string.split("[*]");
				string = strings2[0] + "*";
				textField.setText(string);
			} else if (string.indexOf("/") > 0) {
				String[] strings3 = string.split("[/]");
				string = strings3[0] + "/";
				textField.setText(string);
			}else {
				string = "";
				textField.setText(string);
			}
			 
			}
		});
		btnCe.setBounds(253, 71, 110, 45);
		contentPane.add(btnCe);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string = "";
				textField.setText(string);
			}
		});
		btnC.setBounds(377, 71, 110, 45);
		contentPane.add(btnC);
		
	}
}
