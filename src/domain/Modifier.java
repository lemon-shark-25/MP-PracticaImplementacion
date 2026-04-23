
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public abstract class Modifier {
	private final String name;
	private final int value;

	public Modifier(String n, int v){
		name = n;
		value = v;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}	
}
