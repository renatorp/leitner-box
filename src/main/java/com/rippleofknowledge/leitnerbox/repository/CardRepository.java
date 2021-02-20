package com.rippleofknowledge.leitnerbox.repository;

import com.rippleofknowledge.leitnerbox.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
