package transaction;

import java.util.ArrayList;
import java.util.List;

import model.Email;

public class EmailBehavior implements Crud<Email>{
	
	static List<Email> emailList = new ArrayList<Email>();
	@Override
	public List<Email> read() {
		return emailList;
	}
	@Override
	public Email read(int id) {
		return emailList.get(id);
	}
	@Override
	public void create(Email email) {
		emailList.add(email);
		
	}

}
