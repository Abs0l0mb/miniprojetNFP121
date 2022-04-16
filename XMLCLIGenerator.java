import java.io.StringWriter;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class XMLCLIGenerator {
	
	public XMLCLIGenerator() {
		
	}
	
	public String generateXML(CLI cli) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		
		document.setXmlStandalone(true);
		
		Element cliElement = document.createElement("cli");
		
		for(int i=0 ; i<cli.getOptions().size() ; i++) {
			Element argumentElement = document.createElement("argument");
			
			NamedNodeMap attributes = argumentElement.getAttributes();
			
			Attr acces = document.createAttribute("acces");
			acces.setValue(cli.getOptions().get(i).getAcces());
			attributes.setNamedItem(acces);
			
			if(cli.getOptions().get(i).getClass().equals(OptionValeur.class)) {
				Attr nb = document.createAttribute("nb");
				nb.setValue("1");
				attributes.setNamedItem(nb);
			}
			
			Text text = document.createTextNode(cli.getOptions().get(i).getDescription());
			argumentElement.appendChild(text);
			cliElement.appendChild(argumentElement);
		}
		
		document.appendChild(cliElement);
		
		DOMSource domSource = new DOMSource(document);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(domSource, result);
		return writer.toString();
	}
	
	public static void main(String[] args) throws Exception {
		XMLCLIGenerator generator = new XMLCLIGenerator();
		
		CLI cli = new CLI();
		
		cli.ajouterOption(new OptionValeur("A", "Valeur de Alpha", new Action(), true));
		cli.ajouterOption(new OptionValeur("I", "Valeur de indice", new Action(), true));
		cli.ajouterOption(new Option("P", "Mode matrice pleine", new Action()));
		cli.ajouterOption(new Option("C", "Mode matrice creuse", new Action()));
				
		System.out.print(generator.generateXML(cli));

	}
}
