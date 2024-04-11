package Action;

import Main.InterimResult;

public class ContinuingFactionAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		double v = x.getV();
		double p = x.getP();
		v = v + (p * (c - '0'));
		p /= 10;
		x.setV(v);
		x.setP(p);
		return x;
	}

}
