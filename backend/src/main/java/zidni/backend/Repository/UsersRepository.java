package zidni.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zidni.backend.model.Users;

public interface UsersRepository extends JpaRepository<zidni.backend.model.Users,Integer> {


@Query(value="select count(*) from users where mail = ?1", nativeQuery = true)
public long countByEmail(String mail);
@Query(value="select * from users where mail = ?1", nativeQuery = true)
public Users findByEmail(String mail);

}
