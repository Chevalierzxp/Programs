/* Xuanpu Zhang
 * 10/16/2017
 * chevalierpg@brandeis.edu
 * create a random writer
 * no bugs
 */
import java.io.*;

public class RandomWriter {

    public static void main(String[] args) throws IOException {
    		RandomWriter randomWriter = new RandomWriter();
    		//check parameters number,should be 3 or 4
            randomWriter.checkParams(args);
            //seed length can't be negative
            int k = randomWriter.getNonNegativeInt(args[0]);
            //output string can't be negative
            int length = randomWriter.getNonNegativeInt(args[1]);
            //read input file
            String sourceFileString = randomWriter.getSource(args[2]);
            //generate output file
            String str2 = args[3];
            if(args.length == 4){
            	randomWriter.generateText(k, length, sourceFileString, randomWriter.getOutput(str2));
            }else if(args.length == 5){
            	randomWriter.generateText(k, length, sourceFileString, randomWriter.getOutput(str2),args[4]);
            }
            
    }

    public void checkParams(String[] params){
        if (params.length < 4) {
        	//check if the writer input the correct 
        	//if not, throw an exception
            System.out.println("Missing parameter! Please input seedlength filelength inputfile outputfile");
            throw new IllegalArgumentException();
        }
    }

    public int getNonNegativeInt(String paramString){
    	//check length and k if they are positive
        	int i = new Integer(paramString).intValue();
        	if(i<0) {
        		throw new IllegalArgumentException();
        	}
        	return i;
    }

    public String getSource(String paramString) throws IOException{
    	//read the file and put every words in the file in a char list
        	File localFile = new File(paramString);
            int i = (int)localFile.length();
            FileReader localFileReader = new FileReader(localFile);
            char[] arrayOfChar = new char[i];
            localFileReader.read(arrayOfChar);
            localFileReader.close();
            return new String(arrayOfChar);
       
    }

    public void generateText(int paramInt1, int paramInt2, String paramString, OutputStream paramOutputStream) throws IOException{
            CharGenerator localCharGenerator = new CharGenerator(paramString, paramInt1);
            while (paramInt2 > 0) {
                int i = localCharGenerator.getNextChar();
                if (i < 0) {
                    localCharGenerator = new CharGenerator(paramString, paramInt1);
                }
                else {
                    paramOutputStream.write(i);
                    paramInt2--;
                }
            }
            paramOutputStream.close();
    }
    
    public void generateText(int paramInt1, int paramInt2, String paramString, OutputStream paramOutputStream, String myRandomSeed) throws IOException{
        CharGenerator localCharGenerator = new CharGenerator(paramString, paramInt1, myRandomSeed);
        while (paramInt2 > 0) {
            int i = localCharGenerator.getNextChar();
            if (i < 0) {
                localCharGenerator = new CharGenerator(paramString, paramInt1);
            }
            else {
                paramOutputStream.write(i);
                paramInt2--;
            }
        }
        paramOutputStream.close();
}

    //return 
    public FileOutputStream getOutput(String paramString) throws FileNotFoundException{
       return new FileOutputStream(paramString);
    }
}
