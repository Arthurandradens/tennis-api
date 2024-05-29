package arthur.nunes.projeto_dio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApiConfig {
        @Value("${spring.application.key}")
        private String apiKey;

    public String getApiKey() {
        return "&APIkey=" + apiKey;
    }
}
