package eu.kaluzinski.credit_card.repositories;

import eu.kaluzinski.credit_card.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 6/27/22.
 */
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
