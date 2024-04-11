package Action;

import Main.InterimResult;

public class ValueIsDigitAction implements Action {
	
	@Override
	public InterimResult execute(InterimResult x, char c) {
		double v = x.getV();
		v = c - '0';
		x.setV(v);
		
		return x;
	}

}
