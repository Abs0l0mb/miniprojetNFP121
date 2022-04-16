import java.lang.reflect.*;
import java.util.*;

public class CLIOutils {
	
	public CLIOutils() {
		
	}
	
	public CLI fromClass(Configuration conf) {
		
		CLI result = new CLI();
		
		for(int i=0 ; i<conf.getClass().getDeclaredFields().length; i++) {
			if(conf.getClass().getDeclaredFields()[i].getClass().getName() != boolean.class.getName()) {
				result.ajouterOption(new Option(conf.getClass().getDeclaredFields()[i].toString().substring(0, 1), "Valeur de " + conf.getClass().getDeclaredFields()[i].toString(), new Action()));
			}
			else {
				result.ajouterOption(new Option(conf.getClass().getDeclaredFields()[i].toString().substring(0, 1).toUpperCase(), "Positionner la valeur de " + conf.getClass().getDeclaredFields()[i].toString() + "à vrai", new Action()));
				result.ajouterOption(new Option(conf.getClass().getDeclaredFields()[i].toString().substring(0, 1).toLowerCase(), "Positionner la valeur de " + conf.getClass().getDeclaredFields()[i].toString() + "à faux", new Action()));
			}
		}
				
		return result;
	}
}