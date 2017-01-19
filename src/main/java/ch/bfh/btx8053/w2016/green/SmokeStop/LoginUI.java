package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Rey
 */
@Theme("mytheme")
public class LoginUI extends VerticalLayout implements View {

	//Parameters
	private TextField userName;
	private PasswordField password;
	private String checkAuthen = null;

	public LoginUI(){

		final VerticalLayout layout = new VerticalLayout();

		//Title    	
		final HorizontalLayout hLayout1 = new HorizontalLayout();
		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(lTitle); 	
		hLayout1.setSpacing(true);

		//Username field
		userName = new TextField();
		userName.setCaption("Benutzername");

		//Password field
		password = new PasswordField();
		password.setCaption("Passwort");

		//Login-button with click event
		final Button loginButton = new Button("Login");
		loginButton.addClickListener( e -> {

			final String myLogin = userName.getValue();
			final String myPassword = password.getValue(); 

			//Check username and password with the data base
			connectToDB c = new connectToDB();
			c.checkAuthen(myLogin, myPassword);

			if (c.checkAuthen(myLogin, myPassword)){
				getUI().getNavigator().navigateTo(MainUI.MOTIVATOR);
			}
			else { Notification.show("Login incorrect, try it again.");
			System.out.println(checkAuthen);
			}
		});

		//new Account-button with click event
		final Button createAccountLink = new Button("Create new Account");
		createAccountLink.setStyleName("link");
		createAccountLink.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.ACCOUNT);
		});

		layout.addComponents(hLayout1,userName,password,loginButton,createAccountLink);
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
