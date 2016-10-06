import java.util.ArrayList;

public class OptimizedMagicSquare extends MagicSquare {

	public OptimizedMagicSquare(int n) {
		super(n);
	}

	public boolean isMagic() {

		int sum = 0;
		int sum2 = 0;
		for (int i = 0; i < square.length; i++) {
			sum = sum + square[i][i];
			sum2 = sum2 + square[i][this.square.length - 1 - i];
		}

		if (sum != this.magicNumber || sum2 != this.magicNumber) {
			return false;
		}

		return true;
	}

	public boolean isMagic(int[][] m) {
		int sumColumn = 0;
		int sumDiagonalLeft = 0;
		int sumDiagonalRight = 0;

		for (int i = 0; i < this.square.length; i++) {
			sumColumn = 0;
			for (int j = 0; j < this.square.length; j++) {
				sumColumn = sumColumn + m[j][i];
				if(i == j) {
					sumDiagonalLeft = sumDiagonalLeft + m[i][j];
				}
				if(j == this.square.length - 1 - i) {
					sumDiagonalRight = sumDiagonalRight + m[i][j];
				}
			}
			if (sumColumn != this.magicNumber) {
				return false;
			}
		}

		if(sumDiagonalLeft != this.magicNumber || sumDiagonalRight != this.magicNumber) {
			return false;
		}

		return true;
	}

	public void generate() {

		ArrayList<int[]> permutations = new ArrayList<int[]>();
		boolean[] dictionary = new boolean[(int) Math.pow(n, 2)];
		int[][] magicSquare = new int[this.n][this.n];

		// On appelle les permutations des lignes
		/*
		 * Pour chaque permutation p: - insérer p en première ligne - insérer le
		 * reste en se basant sur le premier élément - vérifier diagonal
		 */
	}

}
