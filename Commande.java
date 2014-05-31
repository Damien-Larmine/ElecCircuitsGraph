public class Commande {
	
	private String motCommande;
	private String mot2;
	private String mot3;
	private String mot4;
	private String mot5;

	public Commande(String motCommande, String secondMot,String trMot,String qMot,String cMot) {
		this.motCommande = motCommande;
		this.mot2 = secondMot;
		this.mot3 = trMot;
		this.mot4 = qMot;
		this.mot5 = cMot;
	}


	public String getMotCommande() {
		return motCommande;
	}


	public String getMot2() {
		return mot2;
	}

	
	public String getMot3(){
		return mot3;
	}
	
	public String getMot4() {
		return mot4;
	}

	
	public String getMot5(){
		return mot5;
	}
	
	
	public boolean estInconnue() {
		return (motCommande == null);
	}


	public boolean aMot2() {
		return (mot2 != null);
	}
	
	public boolean aMot3(){
		return(mot3 != null);
	}
	
	public boolean aMot4(){
		return(mot4 != null);
	}
	
	public boolean aMot5(){
		return(mot5 != null);
	}
	

}
