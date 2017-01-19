package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Rey
 */
public class createAccountUI extends VerticalLayout implements View {

	public createAccountUI(){

		final VerticalLayout layout = new VerticalLayout();

		final Label newAccount = new Label("Create a new Account:");

		//Name field
		final TextField fieldName = new TextField();
		fieldName.setWidth("200");
		fieldName.setInputPrompt("Insert your Name");

		//Firstname field
		final TextField fieldFirstName = new TextField();
		fieldFirstName.setWidth("200");
		fieldFirstName.setInputPrompt("Insert your First Name");

		//Mail field
		final TextField fieldMail = new TextField();
		fieldMail.setWidth("200");
		fieldMail.setInputPrompt("Insert your Email adress");

		//Password field
		final TextField fieldPW = new TextField();
		fieldPW.setWidth("200");
		fieldPW.setInputPrompt("Insert your password");

		//Password field
		final TextField fieldPWAgain = new TextField();
		fieldPWAgain.setWidth("200");
		fieldPWAgain.setInputPrompt("Repeat your password");

		//Create account button
		final Button createAccount = new Button("Create account");
		createAccount.addClickListener(e -> {
			fieldName.clear(); 
			fieldFirstName.clear();
			fieldMail.clear();
			fieldPW.clear();
			fieldPWAgain.clear();
			getUI().getNavigator().navigateTo(MainUI.PERSON);//connect to person class
		});

		//Login button
		final Button loginLink = new Button("Back to Login");
		loginLink.setStyleName("link");
		loginLink.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.LOGIN);
		});

		layout.addComponents(newAccount, fieldName, fieldFirstName, fieldMail, fieldPW, fieldPWAgain, createAccount, loginLink);
		layout.setSizeFull();
		layout.setMargin(true);
		layout.setSpacing(true); 
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
