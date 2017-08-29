package projeto;

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 8; i++) {
			acceptanceTest(i);
		}
	}

	private static void acceptanceTest(int i) throws Exception { 
		ArrayList<String> testes = new ArrayList<>();
		testes.add("us" + File.separator + "us" + i + "_test.txt");
		EasyAccept.executeEasyAcceptTests("projeto.Facade", testes);
	}
	
	
}
