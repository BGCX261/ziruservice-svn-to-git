package cn.ziroom.contract.service;

import java.util.ArrayList;
import java.util.List;

import cn.common.util.BeanUtils;
import cn.common.util.UUIDFactory;
import cn.ziroom.contract.dao.HouseAndRoomDao;
import cn.ziroom.contract.data.ConfigData;
import cn.ziroom.contract.data.HouseData;
import cn.ziroom.contract.data.RegionData;
import cn.ziroom.contract.data.RoomData;
import cn.ziroom.contract.data.RoomPicturesData;
import cn.ziroom.contract.domain.Config;
import cn.ziroom.contract.domain.House;
import cn.ziroom.contract.domain.Room;
import cn.ziroom.contract.domain.RoomPictures;
import cn.ziroom.contract.mapper.ConfigMapper;
import cn.ziroom.contract.mapper.HouseMapper;
import cn.ziroom.contract.mapper.RoomMapper;
import cn.ziroom.contract.mapper.RoomPicturesMapper;
import cn.ziroom.util.CreateRadomNum;
import cn.ziroom.util.WatermarkThread;

/**
 * 房间业务处理类
 * 
 * @author Administrator
 * 
 */
public class RoomService {

	private HouseMapper houseMapper;

	private RoomMapper roomMapper;

	private ConfigMapper configMapper;

	private RoomPicturesMapper roomPicturesMapper;

	private HouseAndRoomDao houseAndRoomDao;

	/**
	 * 房间配置物品业务处理方法
	 * 
	 * @param houseData
	 */
	public String synchroRoomConfig(RoomData roomData) {
		/*
		 * try{ ConfigValidate.validate(roomData); }catch(ValidateException e){
		 * System.out.println("[Error]:" + e.getMessage()); return "[Error]:" +
		 * e.getMessage(); }
		 */
		// 根据房间编号删除房间配置的物品信息
		configMapper.deleteByRoomCode(roomData.getSysRoomId());

		// 获得房间配置物品信息
		for (ConfigData cd : roomData.getConfigList()) {
			Config c = new Config();
			BeanUtils.copyProperties(cd, c);
			configMapper.insert(c);
		}
		return "success";
	}

	/**
	 * 房屋或房间预订业务处理方法
	 * 
	 * @param houseCode
	 * @param roomCode
	 */
	public String synchroReservation(HouseData houseData) {
		if (houseData.getRoomData() != null) {
			for (RoomData rd : houseData.getRoomData()) {
				Room r = new Room();
				// BeanUtils.copyProperties(rd, r);
				r.setSysHouseId(rd.getSysHouseId());
				r.setSysRoomId(rd.getSysRoomId());
				r.setRoomStatus(rd.getRoomStatus());
				r.setRentStatus(rd.getRentStatus());
				roomMapper.update(r);
			}
		}
		House h = new House();
		// BeanUtils.copyProperties(houseData, h);
		h.setHouseStatus(houseData.getHouseStatus());
		h.setRentStatus(houseData.getRentStatus());
		h.setSysHouseId(houseData.getSysHouseId());
		h.setRentNum(houseAndRoomDao.countFreeNumber(houseData.getSysHouseId()));
		houseMapper.update(h);
		return "success";
	}

	/**
	 * 添加房屋基本信息同步业务处理方法
	 * 
	 * @param houseData
	 */
	public void synchroAddHouse(HouseData houseData) {
		synchroHouse(houseData);
	}

	/**
	 * 修改房屋基本信息同步业务处理方法
	 * 
	 * @param houseData
	 */
	public void synchroUpdateHouse(HouseData houseData) {
		synchroHouse(houseData);
	}

	/**
	 * 删除房屋基本信息同步业务处理方法
	 * 
	 * @param houseData
	 */
	public void synchroDelHouse(HouseData houseData) {
		// 删除房屋
		houseMapper.deleteById(houseData.getSysHouseId());
		List<RoomData> list = houseData.getRoomData();
		if (list != null) {
			for (RoomData rd : list) {
				roomMapper.deleteById(rd.getSysRoomId());
			}
		}
	}

	/**
	 * 同步房屋基本信息业务处理方法
	 * 
	 * @param houseData
	 */
	public String synchroHouse(HouseData houseData) {
		/*
		 * if(houseData.getSysContractId() == null) {
		 * System.out.println("[Error]:房屋中合同唯一标识不存在"); return
		 * "[Error]:房屋中合同唯一标识不存在"; } if(houseData.getSysHouseId() == null) {
		 * System.out.println("[Error]:房屋唯一标识不存在"); return "[Error]:房屋唯一标识不存在";
		 * } if(!StringUtils.isEmpty(houseData.getHouseCode())) {
		 * System.out.println("[Error]:房屋编号不存在"); return "[Error]:房屋编号不存在"; }
		 */
		House h = houseMapper.selectByCode(houseData.getSysHouseId());
		if(h == null) {
			return "房屋不存在";
		}
		HouseData hd = new HouseData();
		BeanUtils.copyProperties(h, hd);
		House house = new House();

		//String houseTitle = houseAndRoomDao.createHouseTitle(hd);

		BeanUtils.copyProperties(houseData, house);
		house.setRentNum(houseAndRoomDao.countFreeNumber(house.getSysHouseId()));
		if (h != null) {
			//house.setTitle(houseTitle);
			houseMapper.update(house);
			// } else {
			// house.setIsTop("N");
			// house.setIsShow("N");
			// house.setIsAvailable("N");
			// house.setIsPromotions("N");
			// houseMapper.insert(house);
		}
		return "success";
	}

	/**
	 * 添加房屋的房间信息同步业务处理
	 * 
	 * @param roomData
	 */
	public void synchroAddRoom(RoomData roomData) {
		synchroRoom(roomData);
	}

	/**
	 * 修改房屋的房间信息同步业务处理
	 * 
	 * @param roomData
	 */
	public void synchroUpdateRoom(RoomData roomData) {
		synchroRoom(roomData);
	}

	/**
	 * 删除房屋的房间信息同步业务处理
	 * 
	 * @param roomData
	 */
	public void synchroDelRoom(RoomData roomData) {
		roomMapper.deleteById(roomData.getSysRoomId());
		// 更改房屋空闲房间数量
		House h = houseMapper.selectByCode(roomData.getSysHouseId());
		House house = new House();
		house.setHouseCode(h.getHouseCode());
		house.setRentNum(houseAndRoomDao.countFreeNumber(h.getSysHouseId()));
		houseMapper.update(house);
	}

	/**
	 * 删除房间区域
	 * 
	 * @param imageCode
	 */
	public String synchroDelRoomRegion(Integer roomCode, String key, Integer sysHouseId) {
		/*
		 * if(roomCode == null) { System.out.println("[Error]:房间标识不存在"); return
		 * "[Error]:房间标识不存在"; }
		 * if(!DictBuilder.containsKey(DictBuilder.REGION_TYPE
		 * ,roomCode.toString())) { System.out.println(
		 * "[Error]: 区域只能包含saloon,kitchen,toliet,balcony,garder,terrace");
		 * return "[Error]: 区域只能包含saloon,kitchen,toliet,balcony,garder,terrace";
		 * }
		 */
		Room r = new Room();
		r.setSysRoomId(roomCode);
		r.setSysHouseId(sysHouseId);
		if (key.equalsIgnoreCase("saloon")) {
			roomMapper.saloon(r);
		} else if (key.equalsIgnoreCase("kitchen")) {
			roomMapper.kitchen(r);
		} else if (key.equalsIgnoreCase("toliet")) {
			roomMapper.toilet(r);
		} else if (key.equalsIgnoreCase("balcony")) {
			roomMapper.balcony(r);
		} else if (key.equalsIgnoreCase("garder")) {
			roomMapper.garder(r);
		} else if (key.equalsIgnoreCase("terrace")) {
			roomMapper.terrace(r);
		}
		return "success";
	}

	/**
	 * 房间数据同步业务处理
	 * 
	 * @param roomData
	 */
	public String synchroRoom(RoomData roomData) {
		/*
		 * if(roomData.getSysRoomId() == null) {
		 * System.out.println("[Error]:房间唯一标识不存在"); return "[Error]:房间唯一标识不存在";
		 * } if(roomData.getSysHouseId() == null) {
		 * System.out.println("[Error]:房屋唯一标识不存在"); return "[Error]:房屋唯一标识不存在";
		 * } if(!StringUtils.isEmpty(roomData.getHouseCode())) {
		 * System.out.println("[Error]:房屋编号不存在"); return "[Error]:房屋编号不存在"; }
		 * if(!roomData.getRoomType().equals("KITCHEN")) {
		 * if(!StringUtils.isEmpty(roomData.getRoomCode())) {
		 * System.out.println("[Error]:房间编号不存在"); return "[Error]:房间编号不存在"; } }
		 */
		Room rm = new Room();
		rm.setSysRoomId(roomData.getSysRoomId());
		rm.setSysHouseId(roomData.getSysHouseId());
		Room r = roomMapper.selectByCode(rm);
		
		Room room = new Room();
		BeanUtils.copyProperties(roomData, room);

		House h = houseMapper.selectByCode(roomData.getSysHouseId());
		if(h == null) {
			return "房屋不存在";
		}
		HouseData hd = new HouseData();
		BeanUtils.copyProperties(h, hd);

		//String houseTitle = houseAndRoomDao.createHouseTitle(hd);

		if (!room.getRoomType().equals("KITCHEN")) {
			//room.setRoomName(houseAndRoomDao.createRoomTitle(houseTitle, room.getRoomPosition()));
		}

		if (r != null) {
			// TODO 先处理：先删除房间区域（以后修正）
			roomMapper.saloon(r);
			roomMapper.kitchen(r);
			roomMapper.toilet(r);
			roomMapper.balcony(r);
			roomMapper.garder(r);
			roomMapper.terrace(r);
			// 房间区域信息
			addRegion(room, roomData.getRegionDataList());
			roomMapper.update(room);
		} else {
			addRegion(room, roomData.getRegionDataList());
			room.setIsAvailable("N");
			room.setIsPromotions("N");
			room.setIsShow("N");
			room.setIsTop("N");
			room.setRadomNum(CreateRadomNum.createNum());
			roomMapper.insert(room);
		}
		// 更改房屋空闲房间数量

		if (h != null) {
			House house = new House();
			house.setHouseCode(h.getHouseCode());
			house.setRentNum(houseAndRoomDao.countFreeNumber(h.getSysHouseId()));
			houseMapper.update(house);
		}
		return "success";
	}

	/**
	 * 数据同步房屋图片
	 * 
	 * @param roomPicturesData
	 */
	public String synchroRoomPictures(RoomData roomData) {
		/*
		 * if(roomData.getSysRoomId() == null) {
		 * System.out.println("[Error]:房间唯一标识不存在"); return "[Error]:房间唯一标识不存在";
		 * } if(roomData.getSysHouseId() == null) {
		 * System.out.println("[Error]:房屋唯一标识不存在"); return "[Error]:房屋唯一标识不存在";
		 * } for (RoomPicturesData rpd : roomData.getPictList()) {
		 * if(rpd.getSysHouseId() == null) {
		 * System.out.println("[Error]:房间图片中房屋没有唯一标识"); return
		 * "[Error]:房间图片中房屋没有唯一标识"; } if(rpd.getSysRoomId() == null) {
		 * System.out.println("[Error]:房间图片中房间没有唯一标识"); return
		 * "[Error]:房间图片中房间没有唯一标识"; }
		 * if(!StringUtils.isEmpty(rpd.getHouseCode())) {
		 * System.out.println("[Error]:房间图片中房屋编号不存在"); return
		 * "[Error]:房间图片中房屋编号不存在"; }
		 * if(!StringUtils.isEmpty(rpd.getHouseCode())) {
		 * System.out.println("[Error]:房间图片中房屋编号不存在"); return
		 * "[Error]:房间图片中房屋编号不存在"; }
		 * if(!StringUtils.isEmpty(rpd.getImagepath())) {
		 * System.out.println("[Error]:房间图片中图片路径不存在"); return
		 * "[Error]:房间图片中图片路径不存在"; } }
		 */
		RoomPictures rps = new RoomPictures();
		rps.setSysHouseId(roomData.getSysHouseId());
		rps.setSysRoomId(roomData.getSysRoomId());
		// 删除房屋图片
		roomPicturesMapper.deleteByRoomCode(rps);
		// 更改房屋状态
		House h = new House();
		h.setSysHouseId(roomData.getSysHouseId());
		h.setRentStatus(roomData.getRoomStatus());
		h.setHouseStatus(roomData.getRoomStatus());
		houseMapper.update(h);
		// 更改房间状态
		Room r = new Room();
		r.setSysRoomId(roomData.getSysRoomId());
		r.setRentStatus(roomData.getRentStatus());
		r.setRoomStatus(roomData.getRentStatus());
		roomMapper.update(r);
		// 获得图片信息
		List<RoomPicturesData> pictList = roomData.getPictList();
		for (RoomPicturesData rpd : pictList) {
			String[] imagespath = rpd.getImagepath().split(",");
			for (String image : imagespath) {
				RoomPictures rp = new RoomPictures();
				BeanUtils.copyProperties(rpd, rp);
				String imageName = UUIDFactory.createUUID() + ".jpg";
				String path = rpd.getHouseCode() + "/" + rpd.getRoomCode() + "/" + rpd.getImageCate() + "/" + imageName;
				rp.setImagepath(path);
				rp.setFlag("Y");
				WatermarkThread wt = new WatermarkThread(image, path, imageName);
				wt.run();
				roomPicturesMapper.insert(rp);
			}
			// 图片水印
			// cn.ziroom.util.ThreadGroup threadGroup =
			// cn.ziroom.util.ThreadGroup.getInstanct();
			// Thread thread = new Thread(new WatermarkThread(url, path,
			// imageName));
			// threadGroup.addTask(thread);
			// WatermarkThread t = new WatermarkThread();
		}
		return "success";
	}

	public List<String> getRegion() {
		List<String> regions = new ArrayList<String>();
		regions.add("saloon");
		regions.add("kitchen");
		regions.add("toliet");
		regions.add("balcony");
		regions.add("garder");
		regions.add("terrace");
		return regions;
	}

	/**
	 * 房间区域设置
	 * 
	 * @param r
	 * @param regionDataList
	 */
	private void addRegion(Room r, List<RegionData> regionDataList) {
		if (regionDataList != null && regionDataList.size() > 0) {
			for (RegionData region : regionDataList) {
				// 信息对应的相应的房间字典上
				if (region.getRegionType().equalsIgnoreCase("saloon")) {
					r.setSaloonLength(region.getRegionLength());
					r.setSaloonWidth(region.getRegionWidth());
					r.setSaloonHeight(region.getRegionHeight());
					r.setSaloonMaster(region.getSaloonMaster());
					r.setSaloonMaterial(region.getSaloonMaterial());
					r.setSaloonPosition(region.getSaloonPosition());
					r.setSaloonDesc(region.getRegionComment());
				} else if (region.getRegionType().equalsIgnoreCase("kitchen")) {
					r.setKitchenLength(region.getRegionLength());
					r.setKitchenWidth(region.getRegionWidth());
					r.setKitchenHeight(region.getRegionHeight());
					r.setKitchenGastype(region.getKitchenGastype());
					r.setKitchenStove(region.getKitchenStove());
					r.setKitchenDesc(region.getRegionComment());
				} else if (region.getRegionType().equalsIgnoreCase("toliet")) {
					r.setTolietExist("Y");
					r.setToiletLength(region.getRegionLength());
					r.setToiletWidth(region.getRegionWidth());
					r.setToiletHeight(region.getRegionHeight());
					r.setToiletCurtain(region.getToiletCurtain());
					r.setToiletFan(region.getToiletFan());
					r.setToiletWindow(region.getToiletWindow());
					r.setToiletDesc(region.getRegionComment());
				} else if (region.getRegionType().equalsIgnoreCase("balcony")) {
					r.setBalconyExist("Y");
					r.setBalconyLength(region.getRegionLength());
					r.setBalconyWidth(region.getRegionWidth());
					r.setBalconyHeight(region.getRegionHeight());
					r.setBalconyType(region.getBalconyType());
					r.setBalconyDesc(region.getRegionComment());
				} else if (region.getRegionType().equalsIgnoreCase("garder")) {
					r.setGarderExist("Y");
					r.setGardenLength(region.getRegionLength());
					r.setGardenWidth(region.getRegionWidth());
					r.setGardenHeight(region.getRegionHeight());
					r.setGardenType(region.getBalconyType());
					r.setGardenClay(region.getGardenClay());
					r.setGardenDesc(region.getRegionComment());
				} else if (region.getRegionType().equalsIgnoreCase("terrace")) {
					r.setTerraceExist("Y");
					r.setTerraceLength(region.getRegionLength());
					r.setTerraceWidth(region.getRegionWidth());
					r.setTerraceHeight(region.getRegionHeight());
					r.setTerraceDesc(region.getRegionComment());
				}
			}
		}
	}

	public void setHouseMapper(HouseMapper houseMapper) {
		this.houseMapper = houseMapper;
	}

	public void setRoomMapper(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	public void setConfigMapper(ConfigMapper configMapper) {
		this.configMapper = configMapper;
	}

	public void setRoomPicturesMapper(RoomPicturesMapper roomPicturesMapper) {
		this.roomPicturesMapper = roomPicturesMapper;
	}

	public void setHouseAndRoomDao(HouseAndRoomDao houseAndRoomDao) {
		this.houseAndRoomDao = houseAndRoomDao;
	}
}
