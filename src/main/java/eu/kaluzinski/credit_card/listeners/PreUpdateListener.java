package eu.kaluzinski.credit_card.listeners;

import eu.kaluzinski.credit_card.services.EncryptionService;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
public class PreUpdateListener extends AbstractEncryptionListener implements PreUpdateEventListener {
    public PreUpdateListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        this.encrypt(preUpdateEvent.getState(), preUpdateEvent.getPersister().getPropertyNames(), preUpdateEvent.getEntity());
        return false;
    }
}
