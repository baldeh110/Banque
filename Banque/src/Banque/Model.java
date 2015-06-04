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
			reponse = "Décision pour ce client : OUI à "+ floor(results[0],4)*100 + "%";
		}
		else {
			reponse = "Décision pour ce client : NON à "+ floor(results[1],4)*100 + "%";
		}
		return reponse;
	}
	
	
	  
   public static double floor(double a, int n) {
   	double p = Math.pow(10.0, n);
   	return Math.floor((a*p)+0.5) / p;
   }

	   

}

