import matrix.Matrix;
import matrix.SquareMatrix;
import matrix.Vector;

public class Driver {

	public static void main(String[] args) {
		Vector v = new Vector(3);
		Vector newCoordinate = new Vector(v.getRow());
		
		for(int i = 0; i < v.getRow(); i++) {
			v.setValueAt(i, Math.pow(-1, Math.floor(Math.random() * 10)) * Math.random()*10);
			newCoordinate.setValueAt(i, Math.pow(-1, Math.floor(Math.random() * 10)) * Math.random()*10);
		}
		
		Matrix.printMatrix(v);
		System.out.println("==============================");
		Matrix.printMatrix(newCoordinate);
		System.out.println("==============================");
		v.translateMatrix(newCoordinate);
		Matrix.printMatrix(v);
	}

}
