package mythosforge.fable_minds.config.security.auhentication.dto;

public class GroqResponse {
    private String response;

    public GroqResponse(String response) {
        this.response = response;
    }

    public String getResponse() { return response; }
}