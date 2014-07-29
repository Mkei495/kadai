package kadai02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Kadai extends JFrame{
	JTextArea area;
	JTextField text;
	String str;

	public static void main(String[] args) {
		Kadai x = new Kadai("課題2");
		x.setVisible(true);
	}

	Kadai(String title){
		setTitle(title);
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();

		area = new JTextArea();
		area.setLineWrap(true);
		JScrollPane scrollpane = new JScrollPane(area);
		scrollpane.setPreferredSize(new Dimension(600, 400));

		p.add(scrollpane);

		JPanel bottomp = new JPanel();

		JButton button1 = new JButton("保存");
		button1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
					try {
						FileWriter fw = new FileWriter(new File("Test.txt"));;
						fw.write(area.getText());
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					}
				}
				);

		JButton button2 = new JButton("読込");
		button2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						try {
							area.setText("");
							BufferedReader br = new BufferedReader(new FileReader(new File("Test.txt")));
							int ch;
							while((str = br.readLine()) != null){
								if(!(str.equals(null))){
									str += "\n";
								}
								area.append(str);
							}
							br.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				);

		bottomp.add(button1);
		bottomp.add(button2);

		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(bottomp, BorderLayout.SOUTH);
	}
}
