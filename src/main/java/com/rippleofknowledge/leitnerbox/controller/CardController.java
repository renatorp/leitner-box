package com.rippleofknowledge.leitnerbox.controller;

import com.rippleofknowledge.leitnerbox.entity.Card;
import com.rippleofknowledge.leitnerbox.service.CardService;
import com.rippleofknowledge.leitnerbox.vo.CreateCardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@Controller
public class CardController {

	private final CardService cardService;

	@GetMapping
	public String showCard(Model model) {
		Card card = cardService.drawOneCard();
		model.addAttribute("card", card);
		return "index";
	}

	@GetMapping("/show-answer/{id}")
	public String showAnswer(Model model, @PathVariable("id") Long id) {
		Card card = cardService.findById(id);
		model.addAttribute("card", card);
		return "answer";
	}

	@GetMapping("/correct/{id}")
	public String rightAnswer(Model model, @PathVariable("id") Long id) {
		cardService.succeedQuestion(id);
		return "redirect:/";
	}

	@GetMapping("/incorrect/{id}")
	public String wrongAnswer(Model model, @PathVariable("id") Long id) {
		cardService.failQuestion(id);
		return "redirect:/";
	}

	@GetMapping("/create-card")
	public String showViewCreateCard(Model model) {
		model.addAttribute("card", new CreateCardVO());
		return "create-card";
	}

	@PostMapping("/createCard")
	public String createCard(CreateCardVO card, Model model) {
		cardService.createCard(card.getQuestion(), card.getAnswer());
		return showViewCreateCard(model);
	}
}
