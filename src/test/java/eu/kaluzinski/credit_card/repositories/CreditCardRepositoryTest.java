package eu.kaluzinski.credit_card.repositories;

import eu.kaluzinski.credit_card.domain.CreditCard;
import eu.kaluzinski.credit_card.services.EncryptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditCardRepositoryTest {

    final String CREDIT_CARD = "4744010848985281";

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Test
    void shouldSaveCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber(CREDIT_CARD);
        creditCard.setCvv("123");
        creditCard.setExpirationDate("12/25");

        CreditCard savedCreditCard = creditCardRepository.saveAndFlush(creditCard);
        CreditCard fetchedCreditCard = creditCardRepository.findById(savedCreditCard.getId()).get();

        assertThat(fetchedCreditCard.getCreditCardNumber()).isEqualTo(CREDIT_CARD);
    }
}
