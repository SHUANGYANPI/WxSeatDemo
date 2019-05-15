package demo.Service.imp;

import demo.Dao.SeatDao;
import demo.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("seatService")
public class SeatServiceImp implements SeatService {

    @Autowired
    private SeatDao seatDao;

    public Map<String,Object>  CheckThisSeat(int id) {
        return seatDao.CheckThisSeat(id);
    }

    public Map<String,Object> CheckEveryEmptySeat() {
        return seatDao.CheckEveryEmptySeat();
    }

    public Map<String,Object> CheckEverySeat() {
        return seatDao.CheckEverySeat();
    }

    public Map<String,Object> CheckEverySeatOfFloor(int floor, int direction) {
        return seatDao.CheckEverySeatOfFloor(floor,direction);
    }

    public Map<String,Object> CheckEveryEmptySeatOfFloorAndDirection(int floor, int direction) {
        return seatDao.CheckEveryEmptySeatOfFloorAndDirection(floor,direction);
    }

    public Map<String, Object> CheckEveryEmptySeatOfFloor(int floor){
        return seatDao.CheckEveryEmptySeatOfFloor(floor);
    }
}
