package Form;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreFormulaire extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreFormulaire() throws URISyntaxException {
		this.setTitle("Aide à la Décision - Banque");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		List<InterfaceForm> listForm = new ArrayList<InterfaceForm>();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		ChampLibre fichierModele = new ChampLibre("Fichier Modèle :", "src/Ressources/Clients_Données.arff");
		mainPanel.add(fichierModele);
		
		Texte accroche = new Texte("Entrer les informations du Client :");
		mainPanel.add(accroche);

		String[] checking_status = { "<0", "0<=X<200", ">=200", "no checking" };
		listForm.add(new ChampChoix("Checking Status :", "checking_status", checking_status));
		
		
		listForm.add(new ChampNum("Duration :","duration", 0.0));

		String[] credit_history = { "no credits/all paid", "all paid", "existing paid", "delayed previously", "critical/other existing credit" };
		listForm.add(new ChampChoix("Credit History :", "credit_history" , credit_history));
		
		
		listForm.add(new ChampNum("Credit Amount :","credit_amount", 0.0));
		
		listForm.add(new ChampNum("Age :","age", 0.0));

		String[] savings_status = { "<100", "100<=X<500", "500<=X<1000", ">=1000", "no known savings" };
		listForm.add(new ChampChoix("Saving Status :", "savings_status", savings_status));

		String[] foreign_worker = { "yes", "no" };
		listForm.add(new ChampChoix("Foreign Worker :", "foreign_worker", foreign_worker));

		// On ajoute les éléments du formulaire
		for (InterfaceForm form : listForm) {
			mainPanel.add((JPanel) form);
		}

		Texte resultat = new Texte("");
		
		
		mainPanel.add(new FormValider(listForm, resultat, fichierModele) );
		mainPanel.add(resultat);
		
		
		// ON
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
}