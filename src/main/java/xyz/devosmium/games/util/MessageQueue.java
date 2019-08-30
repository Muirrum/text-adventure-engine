package xyz.devosmium.games.util;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageQueue {
    private static Logger logger = LoggerFactory.getLogger(MessageQueue.class);

    public static void add(String message) {
        //logger.debug("add(" + message + ")");
        System.out.println(message);
    }

    public static String take() {
        String message = null;

        Scanner input = new Scanner(System.in);
        message = input.next();
        return message;
    }
}