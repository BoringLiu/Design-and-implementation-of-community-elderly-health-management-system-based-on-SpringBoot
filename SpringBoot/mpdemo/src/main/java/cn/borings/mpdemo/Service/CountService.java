package cn.borings.mpdemo.Service;//package cn.borings.mpdemo.Service;
//
//import cn.borings.mpdemo.entity.Views;
//import cn.borings.mpdemo.mapper.CountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Service
////@Repository
//public class CountService {
//
//    @Autowired
//    private static CountRepository countRepository;
//    public static void incrementPageView(String url) {
//        Views view = countRepository.findByUrl(url);
//        if (view != null) {
//            view.setViews(view.getViews() + 1);
//            countRepository.save(view);
//        } else {
//            Views newPage = new Views();
//            newPage.setUrl(url);
//            newPage.setViews(1); // 初始浏览量为 1
//            countRepository.save(newPage);
//            // 页面不存在，可以选择创建新页面记录或者忽略
//        }
//    }
//}

import cn.borings.mpdemo.entity.Views;
import cn.borings.mpdemo.mapper.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService {

    @Autowired
    private CountRepository countRepository;

    public void incrementPageView(String url) {
        Views view = countRepository.findByUrl(url);
        if (view != null) {
            view.setViews(view.getViews() + 1);
            countRepository.save(view);
        } else {
            Views newPage = new Views();
            newPage.setUrl(url);
            newPage.setViews(1); // 初始浏览量为 1
            countRepository.save(newPage);
            // 页面不存在，可以选择创建新页面记录或者忽略
        }
    }
}
