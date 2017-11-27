package mm.androidservice.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import mm.androidservice.AndroidIOManager;
import mm.androidservice.ErrorModel;


public class WordToPDF {
	
	



//	    public static void main(String[] args) {
//	    	WordToPDF cwoWord = new WordToPDF();
//	        cwoWord.ConvertToPDF("D:/Test.docx", "D:/Test.pdf");
//	    }

	    public static void ConvertToPDF(File wordDoc, File pdfDoc) throws IOException{
	    	InputStream doc = null;      
            OutputStream out = null;
	    	try {
	    	
	             doc = new FileInputStream(wordDoc);      
	             out = new FileOutputStream(pdfDoc); 
	            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(doc);
	        
					Docx4J.toPDF(wordMLPackage, out);
				} catch (Docx4JException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					doc.close();
		        	out.close();
				}
	         
	        	
	    }
	

}
