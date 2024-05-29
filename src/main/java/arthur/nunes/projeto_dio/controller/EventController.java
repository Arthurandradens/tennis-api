package arthur.nunes.projeto_dio.controller;

import arthur.nunes.projeto_dio.model.Event;
import arthur.nunes.projeto_dio.service.TennisApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("events")
public class EventController {
    @Autowired
    private TennisApiService apiService;

    @GetMapping
    public String getEvents() throws JsonProcessingException {
        return apiService.getEvents();
    }
    @GetMapping("/{id}")
    public Optional<Event> getEventPerKey(@PathVariable Long id){
        return apiService.getEvent(id);
    }
}
