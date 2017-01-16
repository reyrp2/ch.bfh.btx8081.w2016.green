package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MotivatorUI extends VerticalLayout implements View {

	final static String WIDTH= "280";// screengrösse..
	final static String HEIGHT= "570";//screengrösse..
	
	public MotivatorUI() {

		final VerticalLayout layout = new VerticalLayout(); // Main layout

		// head bar
		final HorizontalLayout hLayout1 = new HorizontalLayout();

		// icon group
		final CssLayout hLayoutIcons = new CssLayout();
		hLayoutIcons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		final Button bCalendar = new Button(FontAwesome.CALENDAR);
		bCalendar.addClickListener(e -> {
			getUI().getNavigator().navigateTo(MainUI.CALENDAR);
		});
		final Button bPerson = new Button(FontAwesome.USER);
		bPerson.addClickListener(e -> {
			getUI().getNavigator().navigateTo(MainUI.PERSON);
		});
		final Button bMotivator = new Button(FontAwesome.BULLSEYE);
		bMotivator.addClickListener(e -> {
			getUI().getNavigator().navigateTo(MainUI.MOTIVATOR);
		});
		hLayoutIcons.addComponents(bMotivator, bCalendar, bPerson);

		final Label lTitle = new Label("SmokeStop");
		hLayout1.addComponents(hLayoutIcons, lTitle);
		hLayout1.setSpacing(true);

		// Motivation text and Picture
		String imageDescription = new String("YOU CAN DO IT!!");// text
		ThemeResource resource = new ThemeResource("images/motivation.jpg");// picture
		final Image motivationImage = new Image(imageDescription, resource);

		// Saved money
		final Label savedMoney = new Label();
		savedMoney.setCaption("You have saved at least " + "153.20" + " CHF"); // the number should come from the Money class


		

		// Show uploaded file in this placeholder
		final Embedded image = new Embedded("Uploaded Image");
		image.setVisible(false);

		// Implement both receiver that saves upload in a file and
		// listener for successful upload
		class ImageUploader implements Receiver, SucceededListener {
			public File file;

			public OutputStream receiveUpload(String filename, String mimeType) {
				// Create upload stream
				FileOutputStream fos = null; // Stream to write to
				try {
					// Open the file for writing.
					file = new File("/tmp/uploads/" + filename);
					fos = new FileOutputStream(file);
				} catch (final java.io.FileNotFoundException e) {
					new Notification("Could not open file<br/>", e.getMessage(), Notification.Type.ERROR_MESSAGE)
					.show(Page.getCurrent());
					return null;
				}
				return fos; // Return the output stream to write to
			}

			public void uploadSucceeded(SucceededEvent event) {
				// Show the uploaded file in the image viewer
				image.setVisible(true);
				image.setSource(new FileResource(file));
			}
		};
		ImageUploader receiver = new ImageUploader();

		// Create the upload with a caption and set receiver later
		Upload upload = new Upload("Upload Image Here", receiver);
		upload.setButtonCaption("Start Upload");
		upload.addSucceededListener(receiver);
		// Put the components in a panel
		Panel panel = new Panel("Cool Image Storage");
		Layout panelContent = new VerticalLayout();
		panelContent.addComponents(upload, image);
		panel.setContent(panelContent);




		// Goal buttons
		final HorizontalLayout hLayoutButtons = new HorizontalLayout();
		final Label goalText = new Label();

		final Button bAchieved = new Button("Goal achieved");
		bAchieved.addStyleName("green");//funktioniert nicht
		bAchieved.addClickListener(e -> {
			layout.addComponent(new Label("Congratulation, you got it!"));
		});

		final Button bfaild = new Button("Goal faild");
		bfaild.addStyleName("red");//funktioniert nicht
		bfaild.addClickListener( e -> {
			layout.addComponent(new Label("Damn, you miss! Don't give up"));
		});

		hLayoutButtons.addComponents(bAchieved, bfaild);
		hLayoutButtons.setSpacing(true);

		// Main layout
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
