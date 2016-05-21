package transaction;

import java.util.ArrayList;
import java.util.List;

import model.PersonCountry;

public class PersonCountryBehavior implements Crud<PersonCountry>{
	static List<PersonCountry> listPersonCountry = new ArrayList<PersonCountry>();

	@Override
	public List<PersonCountry> read() {
		return listPersonCountry;
	}

	@Override
	public PersonCountry read(int id) {
		return listPersonCountry.get(id);
	}

	@Override
	public void create(PersonCountry object) {
		listPersonCountry.add(object);
		
	}
	
	
}
