package Banque;

import java.net.URISyntaxException;

import Form.Fenetre;

public class EntryPoint {

	public static void main(String[] args) {
		Fenetre fenetre;
		try {
			fenetre = new Fenetre();
			fenetre.setVisible(true);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
