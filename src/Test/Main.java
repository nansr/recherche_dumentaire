package Test;

import Corpus.Documents;

public class Main {
	public static void main(String[] args) {
		Documents doc = new Documents("/home/etudiant/M1/recherche_doc/projet/corpus/AP891216.xml");
		doc.lecture_fichier();
		doc.affichage();
	}
}
