package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class Motivator{
	
	private String UserName;
	private String MotivationText;
	private BufferedImage img;
	
	/**
	 * The user can set at the beginning their
	 * motivation text or load their motivation picture
	 * @param motivationText the text which should motivate the user
	 * @param imagePath path of the image which should motivate the user
	 * @throws SQLException 
	 */
	public Motivator (String userName) throws SQLException{
		this.UserName = userName;
		getMotivationText(userName);
	}

	/**
	 * set the motivation text
	 * 
	 * @param MotivationText
	 */
	public void setMotivationText(String MotivationText) {
		this.MotivationText = MotivationText;
	}
	
	private String getMotivationText(String UserName) throws SQLException {
		connectToDB c =new connectToDB();	
		return MotivationText = c.readMotivationTxt(UserName);
	}
	
	/**
	 * loads an image from the given path
	 * @param imagePath path of the image
	 */
	public void loadImage(String imagePath){
		try{
			img = ImageIO.read(new File(imagePath));
		} catch (IOException e){
			e.printStackTrace();
		}
	}



}
