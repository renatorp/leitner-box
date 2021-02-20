package com.rippleofknowledge.leitnerbox.enums;

import lombok.Getter;

import java.time.LocalDate;

public enum Level {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8);

	@Getter
	private final Integer days;

	Level(Integer days) {
		this.days = days;
	}

	public Level next() {
		if (this.ordinal() + 1 < Level.values().length) {
			return Level.values()[this.ordinal()+1];
		}
		return null;
	}

	public LocalDate dueDate() {
		return LocalDate.now().plusDays(getDays() -1);
	}

	public static Level first() {
		return Level.ONE;
	}
}
