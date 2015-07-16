package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPageControllerTest {

    @Mock
    private MainPageModel model;
    @Mock
    private MainPageView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController();
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }
}