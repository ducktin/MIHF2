/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra -> súlyok (0 várható, 0.1 szórás normál) és bias (0)

public class NNSolutionOne {

	public static void main(String [ ] args) {
		
		NeuralNetwork MLP = Reader.readArchitecture();
		MLP.initNeurons(0.0, 0.1, 0.0);
		System.out.println(MLP.toString());
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}



