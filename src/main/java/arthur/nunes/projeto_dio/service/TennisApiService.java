package arthur.nunes.projeto_dio.service;

import arthur.nunes.projeto_dio.model.EventResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import arthur.nunes.projeto_dio.config.ApiConfig;
import arthur.nunes.projeto_dio.model.Event;
import arthur.nunes.projeto_dio.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class TennisApiService {

    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private ApiConfig config;
    @Autowired
    private EventRepository repository;

    private static final String API_URL = "https://api.api-tennis.com/tennis/?method=";

    public String getEvents() throws JsonProcessingException {
        List<Event> events = (List<Event>) repository.findAll();
        if (events.isEmpty()){
            String url = API_URL + "get_events" + config.getApiKey();
            String jsonResponse =   webClientBuilder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            creatEvents(jsonResponse);
            return jsonResponse;
        }
        return "DataBase already full";

    }

    public void creatEvents(String jsonResponse) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EventResponse eventsResponse = mapper.readValue(jsonResponse, EventResponse.class);
            List<Event> events = eventsResponse.getResult();
            repository.saveAll(events);
            System.out.println("created");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Optional<Event> getEvent(Long id){
       return repository.findById(id);
    }



}
