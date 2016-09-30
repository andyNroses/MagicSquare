
abstract class MagicSquare {
	
	protected int[][] square;
	protected int n;
	protected int magicNumber;
	
	public MagicSquare(int n) {
		this.square = new int[n][n];
		this.n = n;
		this.magicNumber = (int) (n * (Math.pow(n, 2) + 1)) / 2;
	}
	
	abstract void generate();
	
	public boolean isMagic() {
		//Somme des lignes
		int sum;
		for (int i = 0; i < square.length; i++) {
			sum = 0;
			for (int j = 0; j < square.length; j++) {
				sum = sum + square[i][j];
			}
			if (sum != this.magicNumber) {
				return false;
			}
		}
		//Somme des colonnes
		for (int i = 0; i < square.length; i++) {
			sum = 0;
			for (int j = 0; j < square.length; j++) {
				sum = sum + square[j][i];
			}
			if (sum != this.magicNumber) {
				return false;
			}
		}
		
		//Somme des diagonales
		sum = 0;
		int sum2 = 0;
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				if (i == j) {
					sum = sum + square[i][j];
					sum2 = sum2 + square[i][this.square.length - 1 - j];
				}
			}
		}
		
		if(sum != this.magicNumber || sum2 != this.magicNumber) {
			return false;
		}
		
		return true;
	}
	
	public void display() {
		for (int i = 0; i < this.square.length; i++) {
			for (int j = 0; j < this.square.length; j++) {
				System.out.print("[" + this.square[i][j] + "]");
			}
			System.out.println();
		}
	}
	
}
