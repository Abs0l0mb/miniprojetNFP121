import java.util.ArrayList;
import java.util.List;

public class CLI {
	
	private List<Option> options;
	
	public CLI() {
		this.options = new ArrayList<Option>();
	}
	
	public void ajouterOption(Option o) {
		this.options.add(o);
	}
}
