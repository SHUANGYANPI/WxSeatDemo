package demo.Dao;

import java.util.List;
import java.util.Map;

public interface SeatDao {
    Map<String,Object> CheckThisSeat(int id);//查询此座位的使用情况
    Map<String,Object> CheckEverySeat();//查询全部的座位(可能用不上，因为并没有这么大的界面)
    Map<String,Object> CheckEveryEmptySeat();//查询全部的空座位,数据库中is_used值为0的座位
    Map<String,Object> CheckEverySeatOfFloor(int floor, int direction);//查询某个楼层全部的座位,direction中0为南1为北
    Map<String,Object> CheckEveryEmptySeatOfFloorAndDirection(int floor, int direction);//查询某个楼层全部的空座位,direction中0为南1为北
    Map<String,Object> CheckEveryEmptySeatOfFloor(int floor);
}
