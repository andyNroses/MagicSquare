
public class MAIN {
	
	public static void main(String args[]) {
		
		MagicSquare m1 = new RandomMagicSquare(3);
		MagicSquare m2 = new DiagonalMagicSquare(4);
		
		System.out.println("Random solving - n = 3");
		m1.generate();
		System.out.println();
		
		System.out.println("Diagonal reverse solving, n = 4");
		m2.generate();
		
	}

}
