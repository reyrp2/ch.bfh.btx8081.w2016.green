package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

/**
 * This class coordinates the motivation text of a user.
 * 
 * @author Pero Grgic
 *
 */
public class Motivator {

	BufferedImage img;
	/**
	 * The user can set at the beginning their motivation text
	 */
	public Motivator() {
	}

	/**
	 * set the motivation text
	 * 
	 * @param MotivationText
	 * 
	 * @param userName user name of the user to set motivation text
	 */
	public void setMotivationText(String MotivationText, String userName) {
		connectToDB c = new connectToDB();
		c.writeMotivationText(MotivationText, userName);
	}

	/**
	 * gets the motivation text of the user
	 * @param UserName
	 * @return user name
	 * @throws SQLException
	 */
	private String getMotivationText(String UserName) {
		connectToDB c = new connectToDB();
		return c.readMotivationTxt(UserName);
	}

	/**
	 * loads an image from the given path
	 * 
	 * @param imagePath
	 *            path of the image
	 */
	public void loadImage(String imagePath) {  //image from system not from data base
		try {
			img = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
