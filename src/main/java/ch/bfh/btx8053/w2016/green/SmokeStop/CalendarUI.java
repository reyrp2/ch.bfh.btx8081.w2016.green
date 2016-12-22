package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.calendar.DateConstants;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickEvent;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.handler.BasicDateClickHandler;

@SuppressWarnings("serial")
@Theme("mytheme")
public class CalendarUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		final HorizontalLayout hLayout = new HorizontalLayout();
		Button person = new Button("Über mich");
		Button kalendar = new Button("Calendar");
		hLayout.addComponents(person, kalendar);
		hLayout.setSpacing(true);

		final VerticalLayout layout = new VerticalLayout();


		// Create the calendar
		Calendar calendar = new Calendar("SmokeStop Calendar");
		calendar.setWidth("600px");  // Undefined by default
		calendar.setHeight("400px"); // Undefined by default

		// Use US English for date/time representation 
		calendar.setLocale(new Locale("en", "US"));

		// Set start date to first date in this month
		GregorianCalendar calStart = new GregorianCalendar();
		calendar.setStartDate(calStart.getTime());

		// Set end date to last day of this month
		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.set(java.util.Calendar.DATE, 1);
		calEnd.roll(java.util.Calendar.DATE, -1);
		calendar.setEndDate(calEnd.getTime());
		        
		// Add a short event today
		GregorianCalendar start = new GregorianCalendar();
		start.set(java.util.Calendar.HOUR, 14);
		start.set(java.util.Calendar.MINUTE, 00);
		start.set(java.util.Calendar.SECOND, 00);
		GregorianCalendar end   = new GregorianCalendar();
		end.set(java.util.Calendar.HOUR, 18);
		end.set(java.util.Calendar.MINUTE, 00);
		end.set(java.util.Calendar.SECOND, 00);
		calendar.addEvent(new BasicEvent("Calendar study",
		        "Learning how to use Vaadin Calendar",
		        start.getTime(), end.getTime()));
		       
		// Add an all-day event
		GregorianCalendar today = new GregorianCalendar();
		BasicEvent dayEvent = new BasicEvent("All-day Long",
		        "This is the Day",
		        today.getTime(), today.getTime());
		dayEvent.setAllDay(true);
		calendar.addEvent(dayEvent);

		// Add an all-week event
		GregorianCalendar weekstart = new GregorianCalendar();
		GregorianCalendar weekend   = new GregorianCalendar();
		weekstart.setFirstDayOfWeek(java.util.Calendar.SUNDAY);
		weekstart.set(java.util.Calendar.HOUR_OF_DAY, 0);
		weekstart.set(java.util.Calendar.DAY_OF_WEEK,
		             java.util.Calendar.SUNDAY);
		weekend.set(java.util.Calendar.HOUR_OF_DAY, 23);
		weekend.set(java.util.Calendar.DAY_OF_WEEK,
		             java.util.Calendar.SATURDAY);
		BasicEvent weekEvent = new BasicEvent("A long week",
		        "This is a long long week",
		        weekstart.getTime(), weekend.getTime());
//		        weekEvent.setAllDay(true);
		calendar.addEvent(weekEvent);
		        
		// Handle clicks on dates
		calendar.setHandler(new BasicDateClickHandler() {
		    public void dateClick(DateClickEvent event) {
		      Calendar cal = event.getComponent();
		      
		      // Check if the current range is already one day long
		      long currentCalDateRange = cal.getEndDate().getTime() -
		                                 cal.getStartDate().getTime();

		      // From one-day view, zoom out to week view
		      if (currentCalDateRange <= DateConstants.DAYINMILLIS) {
		          // Change the date range to the current week
		          GregorianCalendar weekstart = new GregorianCalendar();
		          GregorianCalendar weekend   = new GregorianCalendar();
		          weekstart.setTime(event.getDate());
		          weekend.setTime(event.getDate());
		          weekstart.setFirstDayOfWeek(java.util.Calendar.SUNDAY);
		          weekstart.set(java.util.Calendar.HOUR_OF_DAY, 0);
		          weekstart.set(java.util.Calendar.DAY_OF_WEEK,
		                       java.util.Calendar.SUNDAY);
		          weekend.set(java.util.Calendar.HOUR_OF_DAY, 23);
		          weekend.set(java.util.Calendar.DAY_OF_WEEK,
		                       java.util.Calendar.SATURDAY);
		          cal.setStartDate(weekstart.getTime());
		          cal.setEndDate(weekend.getTime());

		          Notification.show("Custom zoom to week");
		      } else {
		        // Default behavior, change date range to one day
		        super.dateClick(event);
		      }
		    }
		  });       
		        
		layout.addComponent(calendar);

		layout.addComponents(hLayout, calendar);
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = CalendarUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
