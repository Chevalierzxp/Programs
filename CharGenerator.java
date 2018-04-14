/* Xuanpu Zhang
 * 10/16/2017
 * chevalierpg@brandeis.edu
 * generate a char generator class
 * no bugs
 */
import java.util.*;

public class CharGenerator {
    private String source;
    private String seed;
    private int Length;
    private Random random;

    public CharGenerator(String paramString, int paramInt){
    		source = paramString;
            Length = paramInt;
            random = new Random();
            //get the position L-K
            int position = paramString.length() - paramInt;
            int i = random.nextInt(position);
            seed = paramString.substring(i, paramInt + i);
    }
    
    public CharGenerator(String paramString, int paramInt, String myRandomSeed){
			source = paramString;
			Length = paramInt;
			random = new Random(new Integer(myRandomSeed).intValue());
			//get position L-K
			int position = paramString.length() - paramInt;
        	int i = random.nextInt(position);
        	seed = paramString.substring(i, paramInt + i);
    }


    public int getNextChar(){
    	//implement the random writer
        ArrayList<Character> localArrayList = new ArrayList<Character>();
        int i = -1;
        while ((i = source.indexOf(seed, i + 1)) >= 0) {
            if (i + Length < source.length()) {
                localArrayList.add(new Character(source.charAt(i + Length)));
            }
        }
        if (localArrayList.size() == 0) {
        	return -1;
        } 
        int j = random.nextInt(localArrayList.size());
        char c = ((Character)localArrayList.get(j)).charValue();
        seed += c;
        seed = seed.substring(1);
        return c;
    }
}
