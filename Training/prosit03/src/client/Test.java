/*
compilation :
javac -d classes prosit1/calc/*.java prosit1/calc/exceptions/*.java
javac -d classes client/Test.java
exécution: 
java -cp classes client.Test
*/

package client;

import prosit1.*; //** 1
import prosit1.calc.AdvancedCalculator;
import prosit1.calc.BasicCalculator;
import prosit1.calc.CalculatorFactory;
import prosit1.calc.exceptions.IllegalOperandException;

import java.util.List;

public class Test{

	public static void main(String[] args){

		BasicCalculator bc = CalculatorFactory.getBasicCalculator();

		AdvancedCalculator advanced= CalculatorFactory.getAdvancedCalculator();

		try{
			double d = advanced.divide(12.3, 13.);
			System.out.println("resultat de la division : "+d);

			d = advanced.multiply(5.0, 2.1); //** 2	
			System.out.println("resultat de la multiplication : "+d);

			System.out.println("resultat de l'addition : "+advanced.add(9.0,4.9));

			bc.add(6.0,2.);
			bc.add(3.0,2.7);
			
			//je veux passer en mode avancé pour lister les résultats des additions
			//je sais que l'objet référencé par la variable est de type CalculatorImpl
			if (bc instanceof AdvancedCalculator){ //retourne true si bc référence un objet implémentant AdvancedCalculator 
				AdvancedCalculator changed = (AdvancedCalculator) bc;//**3
				System.out.println("***liste des resultats avec la calc. basique ***");
				listResults(changed.listAllResults());
			}
		}
		catch (IllegalOperandException ioe){
			ioe.printStackTrace();
		}
		finally{
			System.out.println("***liste des resultats avec la calc. avancee ***");
			listResults(advanced.listAllResults());
			
			advanced = null;
			bc = null;
		}

			System.out.println("fin du programme");

	}

	private static void listResults(List<Double> ls){
		int compt =0;
		for(Double result : ls){ 
			System.out.println("resultat "+(++compt)+" : "+result);
		}
	}

}