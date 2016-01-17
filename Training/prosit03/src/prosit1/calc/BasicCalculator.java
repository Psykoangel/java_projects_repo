package prosit1.calc;

import prosit1.calc.exceptions.*;

public interface BasicCalculator{


	public abstract Double add(Double a, Double b) throws IllegalOperandException;

}