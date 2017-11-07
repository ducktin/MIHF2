/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra, súlyok, bias, bemenet -> kimenet

public class NNSolutionTwo {
	public static void main(String [ ] args){
		
		NeuralNetwork MLP = Reader.readArchitectureAndWeights();
		double[][] inputs = Reader.readInputs();
		
		double[][] output = new double[inputs.length][];
		for (int i = 0; i < inputs.length; i++)  {
			output[i] = MLP.calculateOutput(inputs[i]);
		}
		
		//System.out.print(MLP.toString());
		System.out.println(inputs.length);
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j]);
				if (j != output[i].length-1)
					System.out.print(",");
			}
			System.out.println();
		}
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}
