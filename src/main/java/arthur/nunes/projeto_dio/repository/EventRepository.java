package arthur.nunes.projeto_dio.repository;

import arthur.nunes.projeto_dio.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {

}
