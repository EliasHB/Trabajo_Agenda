
package trabajo_.agenda;

import java.util.Comparator;

public class OrderByName implements Comparator<Personaje> {

    @Override
    public int compare(Personaje o1, Personaje o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
