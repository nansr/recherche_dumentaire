package Corpus;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

public class Documents{
	private String m_docno, m_fileid, m_first, m_seconde, m_dateline, m_text,m_head, m_byline, m_note, m_document_head, m_document_byline;
	private ArrayList<String> m_heads, m_bylines, stock_doc;
	private String filename;
	private ArrayList<ArrayList<String>> doc;
	
	public Documents(String filename){
		this.m_docno = "";
		this.m_fileid = "";
		this.m_first = "";
		this.m_seconde = "";
		this.m_dateline = "";
		this.m_text = "";
		this.m_head = "";
		this.m_byline = "";
		this.m_note = "";
		this.m_document_head = "";
		this.m_document_byline = "";
		this.m_heads = new ArrayList<String>();
		this.m_bylines = new ArrayList<String>();
		this.stock_doc = new ArrayList<String>();
		doc = new ArrayList<ArrayList<String>>();
		this.filename = filename;
	}
	
	public void lecture_fichier() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse(filename);
			DocumentTraversal traversal = (DocumentTraversal) document;
			NodeIterator iterator = traversal.createNodeIterator(document.getDocumentElement(),NodeFilter.SHOW_ELEMENT,null,true);
		
			for(Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
				if(n.getNodeName().contentEquals("DOC")) {
					NodeList nList = n.getChildNodes();
					this.m_document_head = "";
					this.m_document_byline = "";
					
					for(int i = 0; i < nList.getLength(); i++) {
						Node node = nList.item(i);
						
						if(node.getNodeName().contentEquals("DOCNO")) {
							this.m_docno = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("FILEID")) {
							this.m_fileid = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("FIRST")) {
							this.m_first = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("SECOND")) {
							this.m_seconde = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("HEAD")) {
							this.m_head = node.getTextContent();
							this.m_document_head += this.m_head + "\n";
							this.m_heads.add(this.m_head);
						}
						else if(node.getNodeName().contentEquals("BYLINE")) {
							this.m_byline = node.getTextContent();
							this.m_document_byline += this.m_byline + "\n";
							this.m_bylines.add(this.m_byline);
						}
						else if(node.getNodeName().contentEquals("DATELINE")) {
							this.m_dateline = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("TEXT")) {
							this.m_text = node.getTextContent();
						}
						else if(node.getNodeName().contentEquals("NOTE")) {
							this.m_note = node.getTextContent();
						}
					}
					
					this.doc.add(stock_doc);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void affichage() {
		System.out.println(this.m_docno);
		System.out.println(this.m_fileid);
		System.out.println(this.m_first);
		System.out.println(this.m_seconde);
		
		for(int i = 0 ; i < this.m_heads.size(); i++)
			System.out.println(this.m_heads.get(i));
		
		for(int i = 0 ; i < this.m_bylines.size(); i++)
			System.out.println(this.m_bylines.get(i));
		
		System.out.println(this.m_dateline);
		System.out.println(this.m_text);
		System.out.println(this.m_note);
	}
	
	public String text() {
		return this.m_text;
	}
	
	public void stock_document() {
		this.stock_doc.add(this.m_docno);
		this.stock_doc.add(this.m_fileid);
		this.stock_doc.add(this.m_first);
		this.stock_doc.add(this.m_seconde);
		this.stock_doc.add(this.m_document_head);
		this.stock_doc.add(this.m_document_byline);
		this.stock_doc.add(this.m_dateline);
		this.stock_doc.add(this.m_text);
		this.stock_doc.add(this.m_note);	
	}
	
	public void affichage_corpus() {
		for(int i = 0; i < this.doc.size(); i++) {
			for(int j = 0; j < this.doc.get(i).size(); j++) {
				System.out.println(this.doc.get(i).get(j));
			}
		}
	}
	
	public void affichage_document(int j) {
		for(int i = 0; i < this.doc.get(j).size(); i++)
			System.out.println(this.doc.get(j).get(i));
	}
	
	
	
	
	
	
	
	
}