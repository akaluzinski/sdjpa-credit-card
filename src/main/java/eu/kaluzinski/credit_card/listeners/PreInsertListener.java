package eu.kaluzinski.credit_card.listeners;

import eu.kaluzinski.credit_card.services.EncryptionService;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Component
public class PreInsertListener extends AbstractEncryptionListener implements PreInsertEventListener {
    public PreInsertListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        this.encrypt(preInsertEvent.getState(), preInsertEvent.getPersister().getPropertyNames(), preInsertEvent.getEntity());
        return false;
    }
}
