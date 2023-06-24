package com.knock.bmt.proxy.aggregate.toast.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.knock.bmt.proxy.aggregate.toast.application.port.in.EmailSendUseCase;
import com.knock.bmt.proxy.aggregate.toast.application.port.in.data.EmailSendRequest;
import com.knock.bmt.proxy.support.property.ToastProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmailService implements EmailSendUseCase {

    private final ToastProperties toastProperties;

    @Async
    @Override
    public void emailSend(EmailSendRequest request) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("appKey", toastProperties.getEmail().getAppKey());
        URI uri = UriComponentsBuilder.fromHttpUrl(toastProperties.getEmailSendUrl())
                .build(urlVariables);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-Secret-Key", toastProperties.getEmail().getSecretKey());
        EmailSendRequest request = EmailSendRequest.builder()
                .senderAddress(toastProperties.getEmailSenderAddress())
                .title("스마트문진 관리자 임시 비밀번호 안내")
                .body(getHtmlContent(email, passwd))
                .receiverList(Arrays.asList(ReceiveMailAddr.builder().receiveMailAddr(email).build()))
                .build();

        final HttpEntity<String> entity;
        try {
            entity = new HttpEntity<>(objectMapper.writeValueAsString(request), httpHeaders);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("파싱에 실패하였습니다");
        }
        ResponseEntity<Object> object =  restTemplate.postForEntity(uri, entity, Object.class);
    }

    private String getHtmlContent(String name, String passwd) {
        Context context = new Context();
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        hashMap.put("passwd", passwd);
        context.setVariables(hashMap);
        return thymeleafTemplateMapper.parse("email" + "/" + "email.html", context);
    }
}
