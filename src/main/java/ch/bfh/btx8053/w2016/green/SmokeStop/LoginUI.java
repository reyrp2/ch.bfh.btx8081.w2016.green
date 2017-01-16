package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class LoginUI extends VerticalLayout implements View {

	private TextField userName;
	private PasswordField password;
	private String verify = null;

	public LoginUI(){

		final VerticalLayout layout = new VerticalLayout();

		//head bar    	
		final HorizontalLayout hLayout1 = new HorizontalLayout();//löschen wenn nur ein Titel gebruacht wird
		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(lTitle); 	
		hLayout1.setSpacing(true);

		//Username field
		userName = new TextField();
		userName.setCaption("Benutzername");

		//Password field
		password = new PasswordField();
		password.setCaption("Passwort");

		//Login button with click event
		final Button loginButton = new Button("Login");
		loginButton.addClickListener( e -> {

			final String myLogin = userName.getValue();
			final String myPassword = password.getValue(); 

//			loginAuthorisation loginAuth = new loginAuthorisation(); //DB-Klasse für autorisierung
//			loginAuth.CheckAcces(myLogin, myPassword);

//			verify = loginAuth.getResult();

			if (verify == "true"){
				getUI().getNavigator().navigateTo(MainUI.MOTIVATOR);
			}
			else { Notification.show("Login incorrect, try it again.");
//			System.out.println(verify);
			getUI().getNavigator().navigateTo(MainUI.MOTIVATOR);//löschen wenn mit DB verbunden
			}
		});


		//Create new Account button with click event
		final Button createAccountLink = new Button("Create new Account");
		createAccountLink.setStyleName("link"); //funktioniert nicht!!!!
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
