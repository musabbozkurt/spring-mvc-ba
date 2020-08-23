package bilgeadam.dao;

import bilgeadam.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> personList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return (List<Person>) currentSession.createQuery("select p from person p").list();
    }

    @Transactional
    public void addPerson(Person person) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(person);
    }

    @Transactional
    public void deletePerson(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(findById(id));
    }

    @Transactional
    public void updatePerson(Person person) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(person);
    }

    @Transactional
    public Person findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (Person) currentSession.get(Person.class, id);
    }
}
