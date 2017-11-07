/**
 * Created by Tintin on 2017. 11. 06..
 * Random thought
 */
public class Program {
	public static void main(String [ ] args){
		System.out.println("NNSolutionOne.main");
		NNSolutionOne.main(args);
		System.out.println("NNSolutionTwo.main");
		NNSolutionTwo.main(args);
		System.out.println("NNSolutionThree.main");
		NNSolutionThree.main(args);
		System.out.println("NNSolutionFour.main");
		NNSolutionFour.main(args);
		System.out.println("NNSolutionFive.main");
		NNSolutionFive.main(args);
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}
