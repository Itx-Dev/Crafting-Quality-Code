public class VerifyNumber extends MathBehavior {
    @Override
    protected int delegateMath(int x) {
        if (x == 2) {
            return x;
        } else {
            return -1;
        }
    }
}
