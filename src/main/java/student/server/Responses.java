package student.server;

import java.util.List;
import java.util.Map;

/**
 * This class is used to report any errors.
 */
class Error {
    private String message;

    public Error() { }

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


/**
 * Represents result of a command.
 */
class CommandResult {
    // Game id
    private int id;

    // Error message to display to user
    private String error;
    // Message to display to user
    private String message;
    // Image URL to image to display to user
    private String imageUrl;
    // YouTube video URL for audio that will play for user
    private String videoUrl;

    // Map containing state that will be displayed in table to the user
    private Map<String, String> state;
    // Map containing command names (ex: "go") mapped to list of command values (ex: ["North", "South"])
    private Map<String, List<String>> commandOptions;

    public CommandResult() { }

    // TODO: Implement your own constructor

    public int getId() {
        return id;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Map<String, String> getState() {
        return state;
    }

    public Map<String, List<String>> getCommandOptions() {
        return commandOptions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setState(Map<String, String> state) {
        this.state = state;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setCommandOptions(Map<String, List<String>> commandOptions) {
        this.commandOptions = commandOptions;
    }

}