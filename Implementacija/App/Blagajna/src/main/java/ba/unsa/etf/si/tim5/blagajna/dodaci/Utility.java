package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


//pomocna singleton klasa za smještanje raznih pomocnih funkcija
public class Utility {
	private static Utility instanca = null;

	public static Utility getInstance() {
		if (instanca == null)
			instanca = new Utility();
		return instanca;
	}

	public Utility() {

	}
	
	
	private Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}
	
	public String dajStudijskuGodinu() {
		Date d = new Date();
		String godina;
		if (d.getMonth() < 9)
			godina = String.valueOf((new Date()).getYear() + 1900 - 1)
					+ "/"
					+ String.valueOf(this.addDays(new Date(), 366).getYear() + 1900 - 1);
		else
			godina = String.valueOf((new Date()).getYear() + 1900)
					+ "/"
					+ String.valueOf(this.addDays(new Date(), 366).getYear() + 1900);
		return godina;
	}
	
	public int generisiPassword(){
		//ArrayList<char> slova=
		char[] slova={'a','b','c','d','e','f','g','h','j','k'};
		Random r = new Random( System.currentTimeMillis() );
		int s = new Random().nextInt(slova.length);
		char random = (slova[s]);
	    return 10000000 + r.nextInt(20000)+s;
	
	}
}
