package Form;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChampLibre extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();
	private JTextField textField = new JTextField(30);

	public ChampLibre(String attribute) {
		label.setText(attribute);
		setLayout(new FlowLayout());
		add(label);
		add(textField);
	}

	public ChampLibre(String attribute, String value) {
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
