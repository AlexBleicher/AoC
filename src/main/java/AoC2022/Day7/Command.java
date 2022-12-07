package AoC2022.Day7;

public class Command {

    private String command;
    private String content;

    public Command(String command, String content) {
        this.command = command;
        this.content = content;
    }

    public boolean goIntoDir(){
        return command.equals("cd")&&!content.equals("..");
    }

    public boolean changesDir(){
        return command.equals("cd");
    }

    public String getCommand() {
        return command;
    }

    public String getContent() {
        return content;
    }
}
