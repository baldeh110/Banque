package Form;

/**
 * @(#)Formulaire.java
 *
 *
 * @author charif
 * @version 1.00 2006/11/29
 */

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
public class Formulaire extends JPanel{
	private String name;
    public Formulaire(String n) {
    	setBorder(BorderFactory.createTitledBorder(name= n));
    	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    public Formulaire() {
    	setBorder(BorderFactory.createEtchedBorder());
    	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    public void add(String label,int textwidth){
    	add(new ZoneSesieEtiquete(label,textwidth));
    }
    
    public int synchronZones(){
    	int max = 0;
    	for (int i = 0; i<getComponentCount(); i++) {
        		int l  = ((ZoneSesieEtiquete)this.getComponent(i)).getLabelText().length();
    		max = max>l?max:l;
		}
    	for (int i = 0; i<getComponentCount(); i++) 
    	((ZoneSesieEtiquete)this.getComponent(i)).setLabelPreferedSize(new  Dimension(max*7,20));
	return max;
    }
    public void setTextCompenentAt(JTextComponent t,int i){
    	if(i<getComponentCount())
    	((ZoneSesieEtiquete)this.getComponent(i)).setTextComponent(t);
    }
    public void setLabelAt(JLabel l,int i){
    	if(i<getComponentCount())
    	((ZoneSesieEtiquete)this.getComponent(i)).setlabel(l);
    }
    public void setLabelTextAt(String s,int i){
    	if(i<getComponentCount())
    	((ZoneSesieEtiquete)this.getComponent(i)).setLabelText(s);
    }
    public String getLabelTextAt(int i){
    	return ((ZoneSesieEtiquete)this.getComponent(i)).getLabelText();
    }
    public void setTextAt(String s,int i){
    	if(i<getComponentCount())
    	((ZoneSesieEtiquete)this.getComponent(i)).settext(s);
    }
    public String getTextAt(int i){
    	return ((ZoneSesieEtiquete)this.getComponent(i)).getText();
    }
    public String getTextAt(String s){
    	for (int i = 0; i<getComponentCount(); i++) 
        		if(((ZoneSesieEtiquete)this.getComponent(i)).getLabelText().equals(s))return getTextAt(i);
        return null;
    }
    public void  setTextAt(String text,String labelName){
    	for (int i = 0; i<getComponentCount(); i++) 
        		if(((ZoneSesieEtiquete)this.getComponent(i)).getLabelText().equals(labelName)){
        			((ZoneSesieEtiquete)getComponent(i)).settext(text);
        			return;
        		}
    }
   	public String getTextAt(JLabel l){
   		for (int i = 0; i<getComponentCount(); i++) 
        		if(((ZoneSesieEtiquete)this.getComponent(i)).equals(l))return getTextAt(i);
        return null;
   	}
   	public void getTextAt(String text,JLabel l){
   		for (int i = 0; i<getComponentCount(); i++) 
        		if(((ZoneSesieEtiquete)this.getComponent(i)).equals(l)){
        			((ZoneSesieEtiquete)getComponent(i)).settext(text);
        			return;
        		}
   	}
   	
    
}