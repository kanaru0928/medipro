package medipro.commands;

import medipro.IKeyAction;

public class RightCommand extends Command {

    public RightCommand() {
        super("^right$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.removeKey(65);
        action.addKey(68);
    }
}
