package ru.javapractic.bot;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javapractic.bot.Logic.BotRequest;

public interface InputReader {
    BotRequest getUserInput(Update update);
}
