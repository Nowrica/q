package com.example.demo.application.port.in;

import com.example.demo.domain.User;

public interface WriteNoteUseCase {

    void write(RequestNote requestNote, User.Id userId);
}
