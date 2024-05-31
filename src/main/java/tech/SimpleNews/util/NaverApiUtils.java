package tech.SimpleNews.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
//@Component
public class NaverApiUtils {

    private final String clientId;
    private final String secretKey;
    private double latitude;

//    @Autowired
    public NaverApiUtils(@Value("${spring.naver.client_id}") String clientId,
                        @Value("${spring.naver.secret_key}") String secretKey) {
        this.clientId = clientId;
        this.secretKey = secretKey;
    }

    public String getRoadAddress(double longitude, double latitude){
        String url = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("coords", longitude + "," + latitude)
            .queryParam("output", "json")
            .queryParam("orders", "roadaddr");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", secretKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        log.info("entity.getBody() : "+ entity.getBody());
        return "testing";
//
//        ResponseEntity<String> response = restTemplate.exchange(
//            uriBuilder.toUriString(),
//            HttpMethod.GET,
//            entity,
//            String.class
//        );
//
//        return response.getBody();
    }
}
