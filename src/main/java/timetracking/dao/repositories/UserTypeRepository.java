package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import timetracking.dao.models.UserType;

public interface UserTypeRepository extends PagingAndSortingRepository<UserType, Long> {
}