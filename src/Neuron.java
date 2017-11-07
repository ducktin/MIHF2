/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */
public class Neuron {
	
	private double _activation;
	private double[] weights;
	private double bias;
	
	public Neuron(){
	
	}
	
	public Neuron(double[] weights, double bias){
		this.weights = weights.clone();
		this.bias = bias;
	}
	
	public void setActivation(double activation){
		this._activation = activation;
	}
	public double getActivation(){
		return _activation;
	}
	public double getLinearOutput(){
		return linear(_activation);
	}
	public double getReLUOutput(){
		return ReLU(_activation);
	}
	
	public void calculateActivation(double[] input){
		double sum = 0.0;
		
		for (int i = 0; i < input.length; i++) {
			sum += input[i]*weights[i];
		}
		sum += bias;
		
		_activation = sum;
	}
	
	private double linear(double x){
		return x;
	}
	
	private double ReLU(double x){
		return Math.max(0, x);
	}
	
	// TODO: rewrite string functions
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
