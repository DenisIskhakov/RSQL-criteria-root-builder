package com.example.demo.service;

import com.example.demo.model.Passport;
import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@AllArgsConstructor
public class CriteriaService {
    private EntityManagerFactory entityManagerFactory;

    public void Greeter() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

//        CriteriaQuery<Person> personCriteria = cb.createQuery(Person.class);
//        Root<Person> personRoot = personCriteria.from(Person.class);
//        personCriteria.select(personRoot); // select * from имяТаблицы
//        em.createQuery(personCriteria)
//                .getResultList()
//                .forEach(System.out::println);

//        CriteriaQuery<Passport> passportCriteria = cb.createQuery(Passport.class);
//        Root<Person> personPassportRoot = passportCriteria.from(Person.class);
//        passportCriteria.select(personPassportRoot.get("firstName"));
//        em.createQuery(passportCriteria)
//                .getResultList()
//                .forEach(System.out::println);

//        CriteriaQuery<Person> personCriteria = cb.createQuery(Person.class);
//        Root<Person> personRoot = personCriteria.from(Person.class);
//        personCriteria.select(personRoot.get("lastName"));
//        em.createQuery(personCriteria)
//                .getResultList()
//                .forEach(System.out::println);

//        CriteriaQuery<Person> passportLikeCriteria = cb.createQuery(Person.class);
//        Root<Person> likePersonRoot = passportLikeCriteria.from(Person.class);
//        passportLikeCriteria.select(likePersonRoot);
//        passportLikeCriteria.where(cb.like(likePersonRoot.get("lastName"), "A%"));
//        em.createQuery(passportLikeCriteria)
//                .getResultList()
//                .forEach(System.out::println);
//
//        CriteriaQuery<Passport> passportCriteria = cb.createQuery(Passport.class);
//        Root<Passport> passportPassportRoot = passportCriteria.from(Passport.class);
//        passportCriteria.select(passportPassportRoot.get("passport"));
//        em.createQuery(passportCriteria)
//                .getResultList()
//                .forEach(System.out::println);
    }
    // QueryDSL or RSQL - оборетка еще выше
    //Это просто criteria с root'om and criteriaBuilder
    public List<Person> findFirstName(String firstName){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Person> personCriteria = cb.createQuery(Person.class);
        Root<Person> personRoot = personCriteria.from(Person.class);
        // select * from [table] where firstName=firstName
        personCriteria.where(cb.equal(personRoot.get("firstName"),firstName));
        return em.createQuery(personCriteria)
                .getResultList();

    }
    public List<Person> findByLike(String s){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Person> passportLikeCriteria = cb.createQuery(Person.class);
        Root<Person> likePersonRoot = passportLikeCriteria.from(Person.class);
        passportLikeCriteria.select(likePersonRoot);
        Predicate predicate = cb.like(likePersonRoot.get("lastName"), "%" + s + "%"); // predicate(условие)
        passportLikeCriteria.where(predicate);
        return em.createQuery(passportLikeCriteria)
                .getResultList();

    }
}
