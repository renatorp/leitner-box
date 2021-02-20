package com.rippleofknowledge.leitnerbox;

import com.rippleofknowledge.leitnerbox.entity.Card;
import com.rippleofknowledge.leitnerbox.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class LeitnerBoxApplicationTests {

	@Autowired
	private CardRepository cardRepository;

	@Test
	void contextLoads() {
		cardRepository.save(new Card("why?", "because.."));
	}

}
