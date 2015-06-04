package Banque;

import java.net.URISyntaxException;

import Form.FenetreFormulaire;

public class Lancement {

	public static void main(String[] args) {
		FenetreFormulaire fenetre;
		try {
			fenetre = new FenetreFormulaire();
			fenetre.setVisible(true);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
