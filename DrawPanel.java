import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;


public class DrawPanel extends JPanel{
  private Image image = null;
    public DrawPanel(){
	repaint();
	
    }
    
    public void paintComponent(Graphics g) { 
	
        g.setColor(Color.white);        
        g.fillRect( 0, 0, 900, 1000 ); 

	image = getToolkit().getImage("image/et.png");

	if(image != null){ // Si l'image existe, ...
	    g.drawImage(image, 100, 20, this); 
	}
	
	/*g.setColor(Color.black); 
	for( int y=0; y<cellRows; y++ ) { 
	    for( int x=0; x<cellCols; x++ ) { 
		if ( cells[x][y] ) { 
		    g.fillRect( x*cellSize, y*cellSize, cellSize-1, cellSize-1 ); 
		} 
	    } 
        }*/

	
    }
    
    
    /*
     * Efface le contenu
     
    public synchronized void clear() { 
	generations = 0; 
	for( int x=0; x<cellCols; x++ ) { 
	    for( int y=0; y<cellRows; y++ ) { 
		cells[x][y] = false;
	    } 
	}
	repaint();
	}*/
    
}