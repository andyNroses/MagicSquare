import java.util.ArrayList;
import java.util.List;

public class Permutations {

	static void permute(List<Integer> arr, int k, ArrayList<int[]> permutations){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1, permutations);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            permutations.add(ListToArray(arr));
        }
    }
	
	public static int[] ListToArray(List<Integer> list) {
		int i = 0;
		int[] array = new int[list.size()];
		for (int x : list) {
			array[i] = x;
			i++;
		}		
		return array;
	}
	
	
	public static ArrayList<int[]> getPermutations(ArrayList<Integer> list) {
		ArrayList<int[]> permutations = new ArrayList<int[]>();
		permute(list, 0, permutations);
		return permutations;
	}
	
}
