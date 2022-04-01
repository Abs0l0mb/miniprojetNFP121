import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CLIClassiqueTest {

	@Test
	void test() {
		Configuration config = CLIClassique.configuration("-K 10 -A .90 -K 20 -P -K 30 -C".split(" "));
		assertEquals(config.toString(), "alpha=0.9, epsilon=-1.0, indice=30, mode=CREUSE");
	}
	
}
