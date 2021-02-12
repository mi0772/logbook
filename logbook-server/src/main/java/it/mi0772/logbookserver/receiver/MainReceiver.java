package it.mi0772.logbookserver.receiver;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MainReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
