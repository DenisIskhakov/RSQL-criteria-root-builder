package com.example.demo.service;

import com.example.demo.model.Passport;
import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
//        personCriteria.select(personRoot);
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

        CriteriaQuery<Person> passportLikeCriteria = cb.createQuery(Person.class);
        Root<Person> likePersonRoot = passportLikeCriteria.from(Person.class);
        passportLikeCriteria.select(likePersonRoot);
        passportLikeCriteria.where(cb.like(likePersonRoot.get("lastName"), "A%"));
        em.createQuery(passportLikeCriteria)
                .getResultList()
                .forEach(System.out::println);
//
//        CriteriaQuery<Passport> passportCriteria = cb.createQuery(Passport.class);
//        Root<Passport> passportPassportRoot = passportCriteria.from(Passport.class);
//        passportCriteria.select(passportPassportRoot.get("passport"));
//        em.createQuery(passportCriteria)
//                .getResultList()
//                .forEach(System.out::println);
    }
}
