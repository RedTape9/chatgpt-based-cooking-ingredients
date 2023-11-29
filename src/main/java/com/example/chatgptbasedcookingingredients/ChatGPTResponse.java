package com.example.chatgptbasedcookingingredients;
import java.util.List;

record ChatGPTResponse(
        List<ChatGPTChoice> choices
) {
    public String text() {
        return choices.get(0).message().content();
    }
}