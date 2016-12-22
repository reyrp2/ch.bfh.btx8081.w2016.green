package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class LoginUI extends VerticalLayout implements View {

	public LoginUI(){

		final VerticalLayout layout = new VerticalLayout();

		//head bar    	
		final HorizontalLayout hLayout1 = new HorizontalLayout();//l�schen wenn nur ein Titel gebruacht wird
		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(lTitle); 	
		hLayout1.setSpacing(true);

		final TextField Benutzername = new TextField();
		Benutzername.setCaption("Benutzername");

		final TextField Passwort = new TextField();
		Passwort.setCaption("Passwort");
		
		final Button loginButton = new Button("Login");
		loginButton.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.PERSON);
		});
		
		final Link createAccountLink = new Link ("Create new Account", new ExternalResource("localhost:8080/#!account")); //hyperlink to create account-screen

		layout.addComponents(hLayout1,Benutzername,Passwort,loginButton,createAccountLink);
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}