/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra, súlyok, bias, bemenet -> kimenet

public class NNSolutionTwo {
	public static void main(String [ ] args){
		NeuralNetwork MLP = Reader.readArchitectureAndWeights();
		double[][] inputs = Reader.readInputs();
		for (double[] input : inputs) {
			MLP.calculateOutput(input);
		}
		
		System.out.println(MLP.toString());
		
		Reader.close();
	}
}
