package IO.API;

import java.beans.XMLDecoder;
import java.io.FileInputStream;

//-------------------------------------------------------------------------------
// IO-API: Read Data-Class from XML file using Java standard XMLDecoder
//-------------------------------------------------------------------------------
public class XmlReaderStandardJava<T> {
	
	public T readFromFile(String fileName) {
		FileInputStream fileInputStream;
		T dataObject = null;
		try {
			  fileInputStream = new FileInputStream(fileName);
			  dataObject = readFromStream(fileInputStream);
			  fileInputStream.close();
		} catch (Exception ex) {
			System.out.println("Exception FileIO! :" + ex.toString());
		}
		
		return dataObject;
	}

	@SuppressWarnings("unchecked")
	private T readFromStream(FileInputStream fileInputStream) {
		XMLDecoder decoder = new XMLDecoder(fileInputStream);
		
		T dataObject = null;
		
		try {
			dataObject = (T) decoder.readObject();
		}
		catch (Exception ex) {
			System.out.println("Exception XmlDecode:" + ex.toString());
		}
		finally {
			decoder.close();
		}
	  
	    return dataObject;
	}

}
