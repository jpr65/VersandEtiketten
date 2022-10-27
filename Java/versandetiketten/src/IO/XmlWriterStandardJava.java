package IO;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;

//-------------------------------------------------------------------------------
//IO-Operation: Write Data-Class into XML file using Java standard XMLEncoder
//-------------------------------------------------------------------------------
public class XmlWriterStandardJava<T> {
	
	public void writeIntoFile(T dataObject, String fileName) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			
			writeIntoStream(dataObject, fos);
			  
			  fos.close();
		} catch (Exception ex) {
			System.out.println("Exception FileIO! :" + ex.toString());
		}
		  
	}

	private void writeIntoStream(T dataObject, FileOutputStream fos) {
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.setExceptionListener(new ExceptionListener() {
		          public void exceptionThrown(Exception e) {
		        	  System.out.println("Exception XmlEncode! :" + e.toString());
		          }
		});
		encoder.writeObject(dataObject);
		encoder.close();
	}

}
