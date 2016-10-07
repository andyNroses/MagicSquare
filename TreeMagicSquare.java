import java.util.ArrayList;

public class TreeMagicSquare {
	
	private int squareSize;
	private ArrayList<Integer> combination;
	//private ArrayList<TreeMagicSquare> sons;
	
	public TreeMagicSquare(int n) {
		this.combination = new ArrayList<Integer>();
		//this.sons = new ArrayList<TreeMagicSquare>();
		this.squareSize = n;
	}
	
	private void setCombination(ArrayList<Integer> c) {
		this.combination = c;
	}
	
	public void generate() {
		
		for (int i = 1; i < Math.pow(this.squareSize, 2); i++) {			
			if (!this.combination.contains(i)) {
				ArrayList<Integer> sonCombination = new ArrayList<Integer>();
				sonCombination.addAll(this.combination);
				sonCombination.add(i);				
				if (sonCombination.size() <= 16) {
					if (this.check(sonCombination)) {
						TreeMagicSquare son = new TreeMagicSquare(this.squareSize);
						son.setCombination(sonCombination);
						//this.sons.add(son);
						son.generate();
					}
				}
			}
		}
	}
	
	private boolean check(ArrayList<Integer> combination) {
		
		//Je check si je suis à l'avant dernière case de la ligne
		if ((combination.size() + 1) % this.squareSize == 0) {
			int index = combination.size() - this.squareSize - 1;
			int sum = 0;
			for (int i = index; i < combination.size(); i++) {
				sum += combination.get(i);
			}
			
			boolean isOk = sum + Math.pow(this.squareSize, 2) >= MagicSquare.getMagicNumber(this.squareSize);
			
			//Je check si je suis à l'avant dernière ligne pour tester la diagonale
			if (isOk && combination.size() == Math.pow(this.squareSize, 2) - this.squareSize - 1) {
				//Je check la diagonale
				int cpt = 0;
				sum = 0;
				for (int i = 0; i < Math.pow(this.squareSize - 1, 2); i = i + this.squareSize) {
					sum += combination.get(i + cpt);
					cpt++;
				}
				
				isOk = sum + Math.pow(this.squareSize, 2) >= MagicSquare.getMagicNumber(this.squareSize);
			
				//Je check si les trois cases de la colonne + 16 sont ok
				if(isOk) {
					sum = 0;
					for (int i = this.squareSize - 2; i < Math.pow(this.squareSize, 2) - this.squareSize - 1; i = i + 4) {
						sum += combination.get(i);
					}
					
					return sum + Math.pow(this.squareSize, 2) >= MagicSquare.getMagicNumber(this.squareSize);
				} else {
					return false;
				}
				
			} else {
				return isOk;
			}
			
		//Je check si je suis à la dernière case d'une ligne
		} else if (combination.size() % this.squareSize == 0) {
			
			//Je check le nombre magique en ligne
			int index = combination.size() - this.squareSize;
			int sum = 0;
			for (int i = index; i < combination.size(); i++) {
				sum =+ combination.get(i);
			}
			
			boolean isOk = sum == MagicSquare.getMagicNumber(this.squareSize);
			
			//Je check si je suis à la dernière ligne
			if (isOk && combination.size() == Math.pow(this.squareSize, 2)) {
				//Je check la diagonale
				int cpt = 0;
				sum = 0;
				for (int i = 0; i < Math.pow(this.squareSize, 2); i = i + this.squareSize) {
					sum += combination.get(i + cpt);
					cpt++;
				}
				
				isOk = sum == MagicSquare.getMagicNumber(this.squareSize);
				
				//Je check si la dernière colonne est ok
				if (isOk) {
					sum = 0;
					for (int i = this.squareSize - 1; i < Math.pow(this.squareSize, 2); i = i + this.squareSize) {
						sum += combination.get(i);
					}
					
					boolean ok = sum == MagicSquare.getMagicNumber(this.squareSize);
					
					if(ok) {
						//SOLUTION !
						System.out.println("solution!");
					}
					
					return ok;
					
				} else {
					return false;
				}
			} else if (isOk && combination.size() == Math.pow(this.squareSize, 2) - this.squareSize) {
				sum = 0;
				for (int i = this.squareSize - 2; i < Math.pow(this.squareSize, 2) - this.squareSize - 1; i = i + 4) {
					sum += combination.get(i);
				}
				
				return sum + Math.pow(this.squareSize, 2) >= MagicSquare.getMagicNumber(this.squareSize);
			} else {
				return isOk;
			}
		} 
	}
}
