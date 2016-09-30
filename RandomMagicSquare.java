import java.util.ArrayList;

public class RandomMagicSquare extends MagicSquare {

	public RandomMagicSquare(int n) {
		super(n);
	}
	
	public void generate() {
		while(!this.isMagic()) {
			this.fill();
		}
		this.display();
	}
	
	private void fill() {
		ArrayList<Integer> possibilities = this.randomSequence();
		int cpt = 0;
		for (int i = 0; i < this.square.length; i++) {
			for (int j = 0; j < this.square.length; j++) {
				this.square[i][j] = possibilities.get(cpt);
				cpt++;
			}
		}
	}
	
	private ArrayList<Integer> randomSequence() {
		
		ArrayList<Integer >numbers = new ArrayList<Integer>();
		int cpt = (int) Math.pow(this.n, 2);
		int random;
		int sum = 0;
		
		while (cpt > 0) {
			random = 1 + (int)(Math.random() * Math.pow(this.n, 2));
			if (!numbers.contains(random)) {
				numbers.add(random);
				cpt--;
				sum = sum + random;
				if (cpt % this.n == 0) {
					if (sum != this.magicNumber) {
						cpt = (int) Math.pow(this.n, 2);
						numbers.clear();
					}
					sum = 0;
				}
			}
		}
		
		return numbers;
	}

}
