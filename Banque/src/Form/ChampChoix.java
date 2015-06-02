package Form;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChampChoix extends JPanel implements InterfaceForm {

	private JLabel label = new JLabel();
	private JComboBox<String> comboBox = new JComboBox<String>();

	public ChampChoix(String attribute, String[] params) {
		label.setText(attribute);
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
		return label.getText();
	}

}