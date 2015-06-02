package Form;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PanelText extends JPanel implements IForm {

	private JLabel label = new JLabel();
	private JTextPane textField = new JTextPane();

	public PanelText(String attribute) {
		label.setText(attribute);
		setLayout(new FlowLayout());
		add(label);
		add(textField);
	}

	public PanelText(String attribute, String value) {
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
}
