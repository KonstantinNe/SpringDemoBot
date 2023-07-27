package src.main.java.io.proj3ct.SpringDemoBot.config;

import lombok.Data;

@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {

    @Value("${bot.name}")
    String botName;

    @Value("${bot.token}")
    String token;
}
