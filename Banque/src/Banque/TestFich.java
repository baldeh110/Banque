package Banque;

import java.io.File;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
	 /**
	  * This example trains NaiveBayes incrementally on data obtained
	  * from the ArffLoader.
	  *
	  * @author FracPete (fracpete at waikato dot ac dot nz)
	  */
public class TestFich {

	   /**
	    * Expects an ARFF file as first argument (class attribute is assumed
	    * to be the last attribute).
	    *
	    * @param args        the commandline arguments
	 * @throws Exception  if something goes wrong
	    */
	   public static void main(String[] args) throws Exception {
	     // load data
	     ArffLoader loader = new ArffLoader();
	     loader.setFile(new File("src/Clients_Données.arff"));
	     Instances structure = loader.getStructure();
	     structure.setClassIndex(structure.numAttributes() - 1);

	     // train NaiveBayes
	     NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
	     nb.buildClassifier(structure);
	     Instance current;
	     while ((current = loader.getNextInstance(structure)) != null)
	       nb.updateClassifier(current);

	     // output generated model
	     System.out.println(nb);
	   }

}

