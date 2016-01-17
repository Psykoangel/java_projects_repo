package prosit1.calc;
import prosit1.calc.exceptions.CalculatorException;
import prosit1.calc.exceptions.IllegalOperandException;

public interface AdvancedCalculator extends BasicCalculator{//** 8			
	public Double divide(Double a, Double b) throws IllegalOperandException,CalculatorException;
	public Double multiply(Double a, Double b) throws IllegalOperandException;
	public java.util.List<Double> listAllResults();
}