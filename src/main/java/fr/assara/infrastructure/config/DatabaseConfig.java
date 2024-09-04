package fr.assara.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "fr.assara.user.repository", "fr.assara.widgets.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConfig {
}
