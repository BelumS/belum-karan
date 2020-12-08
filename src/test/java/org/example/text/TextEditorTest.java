package org.example.text;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import org.junit.jupiter.api.*;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeoutException;

import static org.testfx.util.NodeQueryUtils.hasText;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TextEditorTest extends ApplicationTest {
    private TextArea textArea;
    private Menu fileMenu;
    private MenuItem openMenuItem;
    private MenuItem saveMenuItem;
    private MenuItem newMenuItem;
    private MenuItem exitMenuItem;

    private static final String TEXT_AREA_ID = "#textArea";
    private static final String MENU_BAR_ID = "#menuBar";
    private static final String FILE_MENU_ID = "#fileMenu";
    private static final String NEW_MENU_ITEM_ID = "#newMenuItem";
    private static final String OPEN_MENU_ITEM_ID = "#openMenuItem";
    private static final String SAVE_MENU_ITEM_ID = "#saveMenuItem";
    private static final String EXIT_MENU_ITEM_ID = "#exitMenuItem";

    @BeforeAll
    static void setupBeforeClass() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.showStage();
        FxToolkit.setupApplication(TextEditor::new);
        WaitForAsyncUtils.waitForFxEvents(100);
    }

    private <T extends Node> T find(String query) {
        return lookup(query).query();
    }

    @BeforeEach
    void setup() throws Exception {
        //FxToolkit.setupStage(stage -> stage.setScene(new Scene(new GridPane(), 300, 300)));
        FxToolkit.showStage();

        MenuBar menuBar = find(MENU_BAR_ID);
        textArea = find(TEXT_AREA_ID);
        fileMenu = menuBar.getMenus().get(0);
    }

    @AfterEach
    void tearDown() {
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @AfterAll
    static void tearDownAfterClass() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    @Test
    @Order(1)
    @DisplayName("Verify that you can clear the TextField by clicking File -> New")
    void testNewMenuItem() {
        newMenuItem = fileMenu.getItems().get(0);
        type(KeyCode.B, KeyCode.E, KeyCode.L);
        rightClickOn(FILE_MENU_ID).moveTo(NEW_MENU_ITEM_ID).rightClickOn();
        FxAssert.verifyThat(textArea, hasText(""));
    }

    @Disabled
    @Test
    @Order(2)
    @DisplayName("Verify that you can open a file be clicking File -> Open")
    void testOpenMenuItem() {
        openMenuItem = fileMenu.getItems().get(1);
        rightClickOn(FILE_MENU_ID);
        rightClickOn(OPEN_MENU_ITEM_ID);
        FxAssert.verifyThat(openMenuItem, org.testfx.matcher.control.MenuItemMatchers.hasText("Open"));
    }

    @Disabled
    @Test
    @Order(3)
    @DisplayName("Verify that you can save a file be clicking File -> Save")
    void testSaveMenuItem() {
        saveMenuItem = fileMenu.getItems().get(2);
        rightClickOn(FILE_MENU_ID);
        rightClickOn(SAVE_MENU_ITEM_ID);
        FxAssert.verifyThat(saveMenuItem, org.testfx.matcher.control.MenuItemMatchers.hasText("Save"));
    }

    @Disabled
    @Test
    @Order(4)
    @DisplayName("Verify that you can close the window by clicking File -> Exit")
    void testExitMenuItem() {
        exitMenuItem = fileMenu.getItems().get(3);
        rightClickOn(FILE_MENU_ID);
        rightClickOn(EXIT_MENU_ITEM_ID);
        FxAssert.verifyThat(exitMenuItem, org.testfx.matcher.control.MenuItemMatchers.hasText("Exit"));
    }

}
