public class MotCle {
	
	/**
	 *  Un tableau constant contenant tous les mots-clé valides comme commandes.
	 */
	
	private final static String commandesValides[] = {"composant","liaison"};
	
	
	public MotCle() { }


	/**
	 *  Teste si la chaine de caracteres specifiee est un mot-cle valide.
	 */
	
	public boolean estCommande(String aString) {
		for (int i = 0; i < commandesValides.length; i++) {
			if (commandesValides[i].equals(aString)) {
				return true;
			}
		}
		return false;
	}


	/**
	 *  Affiche toutes les commandes valides.
	 */
	
	public void afficherToutesLesCommandes() {
		for (int i = 0; i < commandesValides.length; i++) {
			System.out.print(commandesValides[i] + "  ");
		}
		System.out.println();
	}

}
