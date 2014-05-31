import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FileReader {
	private MotCle commandes;
	Commande[] commandeTab = new Commande[100];

	public FileReader() {
		commandes = new MotCle();
	}

	public Commande[] lectureFichier(String s) {
		int i = 0;
		String fichier = "test.cir";
		String mot1;
		String mot2;
		String mot3;
		String mot4;
		String mot5;

		try{
			InputStream ips=new FileInputStream(s); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				
				System.out.println(ligne);
				
				StringTokenizer tokenizer = new StringTokenizer(ligne);

				if (tokenizer.hasMoreTokens()) {
					mot1 = tokenizer.nextToken();
				} else {
					mot1 = null;
				}
				
				if (tokenizer.hasMoreTokens()) {
					
					mot2 = tokenizer.nextToken();
				} else {
					mot2 = null;
				}
				
				if(tokenizer.hasMoreTokens()){
					mot3 = tokenizer.nextToken();
				}else{
					mot3 = null;
				}
				
				if(tokenizer.hasMoreTokens()){
					mot4 = tokenizer.nextToken();
				}else{
					mot4 = null;
				}
				
				if(tokenizer.hasMoreTokens()){
					mot5 = tokenizer.nextToken();
				}else{
					mot5 = null;
				}
				if (commandes.estCommande(mot1)) {
					commandeTab[i] = new Commande(mot1, mot2,mot3,mot4,mot5);
				} else {
					commandeTab[i] = new Commande(null, mot2,mot3,mot4,mot5);
				
				}
				i += 1;
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
			}
		return commandeTab;
		}

		

	/**
	 *  Affiche la liste de toutes les commandes reconnues pour le jeu.
	 */
	public void afficherToutesLesCommandes() {
		commandes.afficherToutesLesCommandes();
	}

}
