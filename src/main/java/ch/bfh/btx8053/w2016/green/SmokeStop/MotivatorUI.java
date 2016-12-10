package ch.bfh.btx8053.w2016.green.SmokeStop;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MotivatorUI extends UI { //standard Vaadin code

	@Override
	protected void init(VaadinRequest vaadinRequest) { //standard Vaadin code
		final VerticalLayout layout = new VerticalLayout(); //Main layout

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

		//Motivation text and Picture
		String imageDescription = new String("YOU CAN DO IT!!");
		ThemeResource resource = new ThemeResource("images/im2.jpg");
		final Image motivationImage = new Image(imageDescription, resource);                   

		//Saved money
		final Label savedMoney = new Label();
		savedMoney.setCaption("You have saved at least " + "153.20" + " CHF" ); //the number should come from the Money class

		//Goal buttons
		final HorizontalLayout hLayoutButtons = new HorizontalLayout();

		final Label goalText = new Label();

		final Button bAchieved = new Button("Goal achieved");
		
//		bAchieved.setImmediate(true);
//		bAchieved.setWidth("500px");
//		bAchieved.setHeight("500px");
//		bAchieved.setStyleName("thumbs-down-button");
		
		
		bAchieved.addClickListener( e -> {
			layout.addComponent(new Label("You got it!"));
		});

		final Button bfaild = new Button("Goal faild");
		bfaild.addClickListener( e -> {
			layout.addComponent(new Label("You miss!"));
		});

		hLayoutButtons.addComponents(bAchieved, bfaild);
		hLayoutButtons.setSpacing(true);

		//Main layout
		layout.addComponents(hLayout1, motivationImage, savedMoney, hLayoutButtons, goalText);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		
		
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true) //standard Vaadin code
	@VaadinServletConfiguration(ui = MotivatorUI.class, productionMode = false) //standard Vaadin code
	public static class MyUIServlet extends VaadinServlet { //standard Vaadin code
	}
}
