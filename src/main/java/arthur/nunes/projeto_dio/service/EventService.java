package arthur.nunes.projeto_dio.service;

import arthur.nunes.projeto_dio.model.Event;
import arthur.nunes.projeto_dio.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;


    public Iterable<Event> getAll(){
        return repository.findAll();
    }

    public void create(Event event){
        repository.save(event);
    }

}
