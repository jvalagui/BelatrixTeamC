package java.lab.listing.transaction.daoImpli;

import java.lab.listing.model.Phone;
import java.lab.listing.transaction.dao.DaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public class PhoneDao implements DaoManager<Phone> {

    List<Phone> list = new ArrayList<Phone>();
    @Override
    public List<Phone> read() {
        return list;
    }

    @Override
    public Phone readIf(int id) {
        Phone phone = null;

        for(Phone reg : list){
            if(reg.getPhoneId() == id){
                phone = reg;
            }
        }
        return phone;
    }

    @Override
    public void create(Phone phone) {
        list.add(phone);
    }

    @Override
    public void update(Phone phone) {
        for(Phone reg : list){
            if(reg.getPhoneId() == phone.getPhoneId()){
                list.set(list.indexOf(reg), phone);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(Phone reg : list){
            if(reg.getPhoneId() == id){
                list.remove(reg);
            }
        }
    }
}
