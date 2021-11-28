package ru.misha.carCurs.Database;

import ru.misha.carCurs.Domain.Admin.Users.Admin_UserDataAccess;
import ru.misha.carCurs.Domain.User.Info.UserInfoDataAccess;
import ru.misha.carCurs.Domain.User.Registration.UserDataAccess;
import ru.misha.carCurs.Entities.Role;
import ru.misha.carCurs.Entities.User;
import ru.misha.carCurs.Repositories.UserRepository;
import ru.misha.carCurs.Models.RoleCategories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

public class JpaUser implements UserDataAccess, Admin_UserDataAccess, UserInfoDataAccess {
    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    public JpaUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> filter(Long id, String username, String ROLE_USER, String ROLE_ADMIN) {
        if (id==null && username.equals("") && ROLE_USER.equals("") && ROLE_ADMIN.equals("")){
            return getAll();
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Join<User,Role> join = user.join("roles",JoinType.INNER);

        Predicate predicateForId = cb.equal(user.get("id"), id);
        Predicate predicateForUsername = cb.like(user.get("username"), username);
        Predicate predicateForRoleUser = cb.like(join.get("name").as(String.class), RoleCategories.ROLE_USER.name());
        Predicate predicateForRoleAdmin = cb.like(join.get("name").as(String.class),RoleCategories.ROLE_ADMIN.name());

        Predicate fieldPredicate = null;
        Predicate rolePredicate = null;
        Predicate finalePredicate;

        if(id!=null){
            fieldPredicate = cb.and(predicateForId);
        }
        if(!username.equals("")){
            if (fieldPredicate != null) fieldPredicate = cb.and(fieldPredicate,predicateForUsername);
            else fieldPredicate = predicateForUsername;
        }
        if(!ROLE_USER.equals("")){
            rolePredicate = cb.and(predicateForRoleUser);
        }
        if(!ROLE_ADMIN.equals("")){
            if (rolePredicate != null) rolePredicate = cb.or(rolePredicate,predicateForRoleAdmin);
            else rolePredicate = predicateForRoleAdmin;
        }

        if (fieldPredicate==null) finalePredicate = rolePredicate;
        else if (rolePredicate==null) finalePredicate = fieldPredicate;
        else finalePredicate = cb.and(fieldPredicate,rolePredicate);

        criteriaQuery.select(user).where(finalePredicate);
        List<User> users = em.createQuery(criteriaQuery).getResultList();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User deleteById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null){
            userRepository.deleteById(id);
            return user;
        }
        else return null;
    }
}
