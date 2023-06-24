package com.knock.bmt.proxy.support.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "integration.toast")
public class ToastProperties {

    private ToastEmail email;

    private ToastSms sms;

    @Setter
    @Getter
    public static class ToastEmail {

        // 헤더 키 명
        private String headerKey;
        // API 기본 URL
        private String baseUrl;
        // app key
        private String appKey;
        // secret key
        private String secretKey;
        // each-send-path
        private String eachSendPath;

        private EmailSender defaultSender;
    }

    @Setter
    @Getter
    public static class EmailSender {
        private String name;

        private String address;
    }

    @Setter
    @Getter
    public static class ToastSms {

        private String baseUrl;
        // app key
        private String appKey;
        // secret key
        private String secretKey;
        // each-send-path
        private String sendPath;

        private SmsSender defaultSender;
    }

    @Setter
    @Getter
    public static class SmsSender {
        private String phone;
    }

    public String getEmailSendUrl() {
        return email.baseUrl + email.eachSendPath;
    }

    public String getEmailSenderName() { return email.defaultSender.name; }

    public String getEmailSenderAddress() { return email.defaultSender.address; }

    public String getSmsSendUrl() {
        return sms.baseUrl + sms.sendPath;
    }

    public String getSmsSenderName() { return sms.defaultSender.phone; }
}
