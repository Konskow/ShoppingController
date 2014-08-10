package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextArea;

public class ShowPanel extends JPanel {
	
	/**
	 * generated serial version
	 */
	private static final long serialVersionUID = 7313347441844463362L;
	
	/**
	 * textArea with list of items
	 */
	private JTextArea textArea;
	
	/**
	 * ShowPanel constructor
	 */
	public ShowPanel() {
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		textArea = new JTextArea();
		add(textArea, "cell 0 0,grow");
	}

	public void readFromFile(String string) {
		BufferedReader bufferedReader = null;	
		try {
			bufferedReader = new BufferedReader(new FileReader(string));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				sb.append(line);
				sb.append("\n");
			}
			textArea.setText(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
