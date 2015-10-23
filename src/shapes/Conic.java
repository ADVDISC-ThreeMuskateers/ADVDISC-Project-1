package shapes;

import java.awt.Graphics2D;
import java.util.function.Function;

public abstract class Conic extends Shape {
	protected Function<Double, Double> f;
	protected int xMax, xMin;
	protected boolean isVertical;
	
	public Conic(int xMin, int xMax, boolean isVertical) {
		super();
		this.xMax = xMax;
		this.xMin = xMin;
		this.isVertical = isVertical;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
