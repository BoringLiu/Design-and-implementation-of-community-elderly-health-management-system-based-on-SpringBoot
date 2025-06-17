package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.History;
import cn.borings.mpdemo.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryMapper {
    @Select("SELECT CONCAT(h_info.name, ' - ', history_info.uid, ' - ', history_info.sname, ' - ', history_info.f_date, ' - ', history_info.l_date, ' - ', history_info.level, ' - ', history_info.h_count, ' - ', history_info.ssid) AS full_history FROM h_info INNER JOIN history_info ON h_info.uid = history_info.uid WHERE h_info.uid = #{uid};")
    List<History> selectHistoryByUid(int uid);//通过uid寻找历史病例

    @Select("select * from history_info where sname = #{sname}")
    List<History> selectHistoryBySname(String sname);

    @Select("select * from history_info")
    List<History> selectAllhistory();

    @Insert("INSERT INTO history_info (uid,sid,sname,f_date,l_date,level,h_count) VALUES (#{uid},#{sid},#{sname},#{f_date},#{l_date},#{level},#{h_count})")
    void create(History n);

    @Delete("DELETE from history_info where ssid = #{ssid}")
    void delete(int ssid);
}
