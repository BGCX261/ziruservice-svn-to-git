package cn.common.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import cn.ziroom.house.service.HouseService;

/**
 * jasperreport工具类
 * 
 * @author 孙树林
 * 
 */
public class JasperreportsUtils {

	/**
	 * 生成docx文档
	 * 
	 * @param reportFile
	 * @param conn
	 * @throws JRException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String docx(String reportFile, Map parameter, Connection conn) throws JRException, IOException, SQLException {
		URL s = HouseService.class.getClassLoader().getResource("");
		String tempDir = s.getPath().substring(0, s.getPath().lastIndexOf("WEB-INF")) + "//housePackage/";
		
		// 载入报表文件
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
		// 关闭数据库连接
		conn.close();
		JRDocxExporter exporter = new JRDocxExporter();

		File destFile = new File(tempDir + "\\" + UUIDFactory.createUUID() + ".docx");
		// 设置导出docx参数
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, bis);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		// 执行
		exporter.exportReport();

		return destFile.getPath();
	}
	
	/**
	 * 生成doc文档
	 * 
	 * @param reportFile
	 * @param conn
	 * @throws JRException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String doc(String reportFile, Map parameter, Connection conn) throws JRException, IOException, SQLException {
		URL s = HouseService.class.getClassLoader().getResource("");
		String tempDir = s.getPath().substring(0, s.getPath().lastIndexOf("WEB-INF")) + "//housePackage/";
		
		// 载入报表文件
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
		// 关闭数据库连接
		conn.close();
		JRDocxExporter exporter = new JRDocxExporter();
		
		File destFile = new File(tempDir + "\\" + UUIDFactory.createUUID() + ".doc");
		// 设置导出docx参数
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, bis);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		// 执行
		exporter.exportReport();

		return destFile.getPath();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] xls(String reportFile, Map parameter, Connection conn) throws JRException, IOException, SQLException {
		// 载入报表文件
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
		// 关闭数据库连接
		conn.close();

		JRXlsxExporter exporter = new JRXlsxExporter();

		ByteArrayOutputStream is = new ByteArrayOutputStream();
		BufferedOutputStream bis = new BufferedOutputStream(is);
		File destFile = new File("d:\\1.xls");
		destFile.createNewFile();
		// 设置导出docx参数
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, bis);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

		// 执行
		exporter.exportReport();
		byte bytes[] = is.toByteArray();
		bis.close();
		is.close();

		return bytes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] html(String reportFile, Map parameter, Connection conn) throws JRException, IOException, SQLException {
		// 载入报表文件
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
		// 关闭数据库连接
		conn.close();

		JRHtmlExporter exporter = new JRHtmlExporter();

		ByteArrayOutputStream is = new ByteArrayOutputStream();
		BufferedOutputStream bis = new BufferedOutputStream(is);
		File destFile = new File("d:\\1.html");
		destFile.createNewFile();
		// 设置导出docx参数
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, bis);
		// exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
		// destFile.toString());
		exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "http://pic.ziroom.com.cn/");
		// 执行
		exporter.exportReport();
		byte bytes[] = is.toByteArray();
		bis.close();
		is.close();

		return bytes;
	}
}
