package com.quique.apifuntion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

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
