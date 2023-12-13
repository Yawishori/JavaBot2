package ru.javapractic.bot.Telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.javapractic.bot.AnswerWriter;
import ru.javapractic.bot.InputReader;
import ru.javapractic.bot.Logic.BotRequest;
import ru.javapractic.bot.Logic.BotResponse;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javapractic.bot.MessageHandler;

public class BOT extends TelegramLongPollingBot implements AnswerWriter {
    public BOT() {
        super(BotConfig.BOT_TOKEN);
    }
    public InputReader userInput = new TelegramUserInput();
    public MessageHandler handler;
    @Override
    public String getBotUsername() {
        return BotConfig.BOT_NAME;
    }

    public void writeAnswer(BotResponse response) {
        SendMessage sm = SendMessage.builder()
                .chatId(response.getChatId().toString())
                .text(response.getResponse()).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        BotRequest request = userInput.getUserInput(update);
        if (handler != null) {
            handler.handle(request, this);
        }
    }
}
