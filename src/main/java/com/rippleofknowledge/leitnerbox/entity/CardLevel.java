package com.rippleofknowledge.leitnerbox.entity;

import com.rippleofknowledge.leitnerbox.enums.Level;
import com.rippleofknowledge.leitnerbox.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "card_level")
@Data
@NoArgsConstructor
public class CardLevel {

	public CardLevel(Card card) {
		this.card = card;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "id_card")
	@ManyToOne
	private Card card;

	@Column(name = "level")
	@Enumerated(EnumType.STRING)
	private Level level;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "last_answer_date")
	private Date lastAnswerDate;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.LEARNING;
}
