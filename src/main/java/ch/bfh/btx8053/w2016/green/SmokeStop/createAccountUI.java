package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class createAccountUI extends UI implements View {

	public createAccountUI(){

		final VerticalLayout layout = new VerticalLayout();

		final Label newAccount = new Label("Create a new Account:");

		final TextField fieldName = new TextField();
		fieldName.setInputPrompt("Insert your Name");

		final TextField fieldFirstName = new TextField();
		fieldFirstName.setInputPrompt("Insert your First Name");

		final TextField fieldMail = new TextField();
		fieldMail.setSizeFull();
		fieldMail.setInputPrompt("Insert your Email adress");

		final TextField fieldPW = new TextField();
		fieldPW.setInputPrompt("Insert your password");

		final TextField fieldPWAgain = new TextField();
		fieldPWAgain.setInputPrompt("Repeat your password");

		final Button createAccount = new Button("Create account");
		createAccount.addClickListener(e -> {
			fieldName.clear(); 
			fieldFirstName.clear();
			fieldMail.clear();
			fieldPW.clear();
			fieldPWAgain.clear();
			getUI().getNavigator().navigateTo(MainUI.PERSON);//connect to person class
		});

		final Link loginLink = new Link ("Back to Login", new ExternalResource("http://localhost:8080")); //hyperlink to login-screen

		layout.addComponents(newAccount, fieldName, fieldFirstName, fieldMail, fieldPW, fieldPWAgain, createAccount, loginLink);
		layout.setSizeUndefined();
		//layout.setSizeFull(); //Layout passt sich der Bildschirmgrösse an
		layout.setMargin(true);
		layout.setSpacing(true); 
		setContent(layout);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
	}
}
