package com.rippleofknowledge.leitnerbox.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
public class Card {

	public Card(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

}
