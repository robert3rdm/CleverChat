package grammarBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GrammarBuilder {

	public static void main(String[] args) throws IOException {
		//Global Vars
		String line;
		String outFile = "C:\\Users\\RobertCyber\\git\\nebulus\\voce-0.9.1\\"
				+ "samples\\recognitionTest\\java\\grammar\\fullGrammar.gram";
		String inFile = "C:\\Users\\RobertCyber\\git\\nebulus\\voce-0.9.1\\"
				+ "vocabulary.txt";
		
		//Open the vocabular file
		BufferedReader Reader = new BufferedReader(new FileReader(inFile));
		
		//Create a new file and open for writing
		BufferedWriter Writer = new BufferedWriter(new FileWriter(outFile));
		
		// read file one line at a time and add words to the grammar
		
        Writer.write("#JSGF V1.0;\n\n/**\n /* JSGJ Grammar File\n /*\n\ngrammar digits;\n\npublic<miscellaneous"
        		+ "> = (quit);\n\npublic <numbers> = (oh | zero | one | two | three |"
        		+ "four | five | six | seven | eight | nine ) * ;\n\npublic <words> = (");
		
		while((line = Reader.readLine()) != null){
			int i = 1;
			i++;
			if(i % 11 == 0){
				Writer.write("\n");
			}
			line = Reader.readLine();
			System.out.println(line);
			Writer.write(line + " | ");
		}
		
		Writer.write(") * ; ");
		Reader.close();
		Writer.close();

}
}
