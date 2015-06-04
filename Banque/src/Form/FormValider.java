package Form;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import Banque.Model;

public class FormValider extends JPanel implements MouseListener {

	private JButton valider = new JButton("Valider");
	private List<InterfaceForm> listForm;
	private ChampLibre panelFile;
	private Texte textPane;

	public FormValider(List<InterfaceForm> listForm, Texte textPane, ChampLibre panelFile) {
		add(valider);
		this.textPane = textPane;
		this.listForm = listForm;
		this.panelFile = panelFile;
		valider.addMouseListener(this);
	}

	// Quand on clique sur le bouton, on donne la décision
	@Override
	public void mouseClicked(MouseEvent e) {
		Model modeldetraitement = new Model();
		Map<String,String> mapAttributes = new HashMap<String,String>();
		Map<String,Double> mapAttributesNum = new HashMap<String, Double>();
		
		for (InterfaceForm panel : listForm) {
			if (panel.getTypeChamps() == "String") {
				mapAttributes.put(panel.getAttribut(), panel.getValue());
			}
			else if (panel.getTypeChamps() == "Double"){
				mapAttributesNum.put(panel.getAttribut(), panel.getValueNum());
			}
		}
		try {
			//On fait le traitement
			textPane.setText(modeldetraitement.traitement(panelFile.getValue(), mapAttributes,mapAttributesNum));
		} catch (Exception e1) {
			textPane.setText(e1.getMessage());
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
