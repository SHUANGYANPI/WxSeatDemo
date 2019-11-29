package demo.Dao.imp;

import demo.Dao.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("seatDao")
public class SeatDaoImp implements SeatDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> FindThisSeat(String sno) {
        return jdbcTemplate.queryForMap("select * from had_choose where sno=?",sno);
    }

    public Map<String,Object> FindEveryEmptySeat() {
        return jdbcTemplate.queryForMap("select * from had_choose");

    }

    public Map<String,Object> FindEverySeat() {
        return jdbcTemplate.queryForMap("select * from had_choose");

    }

    public Map<String,Object> FindEverySeatOfFloor(String floor, String room) {
        return jdbcTemplate.queryForMap("select * from had_choose where floor=? and room=?",floor,room);

    }

    public List<Map<String, Object>> FindEveryEmptySeatOfFloorAndRoom(String floor, String room) {
        try {
            return jdbcTemplate.queryForList("select no,floor,room,sno from had_choose where floor=? and room=?",floor,room);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String,Object> FindEveryEmptySeatOfFloor(String floor) {
        return jdbcTemplate.queryForMap("select sno from had_choose where floor=?",floor);
    }

    @Override
    public boolean SaveSeatOfUser(String uno,String floor, String room, String sno) {
           try {
               jdbcTemplate.update("insert into had_choose(no,floor,room,sno)values(?,?,?,?)",uno,floor,room,sno);
               return true;
           }catch (Exception e){
               return false;
           }
    }

    @Override
    public boolean DeleteSeatOfUser(String uno) {
        try {
            jdbcTemplate.update("delete from had_choose where no=?",uno);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
