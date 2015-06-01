package Form;

/**
 * @(#)TestFormulaire.java
 *
 *
 * @author charif
 * @version 1.00 2006/11/29
 */
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import java.awt.FlowLayout;
public class TestFormulaire extends JFrame{
        
    private Formulaire f;
    public TestFormulaire() {
    	f = new Formulaire();
    	f.add("charif",15);
    	f.add("c",15);
    	f.add("charifkjbhkdjshkjhskj",15);
    	f.add("cha",15);
    	f.add("rdem",50);
    	f.synchronZones();
    	f.setTextAt("howa",0);
    	f.setTextAt("hadak","c");
    	f.setTextAt(f.getTextAt(f.getLabelTextAt(0)),f.getLabelTextAt(2));
    	((JPanel)getContentPane()).setLayout(new FlowLayout());
    	((JPanel)getContentPane()).add(f);
    	pack();
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setResizable(false);
    	setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestFormulaire();
    }
}
