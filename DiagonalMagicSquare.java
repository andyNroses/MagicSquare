
public class DiagonalMagicSquare extends MagicSquare {

	public DiagonalMagicSquare(int n) {
		super(n);
	}
	
	public void generate() {
		this.fill();
		this.reverseDiagonal();
		this.display();
	}
	
	private void fill() {
		int cpt = 1;
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				this.square[i][j] = cpt;
				cpt++;
			}
		}
	}
	
	private void reverseDiagonal() {
		for (int j = 1 ; j <= n; j++) {
			for (int i = 1 ; i <= n; i++) {
				if (j % 4 == 1 || j % 4 == 0) {
					if (i % 4 == 2 || i % 4 == 3) {
						this.square[j-1][i-1] = n*n - this.square[j-1][i-1] + 1;
					}
				}

				if (j % 4 == 2 || j % 4 == 3) {
					if (i % 4 == 1 || i % 4 == 0) {
						this.square[j-1][i-1] = n*n - this.square[j-1][i-1] + 1;
					}
				}
			}
		}
	}
}
