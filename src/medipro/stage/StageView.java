package medipro.stage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import medipro.Entity;
import medipro.Vector2;
import medipro.stage_menu.StageMenuView;
import medipro.utils.Fonts;

public class StageView extends JPanel implements MouseListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private final StageModel model;
    private final StageController controller;

    private StageMenuView stageMenuView;

    public StageView(StageModel model, StageController controller) {
        this.model = model;
        this.controller = controller;

        setLayout(null);

        JButton openMenuButton = new JButton("メニュー");
        openMenuButton.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(20.0f));
        JPanel openMenuButtonPanel = new JPanel();
        openMenuButtonPanel.setOpaque(false);
        openMenuButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        openMenuButtonPanel.add(openMenuButton);
        openMenuButtonPanel.setSize(openMenuButtonPanel.getPreferredSize());
        openMenuButton.addActionListener(controller::handleClickOpenMenuButton);

        openMenuButtonPanel.setLocation(StageView.WIDTH - openMenuButtonPanel.getWidth(), 0);
        add(openMenuButtonPanel);

        setPreferredSize(new Dimension(StageView.WIDTH, StageView.HEIGHT));
        addKeyListener(controller);
        setFocusable(true);
        addMouseListener(this);

        model.addPropertyChangeListener("openedMenu", this::handleChangeMenuOpened);

        // 30fps
        Timer timer = new Timer(1000 / 30, (e) -> {
            repaint();
        });
        timer.start();
    }

    public void setStageMenuView(StageMenuView view) {
        this.stageMenuView = view;
        view.setBounds(200, 150, 400, 300);
        view.setVisible(false);
        add(view);
    }

    private void handleChangeMenuOpened(PropertyChangeEvent event) {
        if ((boolean) event.getNewValue()) {
            stageMenuView.setVisible(true);
            stageMenuView.requestFocus();
            controller.clearKeys();
        } else {
            stageMenuView.setVisible(false);
            requestFocus();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 背景の描画
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // ステージの描画
        for (int i = 0; i < model.getWorld().getTiles().length; i++) {
            for (int j = 0; j < model.getWorld().getTiles()[i].length; j++) {
                if (model.getWorld().getTiles()[i][j] != null) {
                    model.getWorld().getTiles()[i][j].draw(g);
                }
            }
        }

        // draw keys
        Entity entity = model.getEntity();
        g.drawImage(entity.getImage(), (int) entity.getPosX(), (int) entity.getPosY(), entity.getWidth(),
                entity.getHeight(), this);
        // entityの周りを線で囲む
        if (model.isDebug()) {
            g.setColor(Color.RED);
            g.drawRect((int) entity.getPosX(), (int) entity.getPosY(), entity.getWidth(), entity.getHeight());
        }

        // 死んだ時の描画
        if (!entity.isAlive()) {
            // TODO: 死んだ時の描画
        }

        // ハングワイヤーの描画
        if (model.getHangWire() != null) {
            g.setColor(Color.PINK);
            Vector2 hangWireStart = model.getHangWire().getStart();
            Vector2 hangWireEnd = model.getHangWire().getEnd();
            g.drawLine((int) hangWireStart.getX(), (int) hangWireStart.getY(), (int) hangWireEnd.getX(),
                    (int) hangWireEnd.getY());
        }

        // entity data
        if (model.isDebug()) {
            g.setColor(Color.CYAN);
            g.setFont(g.getFont().deriveFont(20.0f));
            g.drawString("Keys: " + model.getKeys(), 10, 40);
            g.setColor(Color.RED);
            g.drawString("posX: " + model.getEntity().getPosX(), 10, 70);
            g.drawString("posY: " + model.getEntity().getPosY(), 10, 100);
            g.drawString("velX: " + model.getEntity().getVelX(), 10, 130);
            g.drawString("velY: " + model.getEntity().getVelY(), 10, 160);
            g.drawString("accX: " + model.getEntity().getAccX(), 10, 190);
            g.drawString("accY: " + model.getEntity().getAccY(), 10, 220);
        }
    }

    public StageModel getModel() {
        return model;
    }

    public StageController getController() {
        return controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
