package Action;

import Main.InterimResult;

public class NegateAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		x.setS(-1);
		return x;
	}

}
