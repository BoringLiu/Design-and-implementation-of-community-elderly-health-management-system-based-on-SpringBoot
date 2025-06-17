package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.HealthInfo;
import cn.borings.mpdemo.entity.Views;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CountRepository extends JpaRepository<Views, Long> {
    Views findByUrl(String url);
}
