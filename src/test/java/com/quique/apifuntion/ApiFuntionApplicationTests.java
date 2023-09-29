package com.quique.apifuntion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@SpringBootTest
@AutoConfigureWebTestClient
class ApiFuntionApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

	@Test
	public void testMessage() {
		MyController controller = new MyController();

		StepVerifier.create(controller.message())
				.expectNext("Hello Quique")
				.expectComplete()
				.verify();
	}

    @Test
    public void testGreeting() {
        webTestClient.get()
                .uri("/greeting")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Hello ncnr , Good day ");
    }

}
