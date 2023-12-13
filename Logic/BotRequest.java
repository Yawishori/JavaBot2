package ru.javapractic.bot.Logic;

public class BotRequest {
    public String userInput;
    public Long chatId;
    public BotRequest(Long chatId, String userInput) {
        this.userInput = userInput;
        this.chatId = chatId;
    }

    public Long getChatId() {
        return chatId;
    }
    public String getUserInput() {
        return userInput;
    }
}
