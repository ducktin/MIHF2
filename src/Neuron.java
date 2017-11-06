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
	// clone does work
	public Neuron(double[] weights, double bias){
		this.weights = weights.clone();
		this.bias = bias;
	}
	
	public double calculateLinearOutput(double[] input){
		
		return linear(1);
	}
	
	public double calculateReLUOutput(double[] input){
		
		return ReLU(1);
	}
	
	private double linear(double x){
		return x;
	}
	
	private double ReLU(double x){
		return Math.max(0, x);
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
