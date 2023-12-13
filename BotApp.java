package ru.javapractic.bot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.javapractic.bot.Logic.EchoMessageHandler;
import ru.javapractic.bot.Telegram.BOT;

public class BotApp {
    public static void main(String[] args) {
        MessageHandler messageHandler = new EchoMessageHandler();
        BOT bot = new BOT();
        bot.handler = messageHandler;
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
