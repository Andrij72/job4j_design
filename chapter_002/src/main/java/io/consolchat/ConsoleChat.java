package io.consolchat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Console Chat program. Some description: *
 * - the user enters a word-phrase, the program takes a random phrase from a text file and outputs it in response.
 * - the program becomes silent if the user enters the word "стоп", while he can continue to send messages to the chat.
 * - if the user enters the word "продолжить", the program starts responding again.
 * - when you enter the word "выход", the program stops working.
 * - dialogue recording written to the text log.
 * @author A.Kulynych
 */
public class ConsoleChat {
    private final String logPath;
    private final String botAnswers;

    private static final String STOP = "стоп";
    private static final String OUT = "выход";
    private static final String CONTINUE = "продолжить";
    private List<String> logs = new ArrayList();
    private List<String> inputWords = new ArrayList<>(20);

    public ConsoleChat(String botAnswers, String logPath) {
        this.logPath = logPath;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        boolean work = true;
        boolean runBot = true;
        init();
        Scanner scanner = new Scanner(System.in);
        while (work) {
            System.out.print("Type your lines:");
            String userLines = scanner.nextLine();
            work = !userLines.equals(OUT);
            if (userLines.equals(CONTINUE)) {
                runBot = true;
            }
            if (userLines.equals(STOP)) {
                runBot = false;
            }
            logs.add(userLines);
            if (runBot && work) {
                String answer = getBotAnswers();
                System.out.print(String.format("bot:%s\n", answer));
                logs.add(answer);
            }
        }
        exit();
    }

    private void init() throws IOException {
        inputWords = Files.readAllLines(Path.of(botAnswers));
    }

    private void exit() throws IOException {
        Files.write(Path.of(logPath), logs, Charset.forName("WINDOWS-1251"));
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat chat = new ConsoleChat(
                "./chapter_002/src/main/java/io/consolchat/data/botAnswers.txt",
                "./chapter_002/src/main/java/io/consolchat/data/chatLog.txt"
        );
        chat.run();
    }

    public String getBotAnswers() {
        int rmId = (int) (Math.random() * inputWords.size());
        return inputWords.get(rmId);
    }
}
