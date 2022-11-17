package IO.API;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;

//-------------------------------------------------------------------------------
// IO-API: Write Data-Class into XML file using Java standard XMLEncoder
//-------------------------------------------------------------------------------
public class XmlWriterStandardJava<T> {
	
	public void writeIntoFile(T dataObject, String fileName) {
		FileOutputStream fileOutStream;
		try {
			fileOutStream = new FileOutputStream(fileName);
			
			writeIntoStream(dataObject, fileOutStream);
			  
			  fileOutStream.close();
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
