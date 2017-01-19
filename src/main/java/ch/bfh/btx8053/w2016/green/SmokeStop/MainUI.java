package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * 
 * @author Rey
 */
@Theme("mytheme")
public class MainUI extends UI {

	public Navigator navigator;

	//Views
	public static final String LOGIN = "login";
	public static final String ACCOUNT = "account";
	public static final String CALENDAR = "calendar";
	public static final String PERSON = "person";
	public static final String MOTIVATOR = "motivator";


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		navigator = new Navigator(UI.getCurrent(),viewDisplay);

		navigator.addView("", new LoginUI());//start-page
		navigator.addView(LOGIN, new LoginUI());
		navigator.addView(ACCOUNT, new createAccountUI());
		navigator.addView(CALENDAR, new CalendarUI());
		navigator.addView(PERSON, new PersonUI());
		try {
			navigator.addView(MOTIVATOR, new MotivatorUI());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
	}


	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
