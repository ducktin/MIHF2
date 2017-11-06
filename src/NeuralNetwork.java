

import java.util.Random;

/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */
public class NeuralNetwork {

	private double[] inputs;
	private Neuron[][] hiddenLayers;
	private Neuron[] outputs;
	
	// N = input size, L = hidden layers, M = output size
	public NeuralNetwork(int N, int[] L, int M) {
		inputs = new double[N];
		hiddenLayers = new Neuron[L.length][];
		for (int i = 0; i < L.length; i++) {
			hiddenLayers[i] = new Neuron[L[i]];
		}
		outputs = new Neuron[M];
	}
	
	public NeuralNetwork(int N, int[] L, int M, double[][] weightsAndBiases) {
		inputs = new double[N];
		hiddenLayers = new Neuron[L.length][];
		for (int i = 0; i < L.length; i++) {
			hiddenLayers[i] = new Neuron[L[i]];
		}
		outputs = new Neuron[M];
		
		int weightsAndBiasesCount = 0;
		// hiddenlayersetup
		for (int i = 0; i < hiddenLayers.length; i++) {
			for (int j = 0; j < hiddenLayers[i].length; j++) {
				double[] weights = weightsAndBiases[weightsAndBiasesCount].clone();
				int last = weightsAndBiases[weightsAndBiasesCount].length-1;
				double bias = weightsAndBiases[weightsAndBiasesCount][last];
				hiddenLayers[i][j] = new Neuron(weights, bias);
				weightsAndBiasesCount++;
			}
		}
		
		// outputsetup
		for (int i = 0; i < outputs.length; i++) {
			double[] weights = weightsAndBiases[weightsAndBiasesCount].clone();
			int last = weightsAndBiases[weightsAndBiasesCount].length-1;
			double bias = weightsAndBiases[weightsAndBiasesCount][last];
			outputs[i] = new Neuron(weights, bias);
			weightsAndBiasesCount++;
		}
		
	}
	
	// Every single neuron will have the same amount of weight/input how much neurons were in the previous layer
	public void initNeurons(double mean, double deviation, double bias){
		Random random = new Random();
		int prevLayerCount = inputs.length;
		for (Neuron[] hiddenLayer : hiddenLayers) {
			for (int i = 0; i < hiddenLayer.length; i++) {
				double[] weights = getGaussians(mean, deviation, prevLayerCount, random);
				hiddenLayer[i] = new Neuron(weights, bias);
			}
			prevLayerCount = hiddenLayer.length;
		}
		for (int i = 0; i < outputs.length; i++) {
			double[] weights = getGaussians(mean, deviation, prevLayerCount, random);
			outputs[i] = new Neuron(weights, bias);
		}
	}
	
	private double[] getGaussians(double mean, double deviation, int count, Random random){
		double[] gaussians = new double[count];
		for (int i = 0; i < count; i++) {
			gaussians[i] = random.nextGaussian() * deviation + mean;
		}
		return gaussians;
	}
	
	public double[] calculateOutput(){
		return new double[outputs.length];
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getArchString());
		stringBuilder.append("\n");
		stringBuilder.append(getWeightsString());
		
		return stringBuilder.toString();
	}
	
	private String getArchString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(inputs.length+",");
		for (Neuron[] hiddenLayer : hiddenLayers) {
			stringBuilder.append(hiddenLayer.length+",");
		}
		stringBuilder.append(outputs.length);
		return stringBuilder.toString();
	}
	
	private String getWeightsString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Neuron[] hiddenLayer : hiddenLayers) {
			for (Neuron neuron : hiddenLayer) {
				stringBuilder.append(neuron.toString()+"\n");
			}
		}
		for (Neuron output : outputs) {
			stringBuilder.append(output.toString()+"\n");
		}
		return stringBuilder.toString();
	}
	
}