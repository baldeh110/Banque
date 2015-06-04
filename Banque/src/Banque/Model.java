package Banque;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import Form.*;
	 /**
	  * This example trains NaiveBayes incrementally on data obtained
	  * from the ArffLoader.
	  *
	  * @author FracPete (fracpete at waikato dot ac dot nz)
	  */
@SuppressWarnings("deprecation")
public class Model {

	public String traitement( String file, Map<String,String> mapAttributes ,Map<String,Double> mapAttributesNum) throws Exception {

	     ArffLoader loader = new ArffLoader();
	   
	     loader.setFile(new File(file));
	     Instances structure = loader.getStructure();
	     structure.setClassIndex(structure.numAttributes() - 1);

	     // train NaiveBayes
	     NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
	     nb.buildClassifier(structure);
	     Instance current;
	     
	     while ((current = loader.getNextInstance(structure)) != null)
	       nb.updateClassifier(current);

	     // output generated model
	     System.out.println("******* Model *******");
	     System.out.println(nb);
	    
    	 Instance newInstance = new DenseInstance(7); 
		 FastVector attributes = new FastVector(structure.numAttributes());
		 for (int i = 0; i < structure.numAttributes(); i++) {
			attributes.addElement(structure.attribute(i));
		 }

		 Instances instances = new Instances("test", attributes, 1);
		 instances.setClassIndex(attributes.size() - 1);
		 newInstance.setDataset(instances);
		 instances.add(newInstance);

		Iterator iterator = mapAttributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			if (!mapEntry.getValue().toString().isEmpty()) {
				System.out.println(mapEntry.getKey().toString().trim()+" : "+mapEntry.getValue().toString().trim());
				//newInstance.setValue(structure.attribute(mapEntry.getKey().toString().trim()), mapEntry.getValue().toString().trim());
				newInstance.setValue(structure.attribute(mapEntry.getKey().toString().trim()), mapEntry.getValue().toString().trim());
			}
		}
		Iterator iterator2 = mapAttributesNum.entrySet().iterator();
		while (iterator2.hasNext()) {
			Map.Entry mapEntry2 = (Map.Entry) iterator2.next();
			if (!mapEntry2.getValue().toString().isEmpty()) {
				System.out.println(mapEntry2.getKey().toString().trim()+" : "+mapEntry2.getValue().toString().trim());
				newInstance.setValue(structure.attribute(mapEntry2.getKey().toString().trim()), (double) mapEntry2.getValue());
				
			}
		}


		double[] results = nb.distributionForInstance(newInstance);
		
		String reponse;
		if (results[0]>results[1]) {
			reponse = "Décision pour ce client : OUI à "+ floor(results[0],2) + "%";
		}
		else {
			reponse = "Décision pour ce client : NON à "+ floor(results[1],2) + "%";
		}
		return reponse;
	}
	
	
	   /**
	    * Expects an ARFF file as first argument (class attribute is assumed
	    * to be the last attribute).
	    *
	    * @param args        the commandline arguments
	 * @throws Exception  if something goes wrong
	    */
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
	   //public void generate() throws Exception{
	     // load data
	     ArffLoader loader = new ArffLoader();
	     //loader.setFile(new File("C:/Users/thierno/Documents/M2/Info_Décisionnelle/Data Mining/Projet/Clients_Données_Gen.arff"));
	     loader.setFile(new File("src/Ressources/Clients_Données.arff"));
	     Instances structure = loader.getStructure();
	     structure.setClassIndex(structure.numAttributes() - 1);

	     // train NaiveBayes
	     NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
	     nb.buildClassifier(structure);
	     Instance current;
	     
	     while ((current = loader.getNextInstance(structure)) != null)
	       nb.updateClassifier(current);

	     // output generated model
	     System.out.println("******* Model *******");
	     System.out.println(nb);
	     //System.out.println(structure.attribute(0).name());
	    
     	 Instance newInstance = new DenseInstance(7); 
		 FastVector attributes = new FastVector(structure.numAttributes());
		 for (int i = 0; i < structure.numAttributes(); i++) {
			attributes.addElement(structure.attribute(i));
		 }

		 Instances instances = new Instances("test", attributes, 1);
		 instances.setClassIndex(attributes.size() - 1);
		 newInstance.setDataset(instances);
		 instances.add(newInstance);

		 //FenetreFormulaire f = new FenetreFormulaire();
		 
		 newInstance.setValue(structure.attribute("checking_status"), "<0");
		 newInstance.setValue(structure.attribute("duration"), 6);
		 newInstance.setValue(structure.attribute("credit_history"), "critical/other existing credit");
		 newInstance.setValue(structure.attribute("credit_amount"), 1169);
		 newInstance.setValue(structure.attribute("savings_status"), "no known savings");
		 newInstance.setValue(structure.attribute("age"), 67);
		 newInstance.setValue(structure.attribute("foreign_worker"), "yes");

		 double[] results = nb.distributionForInstance(newInstance);
		 System.out.println("******* Decision *******");
		 System.out.println("Good: " + results[0] + "%");
		 System.out.println("Bad: " + results[1] + "%");
		 /*double somme = results[0]+results[1]; 
		 System.out.println("somme: "+somme);
		 System.out.println(newInstance.toString());*/
	   }
	   
	   /**
	    * Arrondi d'un double avec n éléments après la virgule.
	    * @param a La valeur à convertir.
	    * @param n Le nombre de décimales à conserver.
	    * @return La valeur arrondi à n décimales.
	    */
	   public static double floor(double a, int n) {
	   	double p = Math.pow(10.0, n);
	   	return Math.floor((a*p)+0.5) / p;
	   }

	   

}

