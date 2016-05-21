package transaction;

import java.util.ArrayList;
import java.util.List;

import model.Operator;

public class OperatorBehavior implements Crud<Operator>{

	static List<Operator> operatorList = new ArrayList<Operator>();
	
	@Override
	public List<Operator> read() {
		return operatorList;
	}

	@Override
	public Operator read(int id) {
		return operatorList.get(id);
	}

	@Override
	public void create(Operator object) {
		operatorList.add(object);
		
	}

}
