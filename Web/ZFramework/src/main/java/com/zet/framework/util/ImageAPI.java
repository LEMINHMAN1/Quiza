package com.zet.framework.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.imgscalr.Scalr;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author manle
 *
 */
public class ImageAPI {

	private static final List<String> IMG_TYPE_ALLOW = new ArrayList<String>(
			Arrays.asList("jpg","jpeg","png")
	);
	private static final String DEFAULT_TYPE="jpg";
	
	public static byte[] resizeImage(byte[] base64Byte, int width, int height) throws IOException {

		// convert byte array to image
        String base64Img = new String(base64Byte);
		
        String[] base64split = base64Img.split(";");
        base64Img = base64split[1].replace("base64,", "");
        
		// convert base64 string image to resize image
		BASE64Decoder decoder = new BASE64Decoder();
        byte[] decoded = decoder.decodeBuffer(base64Img);
        InputStream in = new ByteArrayInputStream(decoded);
		BufferedImage bImageFromConvert = ImageIO.read(in);

		// resize and write to byte array
		BufferedImage thumbnail =Scalr.resize(bImageFromConvert, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,width, height, Scalr.OP_ANTIALIAS);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        // format file type (jpg,jpeg,png)
        String fileType = base64split[0].split("/")[1];
        if(!IMG_TYPE_ALLOW.contains(fileType.toLowerCase()))fileType=DEFAULT_TYPE;
        
        // write to image 
        ImageIO.write(thumbnail, fileType, baos);
        baos.flush();
        
        // get byte
        byte[] imageInByte = baos.toByteArray();
       
        // close stream
        baos.close();
        
        // convert byte array to base64 string and concat string
        base64Img = base64split[0]+";base64,"+  new String(Base64.encodeBase64(imageInByte));
        
        // convert to byte array 
        return base64Img.getBytes();
        
    }
	
	
	
	
}
