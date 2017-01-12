package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MotivatorUI extends VerticalLayout implements View {

	public MotivatorUI(){

		final VerticalLayout layout = new VerticalLayout(); //Main layout

		//head bar    	
		final HorizontalLayout hLayout1 = new HorizontalLayout();

		final CssLayout hLayoutIcons = new CssLayout(); 
		hLayoutIcons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		final Button bCalendar = new Button(FontAwesome.CALENDAR);
		bCalendar.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.CALENDAR);
		});
		final Button bPerson = new Button(FontAwesome.USER);
		bPerson.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.PERSON);
		});
		final Button bMotivator = new Button(FontAwesome.BULLSEYE);
		bMotivator.addClickListener( e -> {
			getUI().getNavigator().navigateTo(MainUI.MOTIVATOR);
		});

		hLayoutIcons.addComponents(bMotivator, bCalendar, bPerson);

		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(hLayoutIcons, lTitle); 	
		hLayout1.setSpacing(true);

		//Motivation text and Picture
		String imageDescription = new String("YOU CAN DO IT!!");//text
		ThemeResource resource = new ThemeResource("images/motivation.jpg");//picture
		final Image motivationImage = new Image(imageDescription, resource);                   

		//Saved money
		final Label savedMoney = new Label();
		savedMoney.setCaption("You have saved at least " + "153.20" + " CHF" ); //the number should come from the Money class

		//Goal buttons
		final HorizontalLayout hLayoutButtons = new HorizontalLayout();

		final Label goalText = new Label();

		final Button bAchieved = new Button("Goal achieved");

		bAchieved.addClickListener( e -> {
			layout.addComponent(new Label("Congratulation, you got it!"));
		});

		final Button bfaild = new Button("Goal faild");
		bfaild.addClickListener( e -> {
			layout.addComponent(new Label("Damn, you miss! Don't give up"));
		});

		hLayoutButtons.addComponents(bAchieved, bfaild);
		hLayoutButtons.setSpacing(true);

		//Main layout
		layout.addComponents(hLayout1, motivationImage, savedMoney, hLayoutButtons, goalText);
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
