import model.Matrix;

public class Driver {

	public static void main(String[] args) {
		Matrix m1 = new Matrix(3, 5);
		Matrix m2 = Matrix.getIdentityMatrix(5);
		for(int x = 0; x < m1.getRow(); x++) {
			for(int y = 0; y < m1.getCol(); y++) {
				m1.setValueAt(x, y, Math.random()*10);
			}
		}
		
		Matrix.printMatrix(m1);
		Matrix.printMatrix(m2);
		
		try {
			Matrix.printMatrix(Matrix.multiplyMatrices(m1, m2));
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
