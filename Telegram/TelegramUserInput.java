package ru.javapractic.bot.Telegram;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javapractic.bot.InputReader;
import ru.javapractic.bot.Logic.BotRequest;

public class TelegramUserInput implements InputReader {
    @Override
    public BotRequest getUserInput(Update update){
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String textMessage = message.getText();
        return new BotRequest(chatId, textMessage);
    }
}
