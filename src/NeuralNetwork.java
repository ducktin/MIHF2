import java.util.Arrays;
import java.util.Random;

/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// TODO: refactor input layer
public class NeuralNetwork {
	
	private int inputCount;
	private Neuron[][] hiddenLayers;
	private Neuron[] outputs;
	
	public int getInputCount(){
		return inputCount;
	}
	
	public int getOutputCount(){
		return outputs.length;
	}
	
	// N = input size, L = hidden layers, M = output size
	public NeuralNetwork(int N, int[] L, int M) {
		inputCount = N;
		hiddenLayers = new Neuron[L.length][];
		for (int i = 0; i < L.length; i++) {
			hiddenLayers[i] = new Neuron[L[i]];
		}
		outputs = new Neuron[M];
	}
	
	public NeuralNetwork(int N, int[] L, int M, double[][] weightsAndBiases) {
		this(N,L,M);
		
		int weightsAndBiasesCount = 0;
		// hiddenlayersetup
		for (int i = 0; i < hiddenLayers.length; i++) {
			for (int j = 0; j < hiddenLayers[i].length; j++) {
				double[] weights = Arrays.copyOf(weightsAndBiases[weightsAndBiasesCount],
						weightsAndBiases[weightsAndBiasesCount].length-1);
				int last = weightsAndBiases[weightsAndBiasesCount].length-1;
				double bias = weightsAndBiases[weightsAndBiasesCount][last];
				hiddenLayers[i][j] = new Neuron(weights, bias);
				weightsAndBiasesCount++;
			}
		}
		
		// outputsetup
		for (int i = 0; i < outputs.length; i++) {
			double[] weights =  Arrays.copyOf(weightsAndBiases[weightsAndBiasesCount],
					weightsAndBiases[weightsAndBiasesCount].length-1);
			int last = weightsAndBiases[weightsAndBiasesCount].length-1;
			double bias = weightsAndBiases[weightsAndBiasesCount][last];
			outputs[i] = new Neuron(weights, bias);
			weightsAndBiasesCount++;
		}
		
	}
	
	// Every single neuron will have the same amount of weight/input how much neurons were in the previous layer
	public void initNeurons(double mean, double deviation, double bias){
		Random random = new Random();
		int prevLayerCount = inputCount;
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
	
	public double[] calculateOutput(double[] input){
		double[] output = new double[outputs.length];
		
		// In every layer calculate the output of the neurons
		// Then give that output of the layer to the next layer
		// Until only the output layer is left
		double[] nextInput;
		double[] currentInput = input.clone();
		for (Neuron[] hiddenLayer : hiddenLayers) {
			nextInput = new double[hiddenLayer.length];
			for (int i = 0; i < hiddenLayer.length; i++) {
				nextInput[i] = hiddenLayer[i].calculateReLUOutput(currentInput);
			}
			currentInput = nextInput.clone();
		}
		for (int i = 0; i < outputs.length; i++) {
			output[i] = outputs[i].calculateLinearOutput(currentInput);
		}
		
		return output;
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
		
		stringBuilder.append(inputCount+",");
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