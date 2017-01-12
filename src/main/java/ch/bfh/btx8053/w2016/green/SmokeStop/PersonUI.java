package ch.bfh.btx8053.w2016.green.SmokeStop;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
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
		
		hLayoutIcons.addComponents(bMotivator, bCalendar, bPerson);

		final Label lTitle = new Label("SmokeStop");

		hLayout1.addComponents(hLayoutIcons, lTitle); 	
		hLayout1.setSpacing(true);

		final TextField userName = new TextField();
		userName.setCaption("Benutzername");

		final TextField Name = new TextField();
		Name.setCaption("Name");

		final TextField Vorname = new TextField();
		Vorname.setCaption("Vorname");

		final TextField alter = new TextField();
		alter.setCaption("Geburtsdatum");   
       
        ComboBox Zigaretten = new ComboBox("Anzahl täglicher Zigaretten");
        Zigaretten.addItem("1");
        Zigaretten.addItem("2");
        Zigaretten.addItem("3");
        Zigaretten.addItem("4");
        Zigaretten.addItem("5");
        Zigaretten.addItem("6");
        Zigaretten.addItem("7");
        Zigaretten.addItem("8");
        Zigaretten.addItem("9");
        Zigaretten.addItem("10");
        Zigaretten.addItem("11");
        Zigaretten.addItem("12");
        Zigaretten.addItem("13");
        Zigaretten.addItem("14");
        Zigaretten.addItem("15");
        Zigaretten.addItem("16");
        Zigaretten.addItem("17");
        Zigaretten.addItem("18");
        Zigaretten.addItem("19");
        Zigaretten.addItem("20");
        Zigaretten.addItem("21");
        Zigaretten.addItem("22");
        Zigaretten.addItem("23");
        Zigaretten.addItem("24");
        Zigaretten.addItem("25");
        Zigaretten.addItem("26");
        Zigaretten.addItem("27");
        Zigaretten.addItem("28");
        Zigaretten.addItem("29");
        Zigaretten.addItem("30");
        Zigaretten.addItem("31");
        Zigaretten.addItem("32");
        Zigaretten.addItem("32");
        Zigaretten.addItem("33");
        Zigaretten.addItem("34");
        Zigaretten.addItem("35");
        Zigaretten.addItem("36");
        Zigaretten.addItem("37");
        Zigaretten.addItem("38");
        Zigaretten.addItem("39");
        Zigaretten.addItem("40");
        Zigaretten.addItem("41");
        Zigaretten.addItem("42");
        Zigaretten.addItem("43");
        Zigaretten.addItem("44");
        Zigaretten.addItem("45");
        Zigaretten.addItem("46");
        Zigaretten.addItem("47");
        Zigaretten.addItem("48");
        Zigaretten.addItem("49");
        Zigaretten.addItem("50");
        Zigaretten.addItem("51");
        Zigaretten.addItem("52");
        Zigaretten.addItem("53");
        Zigaretten.addItem("54");
        Zigaretten.addItem("55");
        Zigaretten.addItem("56");
        Zigaretten.addItem("57");
        Zigaretten.addItem("58");
        Zigaretten.addItem("59");
        Zigaretten.addItem("60");

		layout.addComponents(hLayout1,userName,Name,Vorname,alter,Zigaretten);
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
