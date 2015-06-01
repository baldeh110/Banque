package Form;

/**
 * @(#)ZoneSesieEtiquete.java
 *
 *
 * @author charif
 * @version 1.00 2006/11/29
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
public class ZoneSesieEtiquete extends JPanel{
	private JTextComponent text;
	private JLabel label;
    public ZoneSesieEtiquete(String l,int t) {
    	((FlowLayout)getLayout()).setAlignment(0);
    	add(label = new JLabel(l));
    	add(new JLabel(": "));
    	add(text = new JTextField(t));
    		
    }
    public String getText(){
    	return  text.getText();
    }
    public void settext(String s){
		text.setText(s);
    }
    public String getLabelText(){
    	return label.getText();
    }
    public void setLabelText(String s){
    	label.setText(s);
    }
    public void setlabel(JLabel l){
    	remove(label);
    	add(label = l,0);
    }
    public void setTextComponent(JTextComponent t){
    	remove(text);
    	add(text=t);
    }
    public void setLabelPreferedSize(Dimension d){
    	label.setPreferredSize(d);
    }
   
}