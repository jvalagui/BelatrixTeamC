package java.lab.listing.transaction.daoImpli;

import java.lab.listing.model.Person;
import java.lab.listing.transaction.dao.DaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public class PersonDao implements DaoManager<Person> {

    List<Person> list = new ArrayList<Person>();

    @Override
    public List<Person> read() {
        return list;
    }

    @Override
    public Person readIf(int id) {
        Person person = null;

        for(Person reg : list){
            if(reg.getPersonId() == id){
                person = reg;
            }
        }
        return person;
    }

    @Override
    public void create(Person person) {

        list.add(person);
    }

    @Override
    public void update(Person person) {
        for(Person reg : list){
            if(reg.getPersonId() == person.getPersonId()){
                list.set(list.indexOf(reg), person);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(Person reg : list){
            if(reg.getPersonId() == id){
                list.remove(reg);
            }
        }
    }
}
