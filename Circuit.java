import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

	public class Circuit  extends JFrame implements Runnable{

		private static CompIN ins[] = new CompIN[5];
		private static CompOUT outs[] = new CompOUT[5];
		
		private static CompOR compOrs[] = new CompOR[50];
		private static CompAND compAnds[]= new CompAND[50];
		private static CompNO compNos[]= new CompNO[50];
		private static CompXOR compXors[]= new CompXOR[50];
		
		private static CompLink compLink[] = new CompLink[350];
		
		private static FileReader fileReader;
		
		private static Commande[] commande = new Commande[50];
		
		/* Le menu */ 
		
		 private JMenuBar menuBar = new JMenuBar();
		    JMenu   fichier = new JMenu("Fichier"),
		            aide = new JMenu("Aide"),
		    		composants = new JMenu("Composants") ;
		    
		    JMenuItem nouveau = new JMenuItem("Nouveau"),
	                quitter = new JMenuItem("Quitter"),
	                charger = new JMenuItem("Charger"),
	                sauvegarder = new JMenuItem("Sauvegarder"),
	                lancer = new JMenuItem("Lancer"),
	                and = new JMenuItem("AND"),
	                or = new JMenuItem("OR"),
	                xor = new JMenuItem("XOR"),
	                no = new JMenuItem("NO"),
	                aideItem = new JMenuItem("Aide");
		    
		    /* Les ÃƒÂ©couteurs */ 
		    
		    //private Stoplistener sListener = new StopListener(); 
		    
		    /* La Toolbar */

		    JToolBar toolBar = new JToolBar(1); 
		    
		    JButton orB = new JButton(new ImageIcon("image/ou1.png")),
		            andB = new JButton(new ImageIcon("image/et1.png")),
		            xorB = new JButton(new ImageIcon("image/xor1.png")),
		            noB = new JButton(new ImageIcon("image/no1.png")),
		    	    liaisonB = new JButton(new ImageIcon("image/"));

		    //Zone de Dessin des composants
		    private DrawPanel drawPanel = new DrawPanel();
		
	public Circuit(){
		this.setSize(1000, 1000);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	    /*On initialise le menu*/
	    this.initMenu();
	        
	    /*On initialise la Toolbar*/
	    this.initToolbar();
	        
	    this.getContentPane().add(drawPanel,BorderLayout.CENTER);
	    this.setVisible(true);
	}
		    
	public static void main(String args[]){
		
		creerCircuit(args[0]);
		
		int compteurAff = 0;
		
		for(int i = 0; i<5; i++){
			compteurAff += 1;
			if(ins[i] == null){
				break;
			}
		}
			switch(compteurAff){
			case 2: afficherCircuit2(args[0]);
				break;
			case 3: afficherCircuit3(args[0]);
				break;
			case 4: afficherCircuit4(args[0]);
				break;
			case 5: afficherCircuit5(args[0]);
				break;
			
			}
			
		Circuit cir = new Circuit();
			
		}
	
	public static void creerCircuit(String s){
		fileReader = new FileReader();
		commande = fileReader.lectureFichier(s);
		
		for(int i = 0;i<50;i++){
			if(commande[i] != null){
				traiterCommande(commande[i]);
			}
		}
	}

	public static void afficherCircuit2(String nom){
		
		File f = new File (nom+".tdv");
		
		try
		{
		    FileWriter fw = new FileWriter (f);
		 
		    fw.write (" Entrees  | Sortie  ");
		    fw.write ("----------|--------");
		 
		    for(int in1 = 0; in1 < 2; in1++){	

		   	    if(in1 == 0){ins[0].setInA(false);}
		   	    if(in1 == 1){ins[0].setInA(true);}
			
		   	    for(int in2 = 0; in2 < 2; in2++){

			        if(in2 == 0){ins[1].setInA(false);}
		   		    if(in2 == 1){ins[1].setInA(true);}

				    for(int i=0; i<50; i++){
			  	      if(compLink[i] != null){
			   	      effectuerLiaison(compLink[i]);
		              }
				    }
				    
				    int aff1 = ins[0].getOut() == true ? 1 : 0;
		       	    int aff2 = ins[1].getOut() == true ? 1 : 0;
		       	    int affout = outs[0].getOut() == true ? 1 : 0;

		       		fw.write("  "+aff1+" |  "+aff2+"  |   "+affout+"  ");

			    }

			}    
		        
		    fw.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		
	
}
	
	public static void afficherCircuit3(String nom){
		
		File f = new File (nom+".tdv");
		
		try
		{
		    FileWriter fw = new FileWriter (f);
		 
		    fw.write ("    Entrees    |   Sortie  ");
		    fw.write ("---------------|----------");
		 
		    for(int in1 = 0; in1 < 2; in1++){	

		    	if(in1 == 0){ins[0].setInA(false);}
		   	    if(in1 == 1){ins[0].setInA(true);}
		   	    	
		   	    for(int in2 = 0; in2 < 2; in2++){
		   	    	
		   	    	if(in2 == 0){ins[1].setInA(false);}
		   		    if(in2 == 1){ins[1].setInA(true);}

		   		 for(int in3 = 0; in3 < 2; in3++){

				        if(in3 == 0){ins[2].setInA(false);}
			   		    if(in3 == 1){ins[2].setInA(true);}
		   		    
			   		    for(int i=0; i<50; i++){
			   		    	if(compLink[i] != null){
			   		    		effectuerLiaison(compLink[i]);
			   		    	}
			   		    }
				    
				    int aff1 = ins[0].getOut() == true ? 1 : 0;
		       	    int aff2 = ins[1].getOut() == true ? 1 : 0;
		       	    int aff3 = ins[2].getOut() == true ? 1 : 0;
		       	    int affout = outs[0].getOut() == true ? 1 : 0;

		       		fw.write("  "+aff1+" |  "+aff2+"  |  "+aff3+"  |   "+affout+"  ");

		   		 }
		   	    }

			}    
		        
		    fw.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		
	
}
	
	
	public static void afficherCircuit4(String nom){
		
		File f = new File (nom+".tdv");
		
		try
		{
		    FileWriter fw = new FileWriter (f);
		 
		    fw.write ("     Entrees     |   Sortie  ");
		    fw.write ("-----------------|----------");
		 
		    for(int in1 = 0; in1 < 2; in1++){	

		    	if(in1 == 0){ins[0].setInA(false);}
		   	    if(in1 == 1){ins[0].setInA(true);}
		   	    	
		   	    for(int in2 = 0; in2 < 2; in2++){
		   	    	
		   	    	if(in2 == 0){ins[1].setInA(false);}
		   		    if(in2 == 1){ins[1].setInA(true);}

		   		 for(int in3 = 0; in3 < 2; in3++){

				        if(in3 == 0){ins[2].setInA(false);}
			   		    if(in3 == 1){ins[2].setInA(true);}
			   		    
			   		 for(int in4 = 0; in4 < 2; in4++){

					        if(in4 == 0){ins[3].setInA(false);}
				   		    if(in4 == 1){ins[3].setInA(true);}
		   		    
				   		    for(int i=0; i<50; i++){
				   		    	if(compLink[i] != null){
				   		    		effectuerLiaison(compLink[i]);
				   		    	}
				   		    }
				    
				   		    int aff1 = ins[0].getOut() == true ? 1 : 0;
				   		    int aff2 = ins[1].getOut() == true ? 1 : 0;
				   		    int aff3 = ins[2].getOut() == true ? 1 : 0;
				   		    int aff4 = ins[3].getOut() == true ? 1 : 0;
				   		    int affout = outs[0].getOut() == true ? 1 : 0;

				   		    fw.write("  "+aff1+" |  "+aff2+"  |  "+aff3+"  |  "+aff4+"  |   "+affout+"  ");
			   		 }
		   		 }
		   	    }
		   	    
		    }    
		        
		    fw.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		
	
}
	
	
	public static void afficherCircuit5(String nom){
		
		File f = new File (nom+".tdv");
		
		try
		{
		    FileWriter fw = new FileWriter (f);
		 
		    fw.write ("       Entrees       |   Sortie  ");
		    fw.write ("---------------------|----------");
		 
		    for(int in1 = 0; in1 < 2; in1++){	

		    	if(in1 == 0){ins[0].setInA(false);}
		   	    if(in1 == 1){ins[0].setInA(true);}
		   	    	
		   	    for(int in2 = 0; in2 < 2; in2++){
		   	    	
		   	    	if(in2 == 0){ins[1].setInA(false);}
		   		    if(in2 == 1){ins[1].setInA(true);}

		   		 for(int in3 = 0; in3 < 2; in3++){

				        if(in3 == 0){ins[2].setInA(false);}
			   		    if(in3 == 1){ins[2].setInA(true);}
			   		    
			   		 for(int in4 = 0; in4 < 2; in4++){

					        if(in4 == 0){ins[3].setInA(false);}
				   		    if(in4 == 1){ins[3].setInA(true);}
				   		    
				   		    for(int in5 = 0; in5 < 2; in5++){

				   		    	if(in5 == 0){ins[4].setInA(false);}
					   		    if(in5 == 1){ins[4].setInA(true);}
					   		    
					   		    for(int i=0; i<50; i++){
					   		    	if(compLink[i] != null){
					   		    		effectuerLiaison(compLink[i]);
					   		    	}
					   		    }
				    
					   		    int aff1 = ins[0].getOut() == true ? 1 : 0;
					   		    int aff2 = ins[1].getOut() == true ? 1 : 0;
					   		    int aff3 = ins[2].getOut() == true ? 1 : 0;
					   		    int aff4 = ins[3].getOut() == true ? 1 : 0;
					   		    int aff5 = ins[4].getOut() == true ? 1 : 0;
					   		    int affout = outs[0].getOut() == true ? 1 : 0;

				   		    fw.write("  "+aff1+" |  "+aff2+"  |  "+aff3+"  |  "+aff4+"  |  "+aff5+"  |  "+affout+"  ");
				   		    }
				   		    
			   		 }
		   		 }
		   	    }
		   	    
		    }    
		        
			    fw.close();
			}
		catch (IOException exception)
		{
			    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
		
		
}
	
	public static void traiterCommande(Commande c){

		String motCommande = c.getMotCommande();
		if (motCommande.equals("composant")) {
			creerComposant(c);
		}
		else if (motCommande.equals("liaison")){
			creerLiaison(c);
		}
		else{
			
		}
	}
	
	public static void creerComposant(Commande c){
		String nomComposant = c.getMot2();
		String typeComposant = c.getMot3();
		if(typeComposant.equals("IN")){
			for(int i = 0; i < 10; i++){
				if(ins[i] == null){
					ins[i] = new CompIN(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("OUT")){
			for(int i = 0; i < 10; i++){
				if(outs[i] == null){
					outs[i] = new CompOUT(nomComposant);
					return;
				}
			};
		}
		else if (typeComposant.equals("OR")){
			for(int i = 0; i < 50; i++){
				if(compOrs[i] == null){
					compOrs[i] = new CompOR(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("AND")){
			for(int i = 0; i < 50; i++){
				if(compAnds[i] == null){
					compAnds[i] = new CompAND(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("XOR")){
			for(int i = 0; i < 50; i++){
				if(compXors[i] == null){
					compXors[i] = new CompXOR(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("NO")){
			for(int i = 0; i < 50; i++){
				if(compNos[i] == null){
					compNos[i] = new CompNO(nomComposant);
					return;
				}
			}
		}
	}
	
private static void creerLiaison(Commande c) {
		String composant1 = c.getMot2();
		String entreeComp1 = c.getMot3();
		String composant2 = c.getMot4();
		String entreeComp2 = c.getMot5();
		
		for(int i=0;i<50;i++){
		  if(compLink[i] == null){
		     compLink[i] = new CompLink("link"+i,composant1,Integer.parseInt(entreeComp1),composant2,Integer.parseInt(entreeComp2));
		     return;
		  }
		}
	}

private static CompIN rechercherIN(String s) {
		for(int i = 0; i<10; i+=1){
			if(ins[i].getName().equals(s)){
				return ins[i];
			}
		}
		return null;
	}
	

private static CompXOR rechercherXOR(String s) {
		for(int i = 0; i<50; i+=1){
			if(compXors[i].getName().equals(s)){
				return compXors[i];
			}
		}
		return null;
	}
	
private static CompAND rechercherAND(String s) {
		for(int i = 0; i<50; i+=1){
			if(compAnds[i].getName().equals(s)){
				return compAnds[i];
			}
		}
		return null;
	}
	
private static CompOR rechercherOR(String s) {
		for(int i = 0; i<50; i+=1){
			if(compOrs[i].getName().equals(s)){
				return compOrs[i];
			}
		}
		return null;
	}
	
private static CompNO rechercherNO(String s) {
		for(int i = 0; i<50; i+=1){
			if(compNos[i].getName().equals(s)){
				return compNos[i];
			}
		}
		return null;
	}

private static CompOUT rechercherOUT(String s) {
		for(int i = 0; i<10; i+=1){
			if(outs[i].getName().equals(s)){
				return outs[i];
			}
		}
		return null;
	}

private static void effectuerLiaison(CompLink liaison){

     String entree = liaison.getComp1();
     switch(entree.charAt(0)){
       case 'i':
	CompIN tempIN = rechercherIN(entree);
	if(tempIN != null){
	  linkIN(tempIN,liaison);
	}
	break;
      case 'a':
	CompAND tempAND = rechercherAND(entree);
	if(tempAND != null){
	  linkAND(tempAND,liaison);
	}
	break;
      case 'n':
	CompNO tempNO = rechercherNO(entree);
	if(tempNO != null){
	  linkNO(tempNO,liaison);
	}
	break;
      case 'x':
	CompXOR tempXOR = rechercherXOR(entree);
	if(tempXOR != null){
	  linkXOR(tempXOR,liaison);
	}
	break;
     case 'o':
	CompOR tempOR = rechercherOR(entree);
	if(tempOR != null){
	  linkOR(tempOR,liaison);
	}
	break;
}

}

private static void linkIN(CompIN in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}
  	break;
  }

}

private static void linkOR(CompOR in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkAND(CompAND in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkXOR(CompXOR in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkNO(CompNO in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
}

private void initMenu() {
	
    fichier.add(nouveau);
    fichier.addSeparator();
    fichier.add(sauvegarder);
    fichier.add(charger);
    fichier.addSeparator();
    fichier.add(lancer);
    fichier.addSeparator();
    fichier.add(quitter);
    
    composants.add(and);
    composants.add(or);
    composants.add(no);
    composants.add(xor);
    
    aide.add(aideItem);
    
    menuBar.add(fichier);
    menuBar.add(composants);
    menuBar.add(aide);
    
    this.setJMenuBar(menuBar);
	
}

private void initToolbar() {
toolBar.add(orB);
toolBar.add(andB);
toolBar.add(xorB);
toolBar.add(noB);
toolBar.addSeparator();
toolBar.add(liaisonB);
	
this.getContentPane().add(toolBar, BorderLayout.WEST);
	
}

@Override
public void run() {
	// TODO Auto-generated method stub
	
}


	
}
