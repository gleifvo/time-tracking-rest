package timetracking.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import timetracking.dao.models.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
}