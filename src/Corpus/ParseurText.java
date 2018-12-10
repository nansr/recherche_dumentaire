package Corpus;

import java.util.StringTokenizer;

public class ParseurText {
	private String m_text;
	private Documents documents;
	
	public ParseurText(Documents documents) {
		this.documents = documents;
		this.m_text = this.documents.text();
	}
	
	public void lire_text() {
		StringTokenizer st = new StringTokenizer(this.m_text);
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());			
		}
	}
}
