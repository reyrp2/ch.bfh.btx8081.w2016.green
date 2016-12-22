package ch.bfh.btx8053.w2016.green.SmokeStop;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class LoginUI extends UI {
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
	
	//head bar    	
	final HorizontalLayout hLayout1 = new HorizontalLayout();

	final CssLayout hLayoutIcons = new CssLayout(); 
	hLayoutIcons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP); //

	final Button bCalendar = new Button(FontAwesome.CALENDAR);
	final Button bPerson = new Button(FontAwesome.USER);
	final Button bMotivator = new Button(FontAwesome.BULLSEYE);
	hLayoutIcons.addComponents(bCalendar, bPerson, bMotivator);

	final Label lTitle = new Label("SmokeStop");

	hLayout1.addComponents(hLayoutIcons, lTitle); 	
	hLayout1.setSpacing(true);
	
    final TextField Benutzername = new TextField();
    Benutzername.setCaption("Benutzername");
    
    final TextField Passwort = new TextField();
    Passwort.setCaption("Passwort");
	
    layout.addComponents(hLayout1,Benutzername,Passwort);
    layout.setMargin(true);
    layout.setSpacing(true);
    
    setContent(layout);
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = LoginUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
