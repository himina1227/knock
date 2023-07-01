package com.knock.bmt.proxy.aggregate.toast.application.service;

import com.knock.bmt.proxy.aggregate.toast.application.port.in.EmailSendUseCase;
import com.knock.bmt.proxy.aggregate.toast.application.port.in.data.EmailSendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService implements EmailSendUseCase {


    @Override
    public void emailSend(EmailSendRequest request) {

    }
}
