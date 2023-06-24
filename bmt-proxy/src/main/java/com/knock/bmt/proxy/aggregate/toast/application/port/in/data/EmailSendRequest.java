package com.knock.bmt.proxy.aggregate.toast.application.port.in.data;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class EmailSendRequest {

    private String senderAddress;

    private String title;

    private String body;

    private List<ReceiveMailAddr> receiverList;

    private static class ReceiveMailAddr {

        private String receiveMailAddress;
    }
}
