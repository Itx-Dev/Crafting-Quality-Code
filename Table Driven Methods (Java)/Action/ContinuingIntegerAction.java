package Action;

import Main.InterimResult;

public class ContinuingIntegerAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		double v = x.getV();
		v = 10 * v + c - '0';
		x.setV(v);
		return x;
	}

}
