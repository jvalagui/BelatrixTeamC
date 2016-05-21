package transaction;

import java.util.ArrayList;
import java.util.List;

import model.Country;

public class CountryBehavior implements Crud<Country>{
	static List<Country> countryList = new ArrayList<Country>();

	@Override
	public List<Country> read() {
		return countryList;
	}

	@Override
	public Country read(int id) {
		return countryList.get(id);
	}

	@Override
	public void create(Country object) {
		// TODO Auto-generated method stub
		
	}
	
	
}
