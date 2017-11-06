import java.util.Scanner;

/**
 * Created by Tintin on 2017. 11. 06..
 * Random thought
 */
public class Reader {
	
	public static NeuralNetwork readSolutionOneInput(){
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
	// TODO: refactor to more basic methods
	public static NeuralNetwork readSolutionTwoInput(){
		Scanner reader = new Scanner(System.in);
		// Architecture
		String[] input = reader.nextLine().split(",");
		int N = Integer.parseInt(input[0]);
		
		int[] L = new int[input.length-2];
		for (int i = 1; i < input.length-1; i++) {
			L[i-1] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(input[input.length-1]);
		
		// Calculate the arrays size (rows)
		int nodeCount = 0;
		for (int i = 0; i < L.length; i++) {
			nodeCount+=L[i];
		}
		nodeCount+=M;
		
		double[][] weightsAndBiases = new double[nodeCount][];
		
		// Weights and biases
		// for every node of every layer get weighsAndBiases
		for (int i = 0; i < nodeCount; i++) {
			input = reader.nextLine().split(",");
			weightsAndBiases[i] = new double[input.length];
			for (int j = 0; j < input.length; j++) {
				weightsAndBiases[i][j] = Double.parseDouble(input[j]);
			}
		}
		
		reader.close();
		return new NeuralNetwork(N, L, M, weightsAndBiases);
	}
	//public static NeuralNetwork readSolutionThreeInput(){}
	//public static NeuralNetwork readSolutionFourInput(){}
	//public static NeuralNetwork readSolutionFiveInput(){}
}
