package nebulus;

import java.io.*;

import com.google.code.chatterbotapi.*;


public class Nebulus {

	public static void main(String[] args) throws Exception {
		
    String grammarPath = new File("C:\\Users\\RobertCyber\\git\\nebulus\\"
    		+ "voce-0.9.1\\lib\\gram\\").toURI().toURL().toString();    
	
    voce.SpeechInterface.init("C:\\Users\\RobertCyber\\git\\nebulus\\voce-0.9.1"
    		+ "\\lib", true, false, grammarPath, "digits");
    
    voce.SpeechInterfaceLars.initLars("C:\\Users\\RobertCyber\\git\\nebulus\\voce-0.9.1"
    		+ "\\lib", true, false, grammarPath, "digits");
			
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	
	File outFile = new File ("C:\\Users\\RobertCyber\\git\\nebulus\\"
			+ "ChatterbotOut.txt");    
	
	ChatterBotFactory factory = new ChatterBotFactory();
	
	ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
	ChatterBot bot2 = factory.create(ChatterBotType.CLEVERBOT);
	
	
	ChatterBotSession botsession1 = bot1.createSession();
	ChatterBotSession botsession2 = bot2.createSession();
	
	try{
		String s = "war games!";
		System.out.println("Seed: war games!");
		while (true){
			//s = console.readLine();
			//s = voce.SpeechInterface.popRecognizedString();
			if (-1 != s.indexOf("quit")){
				voce.SpeechInterface.stopSynthesizing();
			}
			
		else{
			//System.out.println("You said: " + s);
			//Bot1 speaks, it is written to file, then read back
			
			String speak = botsession1.think(s);
	//		String speak = "harry potter is the bomb";
			System.out.println(speak);
			voce.SpeechInterface.synthesize(speak);
			Thread.sleep(3000);
			s = speak;
			
			// speaks, it is written to file, then read back
			
			speak = botsession2.think(s);
			System.out.println(speak);
			voce.SpeechInterfaceLars.synthesize(speak);
			
			Thread.sleep(3000);
			s = speak;
			
		}
		}
		}
	
	catch(java.io.IOException ioe){
		System.out.println("IO Error:" + ioe);
	}
	
	voce.SpeechInterfaceBolinda.destroy();
	voce.SpeechInterfaceLars.destroy();
	System.exit(0);
	
	}
	}	