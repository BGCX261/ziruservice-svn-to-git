package cn.ziroom.house.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.apache.struts2.ServletActionContext;

import cn.common.action.GeneralAction;
import cn.ziroom.house.domain.House;
import cn.ziroom.house.domain.Room;
import cn.ziroom.house.service.HouseService;

/**
 * 房屋请求Action
 * 
 * @author Administrator
 * 
 */
public class HouseAction extends GeneralAction {

	private static final long serialVersionUID = -8272879870120693132L;

	private HouseService houseService;

	private House house = new House();

	private Room room = new Room();

	private String param;

	private String type;

	private List<Room> roomList = new ArrayList<Room>();

	private String fileName;

	private String downFilePath;

	private Long size;

	/**
	 * 获得部门或人员
	 * 
	 * @throws Exception
	 */
	public void getDeptOrPerson() throws Exception {
		String json = houseService.getDeptOrPerson(type, param);
		out(json);
	}

	/**
	 * 房屋主界面请求方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String houseIndex() throws Exception {
		return SUCCESS;
	}

	/**
	 * 搜索房屋请求方法(分页查询)
	 * 
	 * @throws Exception
	 */
	public void searchHouse() throws Exception {
		page(house);
		String json = houseService.searchHouse(house);
		out(json);
	}

	/**
	 * 房间列表界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String roomListPage() throws Exception {
		roomList = houseService.searchRoomByHouseCode(house.getSysHouseId());
		return SUCCESS;
	}

	/**
	 * 房屋发布界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String housePubForm() throws Exception {
		house = houseService.housePubForm(house);
		room = null;
		return SUCCESS;
	}

	/**
	 * 房屋发布请求方法
	 * 
	 * @throws Exception
	 */
	public void pubHouse() throws Exception {
		houseService.pubHouse(house);
	}

	/**
	 * 房间发布界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String roomPubForm() throws Exception {
		room = houseService.roomPubForm(room);
		house = null;
		return SUCCESS;
	}

	/**
	 * 房间发布
	 * 
	 * @throws Exception
	 */
	public void pubRoom() throws Exception {
		houseService.pubRoom(room);
	}

	/**
	 * 房间推荐
	 * 
	 * @throws Exception
	 */
	public void recommendRoom() throws Exception {
		String d = houseService.recommendRoom(room.getSysRoomId());
		out(d);
	}

	/**
	 * 房间优先展示
	 * 
	 * @throws Exception
	 */
	public void priorityRoom() throws Exception {
		String d = houseService.priorityRoom(room.getSysRoomId());
		out(d);
	}

	/**
	 * 房屋详情页
	 * 
	 * @throws Exception
	 */
	public String houseView() throws Exception {
		house = houseService.houseView(house.getSysHouseId());
		return SUCCESS;
	}

	/**
	 * 保存房屋
	 * 
	 * @throws Exception
	 */
	public void saveHouse() throws Exception {
		houseService.saveHouse(house);
	}

	/**
	 * 保存房间
	 * 
	 * @throws Exception
	 */
	public void saveRoom() throws Exception {
		houseService.saveRoom(room);
	}

	/**
	 * 生成房源包
	 * 
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws JRException
	 */
	public String downHouse() throws IOException, JRException, SQLException {
//		Map<String, String> housePackage = houseService.createHousePackage(room);
//		fileName = housePackage.get("fileName");
//		downFilePath = housePackage.get("downFilePath");
//		fileName = new String(fileName.getBytes(), "UTF-8");
//		fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//		File file = new File(downFilePath);
//		size = file.length();
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//		// 响应
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("application/octet-stream" + "");
//		//response.setCharacterEncoding("UTF-8");
//		response.setHeader("content-disposition", "attachment;filename=\"" + fileName + "\"");
//		OutputStream outputStream = response.getOutputStream();
//		if (bis != null) {
//			byte[] bytes = new byte[2048];
//			int buffer = 0;
//			while ((buffer = bis.read(bytes)) != -1) {
//				outputStream.write(bytes, 0, buffer);
//			}
//			outputStream.flush();
//		}
//		if (outputStream != null) {
//			outputStream.close();
//		}
		return SUCCESS;
	}

	/**
	 * 房源包下载
	 * 
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() throws Exception {
		InputStream is = null;
		try {
			Map<String, String> housePackage = houseService.createHousePackage(room);
			fileName = housePackage.get("fileName");
			downFilePath = housePackage.get("downFilePath");
			fileName = new String(fileName.getBytes(), "UTF-8");
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			File file = new File(downFilePath);
			size = file.length();
			is = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
