package prob06;

public class Sub extends Arith{
	@Override
	public int calculate() {
		return super.getA() - super.getB();
	}
}
