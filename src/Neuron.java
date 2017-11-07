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
		double sum = 0.0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i]*weights[i];
		}
		sum += bias;
		
		return linear(sum);
	}
	
	public double calculateReLUOutput(double[] input){
		double sum = 0.0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i]*weights[i];
		}
		// Have to be bigger then the bias to activate
		sum += bias;
		
		return ReLU(sum);
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
