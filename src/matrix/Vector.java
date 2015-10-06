package matrix;

public class Vector extends Matrix {
	public Vector(int dimension) {
		super(dimension, 1);
	}
	
	//Default 2D Vector
	public Vector() {
		super(2, 1);
	}
	
	public double getValueAt(int x) {
		return super.getValueAt(x, 0);
	}
	
	public void setValueAt(int x, double val) {
		super.setValueAt(x, 0, val);
	}
	
	public double getMagnitude() {
		return Math.sqrt(Matrix.getDotProduct(this, transposeMatrix(this)));
	}
	
	public static double getDistance(Vector v, Vector u) {
		return Math.sqrt(Matrix.getDotProduct(v, transposeMatrix(scalarMultiply(-1, u))));
	}
	
	public static double getDirection(Vector u, Vector v) {
		return Math.cos(getDotProduct(u, transposeMatrix(v))/(u.getMagnitude() * v.getMagnitude()));
	}
	
	public static double getAngle(Vector u, Vector v) {
		return Math.acos(getDirection(u, v)*180/Math.PI);
	}
	
	public static boolean isOrthogonal(Vector u, Vector v) {
		if(getDotProduct(u, transposeMatrix(v)) == 0) 
			return true;
		return false;
	}
	
	public static boolean isParallel(Vector u, Vector v) {
		if(Math.abs(getDotProduct(u, transposeMatrix(v))) == u.getMagnitude() * v.getMagnitude())
			return true;
		return false;
	}
}
