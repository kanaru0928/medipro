package medipro.stage_menu_bar;

import java.awt.event.ActionEvent;

import medipro.App;
import medipro.app.AppModel;

public class StageMenuBarController {

    private final StageMenuBarModel model;

    public StageMenuBarController(StageMenuBarModel model) {
        this.model = model;
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public void handleGoToTop(ActionEvent event) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
    }

    public void handleGoToStageLevel1(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel1);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel2(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel2);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel3(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel3);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel4(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel4);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel5(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel5);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel6(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel6);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel7(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel7);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

    public void handleGoToStageLevel8(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel8);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
    }

}
