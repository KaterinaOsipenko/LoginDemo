package dao;

import model.Users;

import javax.persistence.*;
import java.util.List;

public class UserDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager;

    public UserDao () {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveUser(String firstname, String lastname, String username, String password, String role) {
        try {
            Users user = new Users();

            entityManager.getTransaction().begin();

            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        } finally {
            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public boolean isExistUsername(String username) throws NoResultException {
        entityManager.getTransaction().begin();
        Query isExist =  entityManager.createNamedQuery("IS-EXIST");
        isExist.setParameter("username", username);
        List users =  isExist.getResultList();
        entityManager.getTransaction().commit();
        return users.size() != 0;
    }

    public Users getUser(String username) {
        entityManager.getTransaction().begin();
        Query getUser = entityManager.createNamedQuery("IS-EXIST");
        getUser.setParameter("username", username);
        Users user = (Users)getUser.getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    public boolean isValid(String username, String password) {
        entityManager.getTransaction().begin();
        Query checkPassword = entityManager.createNamedQuery("IS-VALID");
        checkPassword.setParameter("username", username);
        String passwordUser = (String)checkPassword.getSingleResult();
        entityManager.getTransaction().commit();
        return passwordUser.equals(password);
    }
}
