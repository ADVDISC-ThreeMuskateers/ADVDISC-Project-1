import model.Matrix;

public class Driver {

	public static void main(String[] args) {
		Matrix m1 = new Matrix(3, 3);
		//Matrix m2 = Matrix.getIdentityMatrix(5);
		/*
		for(int x = 0; x < m1.getRow(); x++) {
			for(int y = 0; y < m1.getCol(); y++) {
				m1.setValueAt(x, y, Math.floor(Math.random()*10));
			}
		}*/
		
		m1.setValueAt(0, 0, 4);
		m1.setValueAt(0, 1, 1);
		m1.setValueAt(0, 2, 5);
		m1.setValueAt(1, 0, 2);
		m1.setValueAt(1, 1, 7);
		m1.setValueAt(1, 2, 2);
		m1.setValueAt(2, 0, 3);
		m1.setValueAt(2, 1, 2);
		m1.setValueAt(2, 2, 7);
		
		Matrix.printMatrix(m1);
		System.out.println("================================================");
		//Matrix.printMatrix(m2);
		//System.out.println("================================================");
		
		try {
			Matrix.printMatrix(Matrix.getInverse(m1));
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
