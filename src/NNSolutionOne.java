import java.util.Scanner;

/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra -> súlyok (0 várható, 0.1 szórás normál) és bias (0)
// TODO: Add main

public class NNSolutionOne {

	public static void main(String [ ] args){
		
		NeuralNetwork MLP = getInput();
		MLP.initNeurons(0.0, 0.1, 0.0);
		
		System.out.println(MLP.toString());
	}
	
	
	private static NeuralNetwork getInput(){
		Scanner reader = new Scanner(System.in);
		String[] input = reader.nextLine().split(",");
		int N = Integer.parseInt(input[0]);
		
		int[] L = new int[input.length-2];
		for (int i = 1; i < input.length-1; i++) {
			L[i-1] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(input[input.length-1]);
		
		reader.close();
		return new NeuralNetwork(N, L, M);
	}
}



