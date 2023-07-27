package src.main.java.io.proj3ct.SpringDemoBot.config.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.main.java.io.proj3ct.SpringDemoBot.config.BotConfig;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot(BotConfig config){
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":

                    startCommandReceived(chatID,update.getMessage().getChat().getFirstName();
                    break;
                default: sendMessage(chatID, "Sorry");
            }
        }

        }

        private void startCommandReceived(long chatId, String name){

        String answer = "Hi," + name + ",nice to meet you!";

        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId,String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(textToSend);

        try {
            execute(message);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
