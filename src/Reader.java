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
	
	public static void readSolutionTwoInput(){
	
	}
	//public static NeuralNetwork readSolutionThreeInput(){}
	//public static NeuralNetwork readSolutionFourInput(){}
	//public static NeuralNetwork readSolutionFiveInput(){}
}
