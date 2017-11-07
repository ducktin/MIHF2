/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// hibavisszaterjesztés algo
// parciális derivált

public class NNSolutionThree {
	public static void main(String [ ] args){
		
		NeuralNetwork MLP = Reader.readArchitecture();
		MLP.setWeightsAndBiases(Reader.readWeights(MLP.getNeuronCount()));
		double[][] inputs = Reader.readInputs();
		
		
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}
