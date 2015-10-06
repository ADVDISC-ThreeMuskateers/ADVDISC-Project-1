package model;

import exception.UnequalDimensionsException;

public class Matrix {
	private double[][] matrix;
	private int row, col;
	
	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		matrix = new double[row][col];
	}
	
	/**Getters and Setters**/
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public double getValueAt(int x, int y) throws IndexOutOfBoundsException{
		return matrix[x][y];
	}
	
	public void setValueAt(int x, int y, double val) throws IndexOutOfBoundsException {
		this.matrix[x][y] = val;
	}
	
	public static void printMatrix(Matrix m) {
		for(int x = 0; x < m.getRow(); x++) {
			for(int y = 0; y < m.getCol(); y++) {
				System.out.print(m.getValueAt(x, y) + " ");
			}
			System.out.println("");
		}
	}
	
	/** Basic Matrix rules and stuff **/
	public boolean isSquareMatrix() {
		if(col == row)
			return true;
		return false;
	}
	
	public boolean isRowMatrix() {
		if(row == 1)
			return true;
		return false;
	}
	
	public boolean isColumnMatrix() {
		if(col == 1)
			return true;
		return false;
	}
	
	public static Matrix getIdentityMatrix(int row) {
		Matrix identity = new Matrix(row, row);
		
		for(int x = 0; x < identity.getRow(); x++) { 
			for(int y = 0; y < identity.getCol(); y++) {
				if(x != y) {
					identity.setValueAt(x, y, 0);
				} else identity.setValueAt(x, y, 1);
			}
		}
		
		return identity;
	}
	
	public static Matrix getColumnMatrix(Matrix m, int col) throws Exception{
		if(m.getCol() <= col && col < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Matrix result = new Matrix(m.getRow(), 1);
		for(int x = 0; x < m.getRow(); x++) {
			result.setValueAt(x, 0, m.getValueAt(x, col));
		}
		
		return result;
	}
	
	public static Matrix getRowMatrix(Matrix m, int row) throws Exception{
		if(m.getRow() <= row && row < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Matrix result = new Matrix(1, m.getCol());
		for(int x = 0; x < m.getCol(); x++) {
			result.setValueAt(0, x, m.getValueAt(row, x));
		}
		
		return result;
	}
	
	/** Matrix Operations **/
	public static Matrix addMatrices(Matrix m1, Matrix m2) throws UnequalDimensionsException {
		if(m1.getCol() == m2.getCol() && m1.getRow() == m2.getRow()) {
			throw new UnequalDimensionsException();
		}
		
		Matrix result = new Matrix(m1.getRow(), m1.getCol());
		for(int x = 0; x < m1.getRow(); x++) {
			for(int y = 0; y < m1.getCol(); y++) {
				double val = m1.getValueAt(x, y) + m2.getValueAt(x, y);
				result.setValueAt(x, y, val);
			}
		}
		
		return result;
	}
	
	public static Matrix subtractMatrices(Matrix m1, Matrix m2) throws UnequalDimensionsException {
		return Matrix.addMatrices(m1, Matrix.scalarMultiply(-1, m2));
	}
	
	public static Matrix transposeMatrix(Matrix m) {
		Matrix result = new Matrix(m.getCol(), m.getRow());
		
		for(int x = 0; x < m.getRow(); x++) {
			for(int y = 0; y < m.getCol(); y++) {
				result.setValueAt(y, x, m.getValueAt(x, y));
			}
		}
		
		return result;
	}
	
	public static Matrix scalarMultiply(double c, Matrix m) {
		Matrix result = new Matrix(m.getRow(), m.getCol());
		
		for(int x = 0; x < m.getRow(); x++) {
			for(int y = 0; y < m.getCol(); y++) {
				result.setValueAt(x, y, c * m.getValueAt(x, y));
			}
		}
		
		return result;
	}
	
	public static double getDotProduct(Matrix m1, Matrix m2) {
		double val = 0;
		
		if(m1.isRowMatrix() && m2.isColumnMatrix()) {
			Matrix transpose = Matrix.transposeMatrix(m2);
			for(int x = 0; x < m1.getCol(); x++) {
				val += m1.getValueAt(0, x) * transpose.getValueAt(0, x);
			}
		}
		return val;
	}
	
	public static Matrix multiplyMatrices(Matrix m1, Matrix m2) throws Exception {
		if(m1.getCol() != m2.getRow()) {
			throw new UnequalDimensionsException();
		}
		
		Matrix result = new Matrix(m1.getRow(), m2.getCol());
		
		for(int x = 0; x < m1.getRow(); x++) {
			for(int y = 0; y < m2.getCol(); y++) {
				double val = Matrix.getDotProduct(Matrix.getRowMatrix(m1, x), Matrix.getColumnMatrix(m2, y));
				result.setValueAt(x, y, val);
			}
		}

		return result;
	}
	
	/**Row Operations**/
	/** R1 <-> R2 **/
	public void swapRow(int row1, int row2) {
		double[] temp = matrix[row1];
		matrix[row1] = matrix[row2];
		matrix[row2] = temp;
	}
	
	/** cR1 -> R1 **/
	public void multiplyRow(double c, int row) {
		for(int y = 0; y < col; y++) {
			matrix[row][y] *= c;
		}
	}
	
	/** cR1 + R2 -> R2 **/
	public void addRowToRow(double c, int row1, int row2) {
		for(int y = 0; y < col; y++) {
			matrix[row2][y] += c * matrix[row1][y];
		}
	}
	
	/** Gauss-Jordan Elimination **/
	public static Matrix getGaussJordan(Matrix m, Matrix b) {
		Matrix tempM = m.clone();
		Matrix tempB = b.clone();
		
		int col = 0;
		for(int x = 0; x < m.getRow(); x++, col++) {
			int swapWith = x;
			
			//looking for the first non-zero number in the column
			for(int i = x; i < m.getRow(); i++) {
				if(tempM.getValueAt(i, col) != 0) {
					swapWith = i;
					break;
				}
			}
			
			//looking if there is an actual one in the column
			for(int i = x; i < m.getRow(); i++) {
				if(tempM.getValueAt(i, col) == 1) {
					swapWith = i;
					break;
				}
			}
			
			//swap rows it better row is found
			if(swapWith != x) {
				tempM.swapRow(x, swapWith);
				tempB.swapRow(swapWith, x);
			}
			
			double rowC = tempM.getValueAt(x, col);
			if(rowC != 1.0) {
				tempM.multiplyRow(1/rowC, x);
				tempB.multiplyRow(1/rowC, x);
			}
			
			for(int y = x + 1; y < m.getRow(); y++) {
				rowC = tempM.getValueAt(y, col);
				
				if(rowC != 0) {
					tempM.addRowToRow(-rowC, x, y);
					tempB.addRowToRow(-rowC, x, y);
				}
			}
			
			System.out.println("===============================================");
			System.out.println("Step " + (col + 1));
			Matrix.printMatrix(tempB);
		}
		
		return tempB;
	}
	
	/** Inverse **/
	public static Matrix getInverse(Matrix m) throws Exception {
		if(!m.isSquareMatrix())
			throw new UnequalDimensionsException();
		
		Matrix identity = Matrix.getIdentityMatrix(m.getRow());
		
		return Matrix.getGaussJordan(m, identity);
	}

	public Matrix clone() {
		Matrix ret = new Matrix(this.row, this.col);
		
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < col; y++) {
				ret.setValueAt(x, y, matrix[x][y]);
			}
		}
		
		return ret;
	}
}
