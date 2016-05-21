package transaction;

import java.util.ArrayList;
import java.util.List;
import model.Organization;

public class OrganizationBehavior implements Crud<Organization>{
	static List<Organization> organizations = new ArrayList<Organization>();

	@Override
	public List<Organization> read() {
		return organizations;
	}

	@Override
	public Organization read(int id) {
		return organizations.get(id);
	}

	@Override
	public void create(Organization organization) {
		organizations.add(organization);
		
	}
}
