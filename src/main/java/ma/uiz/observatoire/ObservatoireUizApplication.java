package ma.uiz.observatoire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableJpaRepositories("ma.uiz.observatoire.repository")
@EntityScan("ma.uiz.observatoire.model")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class ObservatoireUizApplication {
	public static void main(String[] args) {
		SpringApplication.run(ObservatoireUizApplication.class, args);
	}

}
