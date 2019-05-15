package demo.Dao.imp;

import demo.Dao.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("seatDao")
public class SeatDaoImp implements SeatDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> CheckThisSeat(int id) {
        return jdbcTemplate.queryForMap("select * from seat where sid=?",int.class,id);
    }

    public Map<String,Object> CheckEveryEmptySeat() {
        return jdbcTemplate.queryForMap("select * from seat where is_used=?",0);

    }

    public Map<String,Object> CheckEverySeat() {
        return jdbcTemplate.queryForMap("select * from seat");

    }

    public Map<String,Object> CheckEverySeatOfFloor(int floor, int direction) {
        return jdbcTemplate.queryForMap("select * from seat where floor=? and direction=?",floor,direction);

    }

    public Map<String,Object> CheckEveryEmptySeatOfFloorAndDirection(int floor, int direction) {
        return jdbcTemplate.queryForMap("select * from seat where floor=? and direction=? and is_used=?",floor,direction,0);
    }

    public Map<String,Object> CheckEveryEmptySeatOfFloor(int floor) {
        return jdbcTemplate.queryForMap("select * from seat where floor=? and is_used=?",floor,0);
    }
}
