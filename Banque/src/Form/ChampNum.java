package Form;

import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChampNum extends JPanel implements InterfaceForm {

	private NumberFormat format;
	private JLabel label = new JLabel();
	private String attrib = "";
	private JFormattedTextField textField = new JFormattedTextField(format);
	
	public ChampNum(String lab, String attribute) {
		label.setText(lab);
		attrib = attribute;
		setLayout(new FlowLayout());
		add(label);
		add(textField);
	}

	public ChampNum(String lab, String attribute, Double value) {
		this(lab, attribute);
		textField.setValue(new Double(value));
		textField.setColumns(15);
		
	}

	@Override
	public String getValue() {
		return (String) textField.getValue();
	}

	@Override
	public String getAttribut() {
		return attrib;
	}

	public void setText(String treatement) {
		textField.setText(treatement);
	}

	@Override
	public String getTypeChamps() {
		// TODO Auto-generated method stub
		return "Double";
	}

	@Override
	public Double getValueNum() {
		// TODO Auto-generated method stub
		return ((Number)textField.getValue()).doubleValue();
	}
}
