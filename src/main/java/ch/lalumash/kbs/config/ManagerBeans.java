package ch.lalumash.kbs.config;

import ch.lalumash.kbs.manager.ScreeningManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ManagerBeans {
    @Bean
    public ScreeningManager screeningManager() {
        return new ScreeningManager();
    }
}
