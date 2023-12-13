package ru.javapractic.bot.Logic;

import ru.javapractic.bot.AnswerWriter;
import ru.javapractic.bot.MessageHandler;

public class EchoMessageHandler implements MessageHandler {
    @Override
    public void handle(BotRequest request, AnswerWriter writer) {
        // Generate the response based on the user input
        String responseText = "Вот ваше последнее сообщение: " + request.getUserInput();

        // Create a BotResponse object with the response text and the chat ID
        BotResponse response = new BotResponse(request.getChatId(), responseText);

        // Write the response using the AnswerWriter
        writer.writeAnswer(response);
    }
}
