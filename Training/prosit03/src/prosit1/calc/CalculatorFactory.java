package prosit1.calc;

public abstract class CalculatorFactory{
 
	public static BasicCalculator getBasicCalculator(){

		return new CalculatorImpl();//type de retour BasicCalculator

	}

	public static AdvancedCalculator getAdvancedCalculator(){

		AdvancedCalculator ac= new CalculatorImpl();
		return ac;

	}


}