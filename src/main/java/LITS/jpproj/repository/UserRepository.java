package LITS.jpproj.repository;

import LITS.jpproj.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByLogin(String login);
}
