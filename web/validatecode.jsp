﻿<%@ page import="java.util.Random"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%
	/**
	 * 作者：xuqiaohui 网址： http://blog.csdn.net/tkd03072010/article/details/7015070 
	 */
	int width = 60;
	int height = 25;
	//create the image
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	// set the background color
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, width, height);
	// draw the border
	g.setColor(Color.GRAY);
	g.drawRect(0, 0, width - 1, height - 1);
	// create a random instance to generate the codes
	Random rdm = new Random();
	String hash1 = Integer.toHexString(rdm.nextInt());
	// make some confusion
	for (int i = 0; i < 50; i++) {
		int x = rdm.nextInt(width);
		int y = rdm.nextInt(height);
		g.drawOval(x, y, 0, 0);
	}
	// generate a random code
	String capstr = hash1.substring(0, 4);
	session.setAttribute("key", capstr);
	g.setColor(Color.BLACK);
	g.setFont(new Font("Candara", Font.BOLD, 22));
	g.drawString(capstr, 6, 18);
	g.dispose();
	response.setContentType("image/jpeg");
	out.clear();
	out = pageContext.pushBody();
	OutputStream strm = response.getOutputStream();
	ImageIO.write(image, "jpeg", strm);
	strm.close();
%>