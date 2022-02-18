package com.example.workshopmicroservices.springhystrixservice.util;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class SpringEurekaClientWeatherServiceInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("details",
                Collections.singletonMap("description", "This is the Weather service, which is discovery server aware, and this service will Call Weather Microservice, fro weather details, which is again discovery server aware!!! "));
    }
}
