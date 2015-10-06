package matrix;

public class SquareMatrix extends Matrix {
	
	public SquareMatrix(int edge) {
		super(edge, edge);
	}
	
	public boolean isDiagonal() {
		for(int x = 0; x < this.getRow(); x++) {
			for(int y = 0; y < this.getRow(); y++) {
				if(x != y && getValueAt(x, y) != 0) {
					return false;
				} else if(x == y && getValueAt(x, y) == 0) {
					return false;
				} 
			}
		}
		
		return true;
	}
	
	public boolean isSymmetric() {
		Matrix transpose = transposeMatrix(this);
		for(int x = 0; x < this.getRow(); x++) {
			for(int y = 0; y < this.getRow(); y++) {
				if(transpose.getValueAt(x, y) != this.getValueAt(x, y))
					return false;
			}
		}
		
		return true;
	}
	
	/** Inverse **/
	public Matrix getInverse() throws Exception {
		Matrix identity = Matrix.getIdentityMatrix(this.getRow());
		
		return Matrix.getGaussJordan(this, identity);
	}
}
