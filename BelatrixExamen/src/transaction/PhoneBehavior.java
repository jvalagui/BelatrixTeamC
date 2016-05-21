package transaction;

import java.util.ArrayList;
import java.util.List;

import model.Phone;

public class PhoneBehavior implements Crud<Phone>{
	
	static List<Phone> phoneList = new ArrayList<Phone>();
	@Override
	public List<Phone> read() {
		// TODO Auto-generated method stub
		return phoneList;
	}

	@Override
	public Phone read(int id) {
		// TODO Auto-generated method stub
		return phoneList.get(id);
	}

	@Override
	public void create(Phone object) {
		// TODO Auto-generated method stub
		
	}

}
