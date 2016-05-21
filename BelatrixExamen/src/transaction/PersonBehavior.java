package transaction;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonBehavior implements Crud<Person>{

	static List<Person> personList = new ArrayList<Person>();
	
	@Override
	public List<Person> read() {
		return personList;
	}

	@Override
	public Person read(int id) {
		return personList.get(id);
	}

	@Override
	public void create(Person person) {
		personList.add(person);
		
	}

	
}
