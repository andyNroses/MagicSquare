import java.util.ArrayList;

public class TreeMagicSquare {
	
	private int squareSize;
	private ArrayList<Integer> combination;
	public static int cpt = 0;
	//private ArrayList<TreeMagicSquare> sons;
	
	public TreeMagicSquare(int n) {
		this.combination = new ArrayList<Integer>();
		//this.sons = new ArrayList<TreeMagicSquare>();
		this.squareSize = n;
	}
	
	private void setCombination(ArrayList<Integer> c) {
		this.combination = c;
	}
	
	public int getCpt() {
		return cpt;
	}
	
	public void generate() {
		
		for (int i = 1; i <= Math.pow(this.squareSize, 2); i++) {			
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
	
	private int sumLine(ArrayList<Integer> line, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += line.get(i);
		}
		return sum;
	}
	
	private int sumColumn(ArrayList<Integer> column, int start, int end, int step) {
		int sum = 0;
		for (int i = start; i <= end; i = i + step) {
			sum += column.get(i);
		}
		
		return sum;
	}
	
	private boolean check(ArrayList<Integer> combination) {
		int index = combination.size() - 1;
		switch(index) {
			case 2:
				return sumLine(combination, 0, 2) + 16 >= 34;
			case 3:
				return sumLine(combination, 0, 3) == 34;
			case 6:
				return sumLine(combination, 4, 6) + 16 >= 34;
			case 7:
				return sumLine(combination, 4, 7) == 34;
			case 8:
				return sumColumn(combination, 0, 8, 4) + 16 >= 34;
			case 9:
				if (sumColumn(combination, 1, 9, 4) + 16 >= 34) {
					return combination.get(3) + combination.get(6) + combination.get(9) + 16 >= 34;
				} else {
					return false;
				}
			case 10:
				if (sumLine(combination, 8, 10) + 16 >= 34) {
					if (combination.get(0) + combination.get(5) + combination.get(10) + 16 >= 34) {
						return sumColumn(combination, 2, 10, 4) + 16 >= 34;
					} else {
						return false;
					}
				} else {
					return false;
				}
			case 11:
				if (sumLine(combination, 8, 11) == 34) {
					return sumColumn(combination, 3, 11, 4) + 16 >= 34;
				} else {
					return false;
				}
			case 12:
				if (sumColumn(combination, 0, 12, 4) == 34) {
					return combination.get(3) + combination.get(6) + combination.get(9) + combination.get(12) == 34;
				} else {
					return false;
				}
			case 13:
				return sumColumn(combination, 1, 13, 4) == 34;
			case 14:
				if (sumLine(combination, 12, 14) + 16 >= 34) {
					return sumColumn(combination, 2, 14, 4) == 34;
				} else {
					return false;
				}
			case 15:
				if (sumLine(combination, 12, 15) == 34) {
					if (sumColumn(combination, 3, 15, 4) == 34) {
						if(combination.get(0) + combination.get(5) + combination.get(10) + combination.get(15) == 34) {
							cpt++;
							return true;
						}  else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			default:
				return true;
 		}
	}
}
