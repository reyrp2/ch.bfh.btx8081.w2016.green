package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonUI extends VerticalLayout implements View {

	public PersonUI(){

		final VerticalLayout layout = new VerticalLayout();

		//head bar    	
		final HorizontalLayout hLayout1 = new HorizontalLayout();

		final CssLayout hLayoutIcons = new CssLayout(); 
		hLayoutIcons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP); //

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
		
		hLayoutIcons.addComponents(bCalendar, bPerson, bMotivator);

		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(hLayoutIcons, lTitle); 	
		hLayout1.setSpacing(true);


		final TextField Name = new TextField();
		Name.setCaption("Name");

		final TextField Vorname = new TextField();
		Vorname.setCaption("Vorname");

		final TextField alter = new TextField();
		alter.setCaption("Geburtsdatum");   

		final TextField Zigaretten = new TextField();
		Zigaretten.setCaption("Wie lange rauchen Sie?");

		layout.addComponents(hLayout1,Name,Vorname,alter,Zigaretten);
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
