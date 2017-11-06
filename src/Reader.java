import java.util.Scanner;

/**
 * Created by Tintin on 2017. 11. 06..
 * Random thought
 */
public class Reader {
	
	private static Scanner _reader = new Scanner(System.in);
	
	public static void close(){
		_reader.close();
	}
	
	public static NeuralNetwork readArchitecture(){
		String[] input = _reader.nextLine().split(",");
		int N = Integer.parseInt(input[0]);
		
		int[] L = new int[input.length-2];
		for (int i = 1; i < input.length-1; i++) {
			L[i-1] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(input[input.length-1]);
		
		return new NeuralNetwork(N, L, M);
	}
	
	// TODO: refactor to more basic methods
	public static NeuralNetwork readArchitectureAndWeights(){
		// Architecture
		String[] architecture = _reader.nextLine().split(",");
		int N = Integer.parseInt(architecture[0]);
		
		int[] L = new int[architecture.length-2];
		for (int i = 1; i < architecture.length-1; i++) {
			L[i-1] = Integer.parseInt(architecture[i]);
		}
		
		int M = Integer.parseInt(architecture[architecture.length-1]);
		
		// Calculate the size of array (rows)
		int nodeCount = 0;
		for (int i = 0; i < L.length; i++) {
			nodeCount+=L[i];
		}
		nodeCount+=M;
		
		double[][] weightsAndBiases = new double[nodeCount][];
		
		// Weights and biases
		// for every node of every layer get weighsAndBiases
		for (int i = 0; i < nodeCount; i++) {
			String[] weights = _reader.nextLine().split(",");
			weightsAndBiases[i] = new double[weights.length];
			for (int j = 0; j < weights.length; j++) {
				weightsAndBiases[i][j] = Double.parseDouble(weights[j]);
			}
		}
		
		return new NeuralNetwork(N, L, M, weightsAndBiases);
	}
	// TODO: refactor Scanners
	public static double[][] readInputs(){
		// Inputs
		int S = Integer.parseInt(_reader.nextLine());
		double[][] inputs = new double[S][];
		
		for (int i = 0; i < S; i++) {
			String[] _input = _reader.nextLine().split(",");
			inputs[i] = new double[_input.length];
			for (int j = 0; j < _input.length; j++) {
				inputs[i][j] = Double.parseDouble(_input[j]);
			}
		}
		
		return inputs;
	}
	//public static NeuralNetwork readSolutionThreeInput(){}
	//public static NeuralNetwork readSolutionFourInput(){}
	//public static NeuralNetwork readSolutionFiveInput(){}
}
