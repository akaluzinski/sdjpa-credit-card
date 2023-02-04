package eu.kaluzinski.credit_card.listeners;

import eu.kaluzinski.credit_card.services.EncryptionService;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.springframework.stereotype.Component;

@Component
public class PostLoadListener extends AbstractEncryptionListener implements PostLoadEventListener {
    public PostLoadListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public void onPostLoad(PostLoadEvent postLoadEvent) {
        this.decrypt(postLoadEvent.getEntity());
    }
}
