package ru.javapractic.bot.Logic;

public class BotResponse {
    public String response;
    public Long chatId;
    public BotResponse(Long chatId, String response) {
        this.response = response;
        this.chatId = chatId;
    }
    public Long getChatId(){
        return chatId;
    }
    public String getResponse() {
        return response;
    }
}
