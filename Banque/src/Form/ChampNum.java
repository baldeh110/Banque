package Form;

import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChampNum extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();
	private JFormattedTextField textField = new JFormattedTextField();
	
	public ChampNum(String attribute) {
		label.setText(attribute);
		setLayout(new FlowLayout());
		add(label);
		add(textField);
	}

	public ChampNum(String attribute, Double value) {
		this(attribute);
		textField.setValue(value);
		textField.setColumns(15);
		
	}

	@Override
	public String getValue() {
		return textField.getText();
	}

	@Override
	public String getAttribut() {
		return label.getText();
	}

	public void setText(String treatement) {
		textField.setText(treatement);
	}
}
