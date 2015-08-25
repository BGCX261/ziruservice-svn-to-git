package cn.ziroom.system.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.common.action.GeneralAction;

/**
 * 生成验证码请求Action
 * 
 * @author Administrator
 * 
 */
public class ValidatorCodeAction extends GeneralAction {

	private static final long serialVersionUID = -7713746895602992100L;

	/** 生成验证码需要的字符 */
	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0',
			'1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 生成验证码
	 * 
	 * @throws Exception
	 */
	public void createCode() throws Exception {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = buffImg.createGraphics();

		// 创建一个随机数生成器类
		Random random = new Random();

		// 将图像填充为白色
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, 60, 20);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.PLAIN, 18);
		// 设置字体。
		graphics2D.setFont(font);

		// 画边框。
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(0, 0, 59, 19);

		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
		graphics2D.setColor(Color.BLACK);
//		for (int i = 0; i < 10; i++) {
//			int x = random.nextInt(60);
//			int y = random.nextInt(20);
//			int xl = random.nextInt(12);
//			int yl = random.nextInt(12);
//			graphics2D.drawLine(x, y, x + xl, y + yl);
//		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生 codeCount数字的验证码。
		for (int i = 0; i < 4; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中。
			graphics2D.setColor(new Color(red, green, blue));
			graphics2D.drawString(strRand, (i + 1) * 80 / 8, 16);

			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		//SessionManager.setAttr("code", randomCode.toString());
		// 验证码保存到cookie中
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie cookie = new Cookie("validatorCode", randomCode.toString());
		response.addCookie(cookie);
		ImageIO.write(buffImg, "JPEG", ServletActionContext.getResponse().getOutputStream());
	}

}
