
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public abstract class Modifier {
	private final String name;
	private final int value;
        private final int type;

	public Modifier(String n, int v, int t){
		name = n;
		value = v;
                type = t;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}	
        
        public int getType(){
            return type;
        }
}
