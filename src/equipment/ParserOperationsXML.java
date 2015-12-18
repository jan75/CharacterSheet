package equipment;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

class ParserOperationsXML {
	
    public static void main(String[] args) {        
        Map<String, Weapon> myMap = parseWeapons("src/data/weapons.xml");
		//
		Weapon test = myMap.get("Club");
		test.print();
    }

	/**
	 * The Method "parseWeapons" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Weapon). A Map is returned.
	 * @param path
	 * @return Map
	 */
    public static Map parseWeapons(String path) {
		//Weapon weapon = new Weapon("Greatsword","10 lbs","5S","1d6 piercing","bla5","bla6");
		// weapon.print();
		Map<String, Weapon> weaponMap = new HashMap<>();
		//
		File file = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(path);
			//
			document.getDocumentElement().normalize(); // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//
			//System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			//System.out.println("----------------------------");
			//
			NodeList nList = document.getElementsByTagName("name");
			//
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				//
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//
					String tmpWeapon = eElement.getAttribute("weaponname");
					String tmpPrice = eElement.getElementsByTagName("price").item(0).getTextContent();
					String tmpDamage = eElement.getElementsByTagName("damage").item(0).getTextContent();
					String tmpWeight = eElement.getElementsByTagName("weight").item(0).getTextContent();
					String tmpGroup = eElement.getElementsByTagName("group").item(0).getTextContent();

					Weapon tmpWeaponObject = new Weapon(tmpWeapon, tmpPrice, tmpDamage, tmpWeight, tmpGroup);
					//tmpWeaponObject.print();
					//
					weaponMap.put(tmpWeapon, tmpWeaponObject);
					//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return weaponMap;
	}
}
