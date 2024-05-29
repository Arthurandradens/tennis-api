package arthur.nunes.projeto_dio.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @JsonProperty("event_type_key")
    private int eventTypeKey;
    @JsonProperty("event_type_type")
    private String eventTypeType;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEventTypeKey() {
        return eventTypeKey;
    }

    public void setEventTypeKey(int eventTypeKey) {
        this.eventTypeKey = eventTypeKey;
    }

    public String getEventTypeType() {
        return eventTypeType;
    }

    public void setEventTypeType(String eventTypeType) {
        this.eventTypeType = eventTypeType;
    }
}
