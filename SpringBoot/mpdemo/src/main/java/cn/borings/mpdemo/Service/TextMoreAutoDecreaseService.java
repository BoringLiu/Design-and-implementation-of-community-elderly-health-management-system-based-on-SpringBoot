package cn.borings.mpdemo.Service;

import cn.borings.mpdemo.entity.HealthTips;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextMoreAutoDecreaseService {

    public void Decreaser(List<HealthTips> now){
        for(HealthTips single:now){
            if(single.getIntro().length() >= 30){
                single.setIntro(single.getIntro().substring(0,30)+"...");
            }
            if(single.getContent().length() >= 30){
                single.setContent(single.getContent().substring(0,30)+"...");
            }
        }
        System.out.println("Decreaser finished");
    }
}
