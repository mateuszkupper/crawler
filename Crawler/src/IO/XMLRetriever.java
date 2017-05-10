package IO;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLRetriever {

	public static ConnectionDetails retrieveDBDetails() throws Exception {
		Document doc = loadXMLFile();
		NodeList nList = doc.getElementsByTagName("DB");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		String url = eElement.getElementsByTagName("url").item(0).getTextContent();
		String pass = eElement.getElementsByTagName("password").item(0).getTextContent();
		String user = eElement.getElementsByTagName("user").item(0).getTextContent();
		return new ConnectionDetails(url, user, pass);
	}

	public static String getQuery(String name) throws Exception {
		Document doc = loadXMLFile();
		NodeList nList = doc.getElementsByTagName("query");
		for (int i = 0; i < nList.getLength(); i++) {
			NodeList nNode = (NodeList) nList.item(i);
			Element eElement = (Element) nNode;
			if(eElement.getElementsByTagName("name").item(0).getTextContent().equals(name)) {
				String a = eElement.getElementsByTagName("stmt").item(0).getTextContent();
				return eElement.getElementsByTagName("stmt").item(0).getTextContent();
			}
		}
		throw new Exception("No query found!");
	}
	
	private static Document loadXMLFile() throws Exception {
		try {
			File fXmlFile = new File("bin/Config/Config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		throw new Exception("Could not parse XML!");
	}
}
