package Form;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelValid extends JPanel implements MouseListener {

	private JButton ok = new JButton("Ok");
	private List<IForm> listForm;
	private PanelField panelFile;
	private PanelText textPane;

	public PanelValid(List<IForm> listForm, PanelText textPane, PanelField panelFile) {
		add(ok);
		this.textPane = textPane;
		this.listForm = listForm;
		this.panelFile = panelFile;
		ok.addMouseListener(this);
	}

	// Quand on clique sur le bouton, on donne la décision
	@Override
	public void mouseClicked(MouseEvent e) {
		Read read = new Read();
		Map<String, String> mapAttributes = new HashMap<String, String>();
		for (IForm panel : listForm) {
			mapAttributes.put(panel.getAttribut(), panel.getValue());
		}
		try {
			textPane.setText(read.treatement(new File(panelFile.getValue()), mapAttributes));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
