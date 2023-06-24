package com.knock.bmt.proxy.aggregate.toast.application.port.in;

import com.knock.bmt.proxy.aggregate.toast.application.port.in.data.EmailSendRequest;

public interface EmailSendUseCase {

    void emailSend(EmailSendRequest request);
}
