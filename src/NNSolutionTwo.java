/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra, súlyok, bias, bemenet -> kimenet

public class NNSolutionTwo {
	
	public static void main(String [ ] args){
		
		// Set up the network
		NeuralNetwork MLP = Reader.readArchitecture();
		MLP.setWeightsAndBiases(Reader.readWeights(MLP.getNeuronCount()));
		
		double[][] inputs = Reader.readInputs();
		double[][] outputs = new double[inputs.length][];
		
		// Calculate the outputs based on the inputs
		// Load input into input layer
		// Calculate the output inside the network
		// Get back the output layer information
		for (int i = 0; i < inputs.length; i++)  {
			MLP.setInputs(inputs[i]);
			MLP.calculateOutput();
			outputs[i] = MLP.getOutputs();
		}
		
		// Print the outputCount and output calculated previously
		// TODO: maybe different function
		System.out.println(inputs.length);
		for (int i = 0; i < outputs.length; i++) {
			for (int j = 0; j < outputs[i].length; j++) {
				System.out.print(outputs[i][j]);
				if (j != outputs[i].length-1)
					System.out.print(",");
			}
			System.out.println();
		}
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}
