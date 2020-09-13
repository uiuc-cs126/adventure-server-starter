package student.server;

import java.util.List;

/**
 * Represents a new game request.
 */
class NewGame {
    private String url;

    public NewGame() { }

    public NewGame(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

/**
 * Represents a request to complete a certain command
 */
class Command {
    /** Name of the command to be completed (ex: "go") */
    private String commandName;
    /** Subject of the command to be completed (ex: "East") */
    private String commandValue;

    public Command() { }

    public Command(String commandName, String commandValue) {
        this.commandName = commandName;
        this.commandValue = commandValue;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public String getCommandValue() {
        return commandValue;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void setCommandValue(String commandValue) {
        this.commandValue = commandValue;
    }
}