package com.rippleofknowledge.leitnerbox.service;

import com.rippleofknowledge.leitnerbox.entity.Card;
import com.rippleofknowledge.leitnerbox.entity.CardLevel;
import com.rippleofknowledge.leitnerbox.enums.Level;
import com.rippleofknowledge.leitnerbox.enums.Status;
import com.rippleofknowledge.leitnerbox.repository.CardLevelRepository;
import com.rippleofknowledge.leitnerbox.repository.CardRepository;
import com.rippleofknowledge.leitnerbox.util.DateConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;

	private final CardLevelRepository cardLevelRepository;

	private final DateConverter dateConverter;

	public Card createCard(String question, String answer) {
		Card card = cardRepository.save(new Card(question, answer));

		CardLevel cardLevel = new CardLevel(card);
		cardLevel.setLevel(Level.first());
		cardLevel.setDueDate(dateConverter.fromLocalDate(cardLevel.getLevel().dueDate()));
		cardLevelRepository.save(cardLevel);

		return card;
	}

	public Card drawOneCard() {
		Date date = dateConverter.fromLocalDate(LocalDate.now().plusDays(1));
		CardLevel cardLevel = cardLevelRepository.findFirstByDueDateBeforeAndStatusOrderByLastAnswerDate(date, Status.LEARNING);

		if (cardLevel != null) {
			return cardLevel.getCard();
		}

		return null;
	}

	public void succeedQuestion(Long id) {
		CardLevel cardLevel = cardLevelRepository.findByCard_Id(id);
		levelUp(cardLevel);
		cardLevel.setLastAnswerDate(new Date());
		cardLevelRepository.save(cardLevel);
	}

	public void failQuestion(Long id) {
		CardLevel cardLevel = cardLevelRepository.findByCard_Id(id);
		resetLevel(cardLevel);
		cardLevel.setLastAnswerDate(new Date());
		cardLevelRepository.save(cardLevel);
	}

	private void resetLevel(CardLevel cardLevel) {
		Level first = Level.first();
		cardLevel.setLevel(first);
		cardLevel.setDueDate(dateConverter.fromLocalDate(first.dueDate()));
	}

	private void levelUp(CardLevel cardLevel) {
		Level nextLevel = cardLevel.getLevel().next();

		if (nextLevel != null) {
			cardLevel.setLevel(nextLevel);
			cardLevel.setDueDate(dateConverter.fromLocalDate(nextLevel.dueDate()));
		} else {
			cardLevel.setStatus(Status.LEARNED);
		}
	}

	public Card findById(Long id) {
		return cardRepository.findById(id).orElse(null);
	}
}
