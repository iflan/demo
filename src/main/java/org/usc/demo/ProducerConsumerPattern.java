package org.usc.demo;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;

public class ProducerConsumerPattern {

    public static void main(String args[]) {

        // Creating shared object
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();

        // Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        // Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }

}

// Producer Class in java
class Producer implements Runnable {

    private final BlockingQueue<String> sharedQueue;

    public Producer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (sharedQueue.isEmpty()) {
                System.out.println("\r\n == \r\n");
                for (int i = 0; i < 10; i++) {
                    try {
                        String random = RandomStringUtils.randomAlphanumeric(5);
                        System.out.println("Produced: " + random);
                        sharedQueue.put(random);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}

// Consumer Class in Java
class Consumer implements Runnable {

    private final BlockingQueue<String> sharedQueue;

    public Consumer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
