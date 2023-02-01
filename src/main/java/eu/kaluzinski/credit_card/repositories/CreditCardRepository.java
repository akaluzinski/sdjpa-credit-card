package eu.kaluzinski.credit_card.repositories;

import eu.kaluzinski.credit_card.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
