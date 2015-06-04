package Form;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChampChoix extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();
	private String attrib = "";
	private JComboBox<String> comboBox = new JComboBox<String>();

	public ChampChoix(String lab, String attribute, String[] params) {
		label.setText(lab);
		attrib = attribute;
		comboBox = new JComboBox<String>(params);
		setLayout(new FlowLayout());
		add(label);
		add(comboBox);
	}

	@Override
	public String getValue() {
		return comboBox.getSelectedItem().toString();
	}

	@Override
	public String getAttribut() {
		return attrib;
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
