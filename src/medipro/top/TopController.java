package medipro.top;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;
import medipro.app.AppModel;

public class TopController implements ActionListener {
    private TopModel model;

    public TopController(TopModel model) {
        this.model = model;
    }

    public TopModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New Game Start":
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                App.getStageModel().setWorld(App.worldLevel1);
                break;

            case "Level Select":
                App.getAppModel().setPageName(AppModel.PAGE_LEVEL_SELECT);
                break;

            case "Setting":
                App.getAppModel().setPageName(AppModel.PAGE_SETTING);
                break;

            case "How to Play":
                App.getAppModel().setPageName(AppModel.PAGE_HOW_TO_PLAY);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
