package com.heavymaverick.springdemobot.service;

import com.heavymaverick.springdemobot.config.BotConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig botConfig;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            switch (message){
                case "/start":
                    methodReceiveMessage(chatId, update.getMessage().getChat().getFirstName());

            }
        }

    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    private void methodReceiveMessage(long chatId, String name) {
        String answer = "Hello " + name + "!";
    }

    private void sendMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);



    }
}
