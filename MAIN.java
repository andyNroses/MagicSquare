import java.util.ArrayList;

public class MAIN {
	
	public static void main(String args[]) {
		
		/*MagicSquare m1 = new RandomMagicSquare(3);
		MagicSquare m2 = new DiagonalMagicSquare(4);
		
		System.out.println("Random solving - n = 3");
		m1.generate();
		System.out.println();
		
		System.out.println("Diagonal reverse solving, n = 4");
		m2.generate();
		
		MagicSquare m3 = new OptimizedMagicSquare(4);
		m3.generate();*/
		
		TreeMagicSquare tree = new TreeMagicSquare(4);
		long startTime = System.currentTimeMillis();
		tree.generate();
		long end = System.currentTimeMillis();
		System.out.println("Solutions: " + tree.getCpt());
		System.out.println("Time: " + (end - startTime) / 1000 + "s");
		
	}

}
