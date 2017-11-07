/**
 * Created by Tintin on 2017. 11. 05..
 * Random thought
 */

// tanítás és validáció

public class NNSolutionFour {
	public static void main(String [ ] args){
		
		TeachingParameter teachingParameter = Reader.readTeachingParameter();
		
		if(!(args.length>0 && args[0].equals("development"))){
			Reader.close();
		}
	}
}
