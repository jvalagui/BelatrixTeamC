package java.lab.listing.transaction.daoImpli;

import java.lab.listing.model.Email;
import java.lab.listing.transaction.dao.DaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public class EmailDao implements DaoManager<Email> {

    List<Email> list = new ArrayList<Email>();
    @Override
    public List<Email> read() {
        return list;
    }

    @Override
    public Email readIf(int id) {
        Email email = null;

        for(Email reg : list){
            if(reg.getEmailId() == id){
                email = reg;
            }
        }
        return email;
    }

    @Override
    public void create(Email email) {
        list.add(email);
    }

    @Override
    public void update(Email email) {
        for(Email reg : list){
            if(reg.getEmailId() == email.getEmailId()){
                list.set(list.indexOf(reg), email);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(Email reg: list){
            if(reg.getEmailId() == id){
                list.remove(reg);
            }
        }
    }
}
