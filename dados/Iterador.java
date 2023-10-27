package dados;
import java.util.Iterator;
public abstract interface Iterador {

	public abstract void reset();

	public abstract boolean hasNext();

	public abstract Object next();

}
