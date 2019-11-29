package demo.Dao;

import java.util.List;
import java.util.Map;

public interface SeatDao {
    Map<String,Object> FindThisSeat(String sno);//查询此座位的使用情况
    Map<String,Object> FindEverySeat();//查询全部的座位(可能用不上，因为并没有这么大的界面)
    Map<String,Object> FindEveryEmptySeat();//查询全部的空座位,数据库中is_used值为0的座位
    Map<String,Object> FindEverySeatOfFloor(String floor, String room);//查询某个楼层全部的座位,direction中0为南1为北
    List<Map<String, Object>> FindEveryEmptySeatOfFloorAndRoom(String floor, String room);//查询某个楼层全部的空座位,direction中0为南1为北
    Map<String,Object> FindEveryEmptySeatOfFloor(String floor);
    boolean SaveSeatOfUser(String uno,String floor, String room, String sno);//将此座位被预定的信息填入到数据库中
    boolean DeleteSeatOfUser(String uno);//删除选中的座位
}
