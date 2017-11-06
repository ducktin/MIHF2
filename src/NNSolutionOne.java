/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// architektúra -> súlyok (0 várható, 0.1 szórás normál) és bias (0)

public class NNSolutionOne {

	public static void main(String [ ] args) {
		
		NeuralNetwork MLP = Reader.readSolutionOneInput();
		MLP.initNeurons(0.0, 0.1, 0.0);
		System.out.println(MLP.toString());
		
	}
}



