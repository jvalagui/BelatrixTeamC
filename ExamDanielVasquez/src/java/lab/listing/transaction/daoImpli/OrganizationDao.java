package java.lab.listing.transaction.daoImpli;

import java.lab.listing.model.Organization;
import java.lab.listing.transaction.dao.DaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public class OrganizationDao implements DaoManager<Organization> {

    List<Organization> list = new ArrayList<Organization>();
    @Override
    public List<Organization> read() {
        return list;
    }

    @Override
    public Organization readIf(int id) {
        Organization organization = null;

        for(Organization reg : list){
            if(reg.getOrganizationId() == id){
                organization = reg;
            }
        }
        return organization;
    }

    @Override
    public void create(Organization organization) {

    }

    @Override
    public void update(Organization organization) {

    }

    @Override
    public void delete(int id) {

    }
}
