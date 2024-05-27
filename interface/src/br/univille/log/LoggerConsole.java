package br.univille.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerConsole implements Logger {
    @Override
    public void log(Level level, String message) {
        String color;
        switch (level) {
            case DEBUG:
                color = "\u001B[32m"; // Verde
                break;
            case WARNING:
                color = "\u001B[33m"; // Amarelo
                break;
            case ERROR:
                color = "\u001B[31m"; // Vermelho
                break;
            default:
                color = "\u001B[0m"; // Reset
        }

        String resetColor = "\u001B[0m";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(color + timestamp + " [" + level + "] " + message + resetColor);
    }
}
