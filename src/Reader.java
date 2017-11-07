import java.util.Scanner;

/**
 * Created by Tintin on 2017. 11. 06..
 * Random thought
 */
public class Reader {
	
	private static Scanner _reader = new Scanner(System.in);
	
	public static void close() {
		try {
			_reader.close();
		} catch (Exception e){
		
		}
	}
	
	public static NeuralNetwork readArchitecture() {
		String[] input = _reader.nextLine().split(",");
		int N = Integer.parseInt(input[0]);
		
		int[] L = new int[input.length - 2];
		for (int i = 1; i < input.length - 1; i++) {
			L[i - 1] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(input[input.length - 1]);
		
		return new NeuralNetwork(N, L, M);
	}
	
	public static double[][] readWeights(int layerCount){
		
		double[][] weightsAndBiases = new double[layerCount][];
		
		// Weights and biases
		// for every node of every layer get weighsAndBiases
		for (int i = 0; i < layerCount; i++) {
			String[] weights = _reader.nextLine().split(",");
			weightsAndBiases[i] = new double[weights.length];
			for (int j = 0; j < weights.length; j++) {
				weightsAndBiases[i][j] = Double.parseDouble(weights[j]);
			}
		}
		
		return weightsAndBiases;
	}
	
	public static double[][] readInputs() {
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
	
	// TODO: refactor to array?
	public static TeachingParameter readTeachingParameter(){
		String[] teachingParams = _reader.nextLine().split(",");
		int E = Integer.parseInt(teachingParams[0]);
		double m = Double.parseDouble(teachingParams[1]);
		double R = Double.parseDouble(teachingParams[2]);
		
		return new TeachingParameter(E, m, R);
	}
}
