
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public abstract class Modifier {
	private final String name;
        private final String description;
	private final int value;
        private final int type;

	public Modifier(String n, String desc, int v, int t){
		name = n;
		value = v;
                type = t;
                description = desc;
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
        
        public String getDescription(){
            return description;
        }
}
