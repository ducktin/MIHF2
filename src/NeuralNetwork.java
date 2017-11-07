import java.util.Arrays;
import java.util.Random;

/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

public class NeuralNetwork {
	
	private Neuron[] inputLayer;
	private Neuron[][] hiddenLayers;
	private Neuron[] outputLayer;
	
	// N = input size, L = hidden layers, M = output size
	// Set up arrays
	public NeuralNetwork(int N, int[] L, int M) {
		inputLayer = new Neuron[N];
		hiddenLayers = new Neuron[L.length][];
		for (int i = 0; i < L.length; i++) {
			hiddenLayers[i] = new Neuron[L[i]];
		}
		outputLayer = new Neuron[M];
		initNeurons();
	}
	
	public int getInputCount(){
		return inputLayer.length;
	}
	
	public int getOutputCount(){
		return outputLayer.length;
	}
	
	public int getNeuronCount() {
		int count = 0;
		for (int i = 0; i < hiddenLayers.length; i++) {
			count+=hiddenLayers[i].length;
		}
		count+=outputLayer.length;
		return count;
	}
	
	public void setInputs(double[] input) {
		for (int i = 0; i < input.length; i++) {
			inputLayer[i].setActivation(input[i]);
		}
	}
	
	public double[] getInputs() {
		double[] inputs = new double[inputLayer.length];
		for (int i = 0; i < inputLayer.length; i++) {
			inputs[i] = inputLayer[i].getActivation();
		}
		return inputs;
	}
	
	public double[] getOutputs(){
		double[] outputs = new double[outputLayer.length];
		for (int i = 0; i < outputLayer.length; i++) {
			outputs[i] = outputLayer[i].getLinearOutput();
		}
		
		return outputs;
	}
	
	// Runs the network from input to output
	public void calculateOutput(){
		// In every layer calculate the output of the neurons
		// Then give that output of the layer to the next layer
		// Until only the output layer is left
		double[] nextInput;
		double[] currentInput = getInputs();
		
		for (int i = 0; i < hiddenLayers.length; i++) {
			nextInput = new double[hiddenLayers[i].length];
			for (int j = 0; j < hiddenLayers[i].length; j++) {
				hiddenLayers[i][j].calculateActivation(currentInput);
				
				nextInput[j] = hiddenLayers[i][j].getReLUOutput();
			}
			currentInput = nextInput.clone();
		}
		
		for (int i = 0; i < outputLayer.length; i++) {
			outputLayer[i].calculateActivation(currentInput);
		}
	}
	
	// Sets up the networks weights and biases
	public void setWeightsAndBiases(double[][] weightsAndBiases){
		int currentLayer = 0;
		// hiddenlayersetup
		for (int i = 0; i < hiddenLayers.length; i++) {
			for (int j = 0; j < hiddenLayers[i].length; j++) {
				double[] weights = Arrays.copyOf(weightsAndBiases[currentLayer],
						weightsAndBiases[currentLayer].length-1);
				int last = weightsAndBiases[currentLayer].length-1;
				double bias = weightsAndBiases[currentLayer][last];
				hiddenLayers[i][j] = new Neuron(weights, bias);
				currentLayer++;
			}
		}
		// outputsetup
		for (int i = 0; i < outputLayer.length; i++) {
			double[] weights =  Arrays.copyOf(weightsAndBiases[currentLayer],
					weightsAndBiases[currentLayer].length-1);
			int last = weightsAndBiases[currentLayer].length-1;
			double bias = weightsAndBiases[currentLayer][last];
			outputLayer[i] = new Neuron(weights, bias);
			currentLayer++;
		}
		
	}
	
	public void initNeurons(){
		for (int i = 0; i < inputLayer.length; i++) {
			inputLayer[i] = new Neuron();
		}
		for (int i = 0; i < hiddenLayers.length; i++) {
			for (int j = 0; j < hiddenLayers[i].length; j++) {
				hiddenLayers[i][j] = new Neuron();
			}
		}
		for (int i = 0; i < outputLayer.length; i++) {
			outputLayer[i] = new Neuron();
		}
	}
	// Every single neuron will have the same amount of weight/input how much neurons were in the previous layer
	public void initNeurons(double mean, double deviation, double bias){
		Random random = new Random();
		int prevLayerCount = inputLayer.length;
		for (Neuron[] hiddenLayer : hiddenLayers) {
			for (int i = 0; i < hiddenLayer.length; i++) {
				double[] weights = getGaussians(mean, deviation, prevLayerCount, random);
				hiddenLayer[i] = new Neuron(weights, bias);
			}
			prevLayerCount = hiddenLayer.length;
		}
		for (int i = 0; i < outputLayer.length; i++) {
			double[] weights = getGaussians(mean, deviation, prevLayerCount, random);
			outputLayer[i] = new Neuron(weights, bias);
		}
	}
	
	private double[] getGaussians(double mean, double deviation, int count, Random random){
		double[] gaussians = new double[count];
		for (int i = 0; i < count; i++) {
			gaussians[i] = random.nextGaussian() * deviation + mean;
		}
		return gaussians;
	}
	
	// TODO: rewrite string functions
	
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
		
		stringBuilder.append(inputLayer.length+",");
		for (Neuron[] hiddenLayer : hiddenLayers) {
			stringBuilder.append(hiddenLayer.length+",");
		}
		stringBuilder.append(outputLayer.length);
		return stringBuilder.toString();
	}
	
	private String getWeightsString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Neuron[] hiddenLayer : hiddenLayers) {
			for (Neuron neuron : hiddenLayer) {
				stringBuilder.append(neuron.toString()+"\n");
			}
		}
		for (Neuron output : outputLayer) {
			stringBuilder.append(output.toString()+"\n");
		}
		return stringBuilder.toString();
	}
	
}