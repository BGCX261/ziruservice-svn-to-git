package cn.ziroom.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class WatermarkThread /*implements Runnable*/ {

	private String url;

	private String path;

	private String localPath;

	private String imageName;

	public WatermarkThread() {
		super();
	}

	public WatermarkThread(String url, String path, String imageName) {
		super();
		this.url = url;
		this.path = path;
		this.imageName = imageName;
		URL s = WatermarkThread.class.getClassLoader().getResource("");
		localPath = s.getPath().substring(0, s.getPath().lastIndexOf("WEB-INF"));
	}
	
	//@Override
	public void run() {
		createImageScale();
	}

	private void createImageScale() {
		// 水印图片
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cn/ziroom/util/water_logo.png");
		// 读取图片url
		BufferedImage source;
		try {
			url = "http://pic.ziroom.com.cn/ams/" + url.replace("/amsupload/", "");
			System.out.println("*****url=" + url);
			source = ImageIO.read(new URL(url));
			System.out.println("*****source=" + source);
			source = scale(source, 600, 800, false);
			File outputFile = new File(localPath + "houseImag/web/" + path);
			System.out.println("******outputFile=" + outputFile);
			outputFile.mkdirs();
			
			// 输出图片
			ImageIO.write(source, "jpg", outputFile);
			
			// 创建图片并加上水印
			BufferedImage logo = ImageIO.read(is);
			Graphics g = source.createGraphics();
			g.drawImage(logo, source.getWidth() - 113, source.getHeight() - 113, 113, 113, null);
			g.dispose();

			// 生成缩略图
			String of = (localPath + "houseImag/web/" + path).replaceAll(imageName, "v480x360_" + imageName);
			File outputFile3 = new File(of);
			outputFile3.mkdirs();
			source = scale(source, 360, 480, false);
			ImageIO.write(source, "jpg", outputFile3);

			String of1 = (localPath + "houseImag/web/" + path).replaceAll(imageName, "v180x135_" + imageName);
			File outputFile1 = new File(of1);
			outputFile1.mkdirs();
			source = scale(source, 135, 180, false);
			ImageIO.write(source, "jpg", outputFile1);

			String of2 = (localPath + "houseImag/web/" + path).replaceAll(imageName, "v88x66_" + imageName);
			File outputFile2 = new File(of2);
			outputFile2.mkdirs();
			source = scale(source, 66, 88, false);
			ImageIO.write(source, "jpg", outputFile2);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception t){
			t.printStackTrace();
		}
	}

	private BufferedImage scale(BufferedImage bi, int height, int width, boolean bb) {
		double ratio = 0.0; // 缩放比例
		//Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
			if (bi.getHeight() > bi.getWidth()) {
				ratio = (new Integer(height)).doubleValue() / bi.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue() / bi.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
			//itemp = op.filter(bi, null);
			bi = op.filter(bi, null);
		}
		if (bb) {// 补白
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);
			if (width == bi.getWidth(null)) {
				g.drawImage(bi, 0, (height - bi.getHeight(null)) / 2, bi.getWidth(null), bi.getHeight(null), Color.white, null);
			} else {
				g.drawImage(bi, (width - bi.getWidth(null)) / 2, 0, bi.getWidth(null), bi.getHeight(null), Color.white, null);
			}
			g.dispose();
			bi = image;
		}
		return (BufferedImage) bi;
	}
	
	
}
