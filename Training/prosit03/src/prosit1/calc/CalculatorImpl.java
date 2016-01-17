package prosit1.calc;

import java.util.*;
import prosit1.calc.exceptions.*;


class CalculatorImpl implements AdvancedCalculator{ 
	private List<Double> results;//**5

	public Double add(Double a, Double b) throws IllegalOperandException{

		validateOperand(a,b);

		Double sum = (a + b) ;//**6			
		results.add(sum);
		return sum;
}

	public Double divide(Double a, Double b) throws IllegalOperandException, CalculatorException{

	validateOperand(a,b);

	if(b.equals(0.0)) throw new CalculatorException("division par 0 impossible");

	this.results.add(new Double((a/b)));
	return (a / b);

	}

	public Double multiply(Double a, Double b) throws IllegalOperandException{
		validateOperand(a,b);
		if(a.equals(0.0) OR b.equals(0.0)) {//**7
				this.results.add(0.0);
				return 0.0;
			} else{
				Double res = a * b;
				this.results.add(res);
				return res;
			}
	}

	public List<Double> listAllResults(){

		return results;

	}

	private void validateOperand(Double a, Double b) throws IllegalOperandException{
		if(a==null || b == null ) throw new IllegalOperandException("un argument est null :a vaut "+a+" et b vaut :"+b);

	}

}