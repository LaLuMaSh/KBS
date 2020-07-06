package ch.lalumash.kbs.config;

import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.datastorage.MockMemoryDataProvider;
import ch.lalumash.kbs.manager.KinoManager;
import ch.lalumash.kbs.manager.ScreeningManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ManagerBeans {
    @Bean
    public IDataProvider iDataProvider() {
        return new MockMemoryDataProvider();
    }
    @Bean
    @Autowired
    public ScreeningManager screeningManager(IDataProvider dataProvider) {
        return new ScreeningManager(dataProvider);
    }
    @Bean
    @Autowired
    public KinoManager kinoManager(IDataProvider dataProvider) {
        return new KinoManager(dataProvider);
    }
}
