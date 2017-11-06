/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */
public class Neuron {
	
	private double[] weights;
	private double bias;
	
	public Neuron(int i){
		weights = new double[i];
	}
	
	public Neuron(double[] weights, double bias){
		this.weights = weights.clone();
		this.bias = bias;
	}
	
	public double calculateOutput(){
		return 0.0;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (double weight : weights) {
			stringBuilder.append(weight + ",");
		}
		stringBuilder.append(bias);
		
		return stringBuilder.toString();
	}
}
