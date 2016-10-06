import java.util.ArrayList;

public class OptimizedMagicSquare extends MagicSquare {

	public OptimizedMagicSquare(int n) {
		super(n);
	}

	public boolean isMagic(int[][] m) {
		int sumColumn = 0;
        int sumDiagonalLeft = 0;
        int sumDiagonalRight = 0;

        boolean[] seen = new boolean[17];


        for (int i = 0; i < m.length; i++) {
            sumColumn = 0;
            for (int j = 0; j < m.length; j++) {
                if(seen[m[i][j]]) return false;
                else {
                    seen[m[i][j]] = true;
                }
                sumColumn = sumColumn + m[j][i];
                if(i == j) {
                    sumDiagonalLeft = sumDiagonalLeft + m[i][j];
                }
                if(j == m.length - 1 - i) {
                    sumDiagonalRight = sumDiagonalRight + m[i][j];
                }
            }
            if (sumColumn != 34) {
                return false;
            }
        }

        if(sumDiagonalLeft != 34 || sumDiagonalRight != 34) {
            return false;
        }

        return true;
	}

	private ArrayList<int[]> generateAllSolutions(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> generatedSolutions = this.generateSolutions(list);
		ArrayList<int[]> allSolutions = new ArrayList<int[]>();
		for (ArrayList<Integer> solution : generatedSolutions) {
			allSolutions.addAll(Permutations.getPermutations(solution));
		}
		return allSolutions;
	}

	private ArrayList<ArrayList<Integer>> generateSolutions(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
		int i1 = 0, i2 = 1, i3 = 2, i4 = 3;
		int sum;
		while (i1 != arr.size() - 5) {
			sum = arr.get(i1) + arr.get(i2) + arr.get(i3) + arr.get(i4);
			if (sum == 34) {
				ArrayList<Integer> sols = new ArrayList<Integer>();
				sols.add(arr.get(i1));
				sols.add(arr.get(i2));
				sols.add(arr.get(i3));
				sols.add(arr.get(i4));
				solutions.add(sols);
				// System.out.println(arr.get(i1) + " " + arr.get(i2) + " " +
				// arr.get(i3) + " " + arr.get(i4));
			}

			if (i4 != arr.size() - 1) {
				i4++;
			}

			else {
				if (i3 + 2 < 16) {
					i4 = i3 + 2;
					i3++;
				}

				else {
					i3 = i2 + 2;
					if (i2 != arr.size() - 3) {
						i2++;
					}

					else {
						i1++;
						i2 = i1 + 1;
						i3 = i2 + 1;
						i4 = i3 + 1;
					}
				}
			}
		}

		return solutions;
	}

	public void generate() {
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		for (int i = 1; i < 17; i++) {
			li.add(i);
		}
		
		int cpt = 0;
		
		ArrayList<int[]> arr = this.generateAllSolutions(li);
				
		int i1=0,i2=1,i3=2,i4=3;
        int[][] tab = new int[4][4];

        while(i1 != arr.size()-5) {
        	
            tab[0] = arr.get(i1);
            tab[1] = arr.get(i2);
            tab[2] = arr.get(i3);
            tab[3] = arr.get(i4);

            if(isMagic(tab)){
                cpt++;
                System.out.println(cpt);
            }

            if(i4 != arr.size()-1) {
                i4++;
            }

            else {
                if(i3 + 2 < arr.size()) {
                    i4 = i3 + 2;
                    i3++;
                }


                else {
                    i3 = i2 + 2;
                    if(i2 != arr.size()-3) {
                        i2++;
                    }


                    else {
                        i1++;
                        i2 = i1 + 1;
                        i3 = i2 + 1;
                        i4 = i3 + 1;
                    }
                }
            }
        }
	}

}
