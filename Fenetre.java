//package simulation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
  
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class Fenetre extends JFrame implements Runnable {
	
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
	    
	    /* Les Ã©couteurs */ 
	    
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
	    
	    public Fenetre() {
	    	
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
		
		public static void main(String[] args){
        Fenetre fen = new Fenetre(); 
		}

		public void run() {
			
		}
  

}
