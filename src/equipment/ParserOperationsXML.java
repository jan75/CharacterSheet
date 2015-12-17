package equipment;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

class ParserOperationsXML {
	
    public static void main(String[] args) {        
        parseString("data/weapons.xml");
    }

    public static String parseString(String path) {		
		Weapon weapon = new Weapon("bla1","bla2","bla3","bla4","bla5","bla6");
		weapon.print();
		/*
		File file = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
		} catch (Exception e) {
			System.out.println("File " + path + " not found!");
		}
		*/
		return path;
	}
}
