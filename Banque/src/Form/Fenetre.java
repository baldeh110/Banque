package Form;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	public Fenetre() throws URISyntaxException {
		this.setTitle("Banque decisionnelle");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);

		// String[] attributes = { "checking_status", "purpose", "credit_history", "savings_status", "employment", "personal_status", "other_parties",
		// "own_telephone", "foreign_worker" };
		List<IForm> listForm = new ArrayList<IForm>();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		//File file = new File(getClass().getClassLoader().getResource("credit-g.arff").toURI());
		//PanelField panelFile = new PanelField("File", file.getAbsolutePath());
		//mainPanel.add(panelFile);

		String[] checking_status = { "<0", "0<=X<200", ">=200", "no checking" };
		listForm.add(new PanelCombobox("checking_status", checking_status));
		String[] purpose = { "new car", "used car", "furniture/equipment", "radio/tv", "domestic appliance", "repairs", "education", "vacation",
		        "retraining", "business", "other" };
		listForm.add(new PanelCombobox("purpose", purpose));

		String[] credit_history = { "no credits/all paid", "all paid", "existing paid", "delayed previously", "critical/other existing credit" };
		listForm.add(new PanelCombobox("credit_history", credit_history));

		String[] savings_status = { "<100", "100<=X<500", "500<=X<1000", ">=1000", "no known savings" };
		listForm.add(new PanelCombobox("savings_status", savings_status));

		String[] employment = { "unemployed", "<1", "1<=X<4", "4<=X<7", ">=7" };
		listForm.add(new PanelCombobox("employment", employment));

		String[] personal_status = { "male div/sep", "female div/dep/mar", "male single", "male mar/wid", "female single" };
		listForm.add(new PanelCombobox("personal_status", personal_status));

		String[] other_parties = { "none", "co applicant", "guarantor" };
		listForm.add(new PanelCombobox("other_parties", other_parties));

		String[] own_telephone = { "none", "yes" };
		listForm.add(new PanelCombobox("own_telephone", own_telephone));

		String[] foreign_worker = { "yes", "no" };
		listForm.add(new PanelCombobox("foreign_worker", foreign_worker));

		for (IForm form : listForm) {
			mainPanel.add((JPanel) form);
		}

		PanelText result = new PanelText("Result");
		//mainPanel.add(new PanelValid(listForm, result, panelFile));
		//mainPanel.add(result);
		// On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
}