package demo.Service.imp;

import demo.Dao.SeatDao;
import demo.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("seatService")
public class SeatServiceImp implements SeatService {

    @Autowired
    private SeatDao seatDao;

    public Map<String,Object>  FindThisSeat(String sno) {
        return seatDao.FindThisSeat(sno);
    }

    public Map<String,Object> FindEveryEmptySeat() {
        return seatDao.FindEveryEmptySeat();
    }

    public Map<String,Object> FindEverySeat() {
        return seatDao.FindEverySeat();
    }

    public Map<String,Object> FindEverySeatOfFloor(String floor, String room) {
        return seatDao.FindEverySeatOfFloor(floor,room);
    }

    public Map<String,Object> FindEveryEmptySeatOfFloorAndRoom(String floor, String room) {
        return seatDao.FindEveryEmptySeatOfFloorAndRoom(floor,room);
    }

    public Map<String, Object> FindEveryEmptySeatOfFloor(String floor){
        return seatDao.FindEveryEmptySeatOfFloor(floor);
    }

    @Override
    public boolean SaveSeatOfUser(String uno,String floor, String room, String sno) {
        return seatDao.SaveSeatOfUser(uno,floor,room,sno);
    }

    @Override
    public boolean DeleteSeatOfUser(String uno) {
        return seatDao.DeleteSeatOfUser(uno);
    }
}
