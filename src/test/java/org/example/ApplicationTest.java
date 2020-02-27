package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.common.ProjectMenu;

public class ApplicationTest {
    @Test
    public void testApplicationConstructor() {
        Application app = new Application();
        Assertions.assertNotNull(app);
    }

    @Test
    public void testMainMethod() {
        Application.main(new String[] {""});
    }

    @Test
    public void testProjectMenu() {
        ProjectMenu.menu();
    }
}