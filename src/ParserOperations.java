import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

class ParserOperations {
	
    public static void main(String[] args) {        
        parseString("data/spells.xml");
    }
    
    public static String parseString(String path) {
		File file = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
		} catch (Exception e) {
			//
		}
		//
		System.out.println(path);
		//
		return path;
	}
	
}
