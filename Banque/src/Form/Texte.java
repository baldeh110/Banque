package Form;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Texte extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();
	private JTextPane textField = new JTextPane();

	public Texte(String attribute) {
		label.setText(attribute);
		setLayout(new FlowLayout());
		add(label);
		add(textField);
	}

	public Texte(String attribute, String value) {
		this(attribute);
		textField.setText(value);
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

	@Override
	public String getTypeChamps() {
		// TODO Auto-generated method stub
		return "String";
	}

	@Override
	public Double getValueNum() {
		// TODO Auto-generated method stub
		return null;
	}
}
