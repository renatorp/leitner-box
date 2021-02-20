package com.rippleofknowledge.leitnerbox.repository;

import com.rippleofknowledge.leitnerbox.entity.CardLevel;
import com.rippleofknowledge.leitnerbox.enums.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardLevelRepository extends CrudRepository<CardLevel, Long> {
	CardLevel findFirstByDueDateBeforeAndStatusOrderByLastAnswerDate(Date date, Status status);

	CardLevel findByCard_Id(Long cardId);
}
