package Action;

import Main.InterimResult;

public class StartFraction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		x.setP(0.1);
		return x;
	}

}
