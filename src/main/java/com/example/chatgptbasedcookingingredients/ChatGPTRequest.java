package com.example.chatgptbasedcookingingredients;

import java.util.Collections;
import java.util.List;

record ChatGPTRequest(
        String model,
        List<ChatGPTMessage> messages
) {
    ChatGPTRequest(String message) {
        this("gpt-3.5-turbo", Collections.singletonList(new ChatGPTMessage("user", message)));
    }
}