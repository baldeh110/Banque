package Form;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Texte extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();

	public Texte(String attribute) {
		label.setText(attribute);
		setLayout(new FlowLayout());
		add(label);
	}

	public Texte(String attribute, String value) {
		this(attribute);
		label.setText(value);
	}

	@Override
	public String getValue() {
		return label.getText();
	}

	@Override
	public String getAttribut() {
		return label.getText();
	}

	public void setText(String treatement) {
		label.setText(treatement);

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
