package cn.borings.mpdemo.entity;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@TableName("h_info")
public class HealthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    //健康档案应包含一些老人的个人信息,病史，药品使用，生活习惯等
    private String name;
    private String sex;
    private String birthday;
    public int old;
    private String using_medications;
    private String living_condition;
//    private History history;//获取另一个history的类就行
    private String allergic;

    @Override
    public String toString() {
        return "HealthInfo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", old=" + old +
                ", using_medications='" + using_medications + '\'' +
                ", living_condition='" + living_condition + '\'' +
                ", allergic='" + allergic + '\'' +
                '}';
    }

    public int getuId() {
        return uid;
    }
    public void setuId(int uid) {
        this.uid = uid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getold(){
        if(!birthday.isEmpty()){
            old = oldcal.oldres(birthday);
        }
//        System.out.println(old);
        return old;
    }

    public class oldcal{
        public static int oldres(String birthday){

            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = parseDate(birthday);
            int res = 9999;
            res = calculateAge(birthDate,currentDate);
            return res;

        }

        private static LocalDate parseDate(String birthday){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(birthday, formatter);
        }
        private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
//            System.out.println(birthDate);
//            System.out.println(currentDate);
            // 计算年龄
//            return Period.between(birthDate, currentDate).getYears();
            return (int) ChronoUnit.YEARS.between(birthDate, currentDate);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsing_medications() {
        return using_medications;
    }

    public void setUsing_medications(String using_medications) {
        this.using_medications = using_medications;
    }

    public String getLiving_condition() {
        return living_condition;
    }

    public void setLiving_condition(String living_condition) {
        this.living_condition = living_condition;
    }

//    public History getHistory() {
//        return history;
//    }
//
//    public void setHistory(History history) {
//        this.history = history;
//    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }
}
