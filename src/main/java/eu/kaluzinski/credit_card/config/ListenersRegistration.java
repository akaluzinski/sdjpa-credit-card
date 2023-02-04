package eu.kaluzinski.credit_card.config;

import eu.kaluzinski.credit_card.listeners.PostLoadListener;
import eu.kaluzinski.credit_card.listeners.PreInsertListener;
import eu.kaluzinski.credit_card.listeners.PreUpdateListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ListenersRegistration implements BeanPostProcessor {

    private final PostLoadListener postLoadListener;
    private final PreInsertListener preInsertListener;
    private final PreUpdateListener preUpdateListener;

    public ListenersRegistration(PostLoadListener postLoadListener, PreInsertListener preInsertListener, PreUpdateListener preUpdateListener) {
        this.postLoadListener = postLoadListener;
        this.preInsertListener = preInsertListener;
        this.preUpdateListener = preUpdateListener;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LocalContainerEntityManagerFactoryBean) {
            LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = (LocalContainerEntityManagerFactoryBean) bean;
            SessionFactoryImpl sessionFactory = (SessionFactoryImpl) localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
            EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
            registry.appendListeners(EventType.POST_LOAD, this.postLoadListener);
            registry.appendListeners(EventType.PRE_INSERT, this.preInsertListener);
            registry.appendListeners(EventType.PRE_UPDATE, this.preUpdateListener);
        }

        return bean;
    }
}
