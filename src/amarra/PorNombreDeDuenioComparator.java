package amarra;

import java.util.Comparator;

public class PorNombreDeDuenioComparator implements Comparator<Yate> {

	@Override
	public int compare(Yate o1, Yate o2) {
		return o1.getDuenio().compareTo(o2.getDuenio());
	}

}
