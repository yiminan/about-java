package com.example.aboutjava.designpattern.observerpattern.worstcase;

class UserStatus {

    private EmailSender emailSender;
    private SmsSender smsSender; // added

    public void check() {
        Status status = loadStatus();

        if (status.isInactive()) {
            emailSender.sendEmail(status);
            smsSender.sendSms(status); // added
        }
    }

    private Status loadStatus() {
        return null;
    }
}
