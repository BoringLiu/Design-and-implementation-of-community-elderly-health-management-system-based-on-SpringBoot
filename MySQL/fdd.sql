-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: fdd
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor_info`
--

DROP TABLE IF EXISTS `doctor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_info` (
  `did` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `sex` varchar(2) NOT NULL,
  `condition` varchar(10) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=7005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_info`
--

LOCK TABLES `doctor_info` WRITE;
/*!40000 ALTER TABLE `doctor_info` DISABLE KEYS */;
INSERT INTO `doctor_info` VALUES (7001,'刘红梅','lhm123','Shandong Jinan','女','free','中医'),(7002,'李乐然','llr123','Beijing Dongcheng','男','free','消化内科'),(7003,'王立仁','wlr123','Sichuan ','女','unfree','脑科'),(7004,'陈翠萍','ccp123','Henan','女','free','耳鼻喉科');
/*!40000 ALTER TABLE `doctor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h_info`
--

DROP TABLE IF EXISTS `h_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `h_info` (
  `uid` bigint NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` int NOT NULL,
  `birthday` date NOT NULL,
  `using_medications` int DEFAULT NULL,
  `living_condition` text,
  `allergic` text,
  PRIMARY KEY (`uid`),
  CONSTRAINT `h_info_user_info_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_info`
--

LOCK TABLES `h_info` WRITE;
/*!40000 ALTER TABLE `h_info` DISABLE KEYS */;
INSERT INTO `h_info` VALUES (1,'刘路明',1,'2008-04-03',1234,'熬夜，酗酒','粉尘慢'),(2,'张三',1,'2000-04-03',53,NULL,NULL),(3,'王五',1,'2015-04-03',5412,NULL,NULL),(4,'李四',1,'1997-04-03',534,NULL,NULL),(5,'呵呵哒',0,'1991-04-03',NULL,NULL,NULL),(6,'么么哒',0,'1992-04-03',89,NULL,NULL);
/*!40000 ALTER TABLE `h_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h_monitor`
--

DROP TABLE IF EXISTS `h_monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `h_monitor` (
  `uid` bigint NOT NULL,
  `id` int NOT NULL,
  `checkdate` date NOT NULL,
  `steps` int NOT NULL,
  `xyh` int DEFAULT NULL,
  `xyl` int DEFAULT NULL,
  `eyes` text,
  `avgheart` int DEFAULT NULL,
  `advice` text,
  PRIMARY KEY (`id`),
  KEY `h_monitor_user_info_uid_fk` (`uid`),
  CONSTRAINT `h_monitor_user_info_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_monitor`
--

LOCK TABLES `h_monitor` WRITE;
/*!40000 ALTER TABLE `h_monitor` DISABLE KEYS */;
INSERT INTO `h_monitor` VALUES (1,20240001,'2022-04-08',3,103,94,'良好',83,'减少电子产品使用时间');
/*!40000 ALTER TABLE `h_monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_info`
--

DROP TABLE IF EXISTS `history_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_info` (
  `uid` bigint NOT NULL,
  `sid` int NOT NULL COMMENT 'sick_id',
  `sname` varchar(255) NOT NULL COMMENT 'sickname',
  `f_date` datetime DEFAULT NULL COMMENT 'first',
  `l_date` datetime NOT NULL COMMENT 'last',
  `level` varchar(255) NOT NULL,
  `h_count` int NOT NULL COMMENT 'happened',
  `ssid` int NOT NULL AUTO_INCREMENT COMMENT '记录id',
  PRIMARY KEY (`ssid`),
  KEY `history_info_user_info_uid_fk` (`uid`),
  CONSTRAINT `history_info_user_info_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12345 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_info`
--

LOCK TABLES `history_info` WRITE;
/*!40000 ALTER TABLE `history_info` DISABLE KEYS */;
INSERT INTO `history_info` VALUES (2,109,'哮喘','2024-04-03 19:29:59','2024-04-03 19:21:59','2024-04-03 19:21:59.000000 +00:00',2,2),(2,32,'流感','2024-04-03 19:30:01','2024-04-03 19:22:04','2024-04-03 19:21:57.000000 +00:00',1,12),(4,32,'流感','2024-04-03 19:30:05','2024-04-03 19:22:00','2024-04-03 19:21:54.000000 +00:00',1,23),(6,32,'流感','2024-04-03 19:30:04','2024-04-03 19:22:00','2024-04-03 19:21:55.000000 +00:00',1,45),(5,64,'骨折','2024-04-03 19:30:04','2024-04-03 19:22:02','2024-04-03 19:21:57.000000 +00:00',3,456),(3,109,'哮喘','2024-04-03 19:30:00','2024-04-03 19:22:02','2024-04-03 19:21:58.000000 +00:00',1,563),(1,163,'肺炎','2024-04-03 19:30:03','2012-04-03 19:19:34','2024-04-03 19:19:40.000000 +00:00',2,1234),(3,32,'流感','2024-04-03 19:30:02','2024-04-03 19:22:01','2024-04-03 19:21:56.000000 +00:00',1,8762),(5,163,'肺炎','2024-04-03 19:30:02','2024-04-03 19:22:01','2024-04-03 19:21:56.000000 +00:00',3,12344);
/*!40000 ALTER TABLE `history_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medications`
--

DROP TABLE IF EXISTS `medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medications` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `ldate` date DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
INSERT INTO `medications` VALUES (1001,'孟鲁司特钠',17,'2022-08-08'),(1002,'布地奈德混悬液',9,'2024-04-08'),(1003,'阿莫西林胶囊',32,'2021-08-13'),(1004,'清开灵',68,'2023-04-08'),(1010,'阿萨德',122,'2020-12-12');
/*!40000 ALTER TABLE `medications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `gid` int NOT NULL,
  `uid` bigint NOT NULL,
  `total` bigint NOT NULL,
  `ordername` varchar(255) NOT NULL,
  `orderdate` date DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `order_info_user_info_uid_fk` (`uid`),
  KEY `order_info_service_info_gid_fk` (`gid`),
  CONSTRAINT `order_info_service_info_gid_fk` FOREIGN KEY (`gid`) REFERENCES `service_info` (`gid`),
  CONSTRAINT `order_info_user_info_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3420 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` VALUES (1,1,1,99,'家庭心理指导','2024-04-09',0),(1234,2,1,1342,'asdfc','2024-07-09',0),(3142,3,3,3432,'trfgdsb','2023-04-09',1),(3412,1,2,1234,'fsdav','2024-04-24',0),(3413,1,1,99,'家庭心理指导','2024-04-09',1),(3414,1,1,99,'家庭心理指导','2024-04-09',0),(3415,3,1,169,'家庭体检套餐：尊享','2024-04-09',1),(3416,3,1,169,'家庭体检套餐：尊享','2024-04-09',0),(3417,4,1,229,'家庭体检套餐：全面','2024-04-09',0),(3418,4,1,229,'家庭体检套餐：全面','2024-04-09',1),(3419,3,1,169,'家庭体检套餐：尊享','2024-04-09',1);
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `oid` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`oid`),
  CONSTRAINT `order_status_order_info_oid_fk` FOREIGN KEY (`oid`) REFERENCES `order_info` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,0),(1234,1),(3412,0),(3418,0),(3419,0);
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_info`
--

DROP TABLE IF EXISTS `service_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_info` (
  `gid` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `intro` text,
  `cond` int NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_info`
--

LOCK TABLES `service_info` WRITE;
/*!40000 ALTER TABLE `service_info` DISABLE KEYS */;
INSERT INTO `service_info` VALUES (1,'家庭心理指导',99,'心理医生上门问诊，帮助老人持续心理健康',1),(2,'家庭体检套餐：基础',129,'医护人员上门进行简单体检：包含基础血压，眼鼻喉等项目',0),(3,'家庭体检套餐：尊享',169,NULL,1),(4,'家庭体检套餐：全面',229,NULL,1),(5,'家庭小帮手',159,'日结',1),(6,'家庭大帮手',799,'周付',0),(7,'老人陪伴',199,NULL,1),(9,'asdasdasd',1,'asdasdasd',0),(10,'123',123,'123',0),(11,'1234',123,'123',0),(12,'12345',123,'123',0),(13,'123ghfdsgfdsfgdsfgs',123,'123',0),(14,'六脉',999,'(*´▽｀)ノノ',0),(15,'Java程序检查',99999,'Java程序检查调试',0),(16,'Java程序检查.',999,'1',0);
/*!40000 ALTER TABLE `service_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tips`
--

DROP TABLE IF EXISTS `tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tips` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `author` varchar(20) NOT NULL,
  `intro` text NOT NULL,
  `p_time` datetime NOT NULL COMMENT 'publish',
  `content` longtext NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=1024 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tips`
--

LOCK TABLES `tips` WRITE;
/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
INSERT INTO `tips` VALUES (1001,'健康饮食抵御心血管疾病','meal','刘振东','如何饮食才能更好地抵御心血管疾病呢，今天就带大家来一起看一下如何去搭配平日里健康的食材，使其发挥的功效更好。','2024-04-02 13:06:45','均衡飲食\n均衡飲食是指每天按「健康飲食金字塔」的建議進食，日常飲食佔最多的應是穀物類，並多吃蔬菜類及水果類，吃適量的肉、魚、蛋及代替品如乾豆和奶類及代替品如加鈣豆奶。盡量少吃含高油、鈉（鹽）、糖類的食物。\n\n1. 多進食蔬菜及水果\n蔬菜及水果含豐富的維生素、礦物質及纖維素。\n宜多選擇不同顏色和種類的蔬菜如菜心、西蘭花、椰菜、菠菜、紅蘿蔔、茄子等及水果如橙、蘋果、木瓜、奇異果、香蕉、火龍果等。\n2. 多選擇含高纖維素的食物\n多進食含較高水溶性纖維素的食物，有助降低「低密度脂蛋白膽固醇」 （俗稱「壞膽固醇」）以預防心臟病。\n含較高水溶性纖維素的食物包括蔬菜、水果、麥皮、乾豆類如黃豆、紅豆等。\n由於果汁所含的纖維素甚低，因此不可作纖維素的主要來源。\n3. 選擇低脂肪的肉類、乾豆類及多進食魚類\n宜選購低脂肪的瘦肉、去皮的家禽和不經油炸的豆類製品。\n魚類方面可多選擇含豐富奧米加3脂肪酸的魚如三文魚、吞拿魚、沙甸魚、龍脷魚等，但要避免使用高脂肪的烹調方法如煎、炸或採用高脂肪醬汁如白汁和沙律醬等。\n4. 選用低油、鹽、糖烹調法\n多選用低脂肪的烹調法如蒸、炆、白灼、燉、焗等。宜使用易潔鑊或用少油快炒的方法，以減少用油量。\n適量選用植物油如芥花籽油、花生油、粟米油和煮食用橄欖油等作烹調之用；不宜選用含高飽和脂肪的豬油、牛油、雞油等；烹調時使用量匙或油壺，可減少用油的分量。\n宜選用天然調味料如姜、蔥、蒜頭等，以減少鈉的分量，有助控制血壓水平。\n宜減少使用含高糖分的汁料及調味料烹調，如甜酸醬及砂糖等，從而避免因過量攝取糖分而導致肥胖。\n提防進食影響心臟健康的食物\n影響心臟健康的食物包括含高飽和脂肪、反式脂肪、鈉和膽固醇的食物，過量進食會增加患上心血管疾病的風險。\n\n1.限制含高飽和脂肪的食物\n飽和脂肪多存在於動物類食物，例如帶脂肪或連皮的肉類如燒肉、腩肉、雞翼和雞腳以及全脂奶類食品。\n除了各類動物油脂如豬油和牛油外，某些植物類食物，例如：椰子油、棕櫚油和可可油亦含較高飽和脂肪。\n2.限制含反式脂肪的食物\n反式脂肪大多是由液態植物油加工變成固態脂肪時產生的，加工的過程稱為氫化反應。\n不少加工食品均含反式脂肪，例如炸薯條、薯片、沙翁、酥餅、牛角包、蛋糕、夾心餅、曲奇餅等。\n要限制反式脂肪的攝取，於選擇預先包裝的食品如麵包、餅乾時，應先閱讀營養標簽，選擇含較少總脂肪及反式脂肪的產品。\n3.限制含高鈉的食物\n經常進食含高鈉的食物容易導致高血壓，因此應多吃新鮮食物，避免醃製、罐頭或加入大量調味料的食物如梅菜、榨菜、豆豉、鹹魚、香腸和午餐肉等。\n選用天然調味料如姜、蔥、蒜頭和胡椒粉等，也有助減少攝取鈉。\n4.限制含高糖分的食物及飲品\n過量進食含糖的食物及飲品，加上體能活動不足，容易導致肥胖，增加患上冠心病的機會。\n為了保持適中體重，宜減少進食或飲用加入大量糖分的食物及飲品，如蛋糕、甜餅幹和汽水等。\n關於進食含膽固醇食物的建議\n膽固醇只存在於動物類食物中，例如：蛋黃、奶類、海產類、肉類和家禽類。現時未有足夠的證據就膽固醇的攝取限量作出建議，但根據美國國家醫學研究院的建議，膽固醇的攝取量應是越少越好。\n為心臟健康著想，膽固醇含量高的食物例如：動物（包括海鮮）的內臟，如豬肺、牛肚、鵝肝、魚頭、魚子等應吃得越少越好。\n某些含高膽固醇同時含高飽和脂肪的食物，例如：豬頸肉、豬腩排、煙肉、部分內臟如豬腸和牛脷，更要避免進食。\n對於健康人士，一些含高膽固醇但飽和脂肪相對較低的的食物如雞蛋、蝦肉、魷魚等，可作為均衡飲食中的一部分酌量進食，並與「肉、魚、蛋及代替品」中的各類食物交替地選吃。\n患有血脂異常的人士，特別是患有糖尿病或有心臟衰竭風險的人士，建議尋求營養師提供有關含膽固醇食物的飲食建議。\n如對以上飲食建議有任何疑問，請向營養師或其他醫護人員查詢。'),(1002,'【全国爱肝日】特辑 乙肝治愈新篇章：乙肝感染20年，可以“逆袭”了','method','北京市垂杨柳医院','你会选择一个乙肝患者作为伴侣吗？\n\n当得知自己患有乙肝时，你会感到有精神上的压力和折磨吗？\n\n知道你有乙肝，身边的人会把当作“行走的传染源”吗？\n\n乙肝患者是不是注定会肝硬化、肝癌的三部曲？\n\n无数次患者及家属来诊时的倾诉，让我们无时不刻希望帮助患者摘掉乙肝的帽子。\n\n大家期待的乙肝临床治愈来了。\n\n乙肝感染20年，可以“逆袭”了','2024-04-03 00:00:00','小北，今年38岁，20年前体检时发现乙肝，家族没有肝炎病史，他一直忙于工作未进行诊治。近期同单位的老王因为患乙肝肝硬化、肝癌去世了，小北慌了，急忙来医院感染科就诊。医生给他做了检查，发现小北属于乙肝功能性治愈的优势人群，完善检查后给予抗病毒治疗。使用药物期间小北有些乏力、轻度发热，但很快就好转了。经过一年的治疗，小北的乙肝表面抗原降为0，提示乙肝转阴。为进一步巩固治疗，小北又继续治疗了3个月，复查出现了乙肝表面抗体。小北对治疗非常有信心，等乙肝表面抗体滴度升高后就可以停药了。小北乙肝感染20年，终于可以“逆袭”了。\n\n乙肝真的可以临床治愈吗？\n\n从1990年至2019年，尽管全球范围内由乙型肝炎引起的肝病发生率下降了4.51%；但是中国乙型肝炎导致的肝病患者绝对数量仍然占全球约30%，位居首位【1】。我国乙型肝炎诊断率为22%，治疗率仅为17%，距离WHO 2030年目标（90%/80%）仍有很大距离【2】。\n\n为了改善现状，全球医学界一直在努力。2016年9月8日-9日，AASLD和EASL两大权威机构组织了关于乙肝治疗终点的研讨会，旨在就慢乙肝治疗终点达成共识。2017年由Anna S. Lok教授作为通讯作者将治愈共识声明【3】同时发表在Hepatology及Journal of Hepatology上。2019年12月，美国国立卫生研究院（NIH）发布了Trans-NIH治愈乙肝研究战略计划，从此乙肝治愈已成为全球战略目标。\n\n什么是乙肝临床治愈？\n\n乙肝临床治愈，简单来说，就是通过治疗使乙肝患者的病毒复制得到长期控制，肝功能恢复正常，且HBsAg持续转阴，从而减轻肝脏的炎症和纤维化，降低肝硬化和肝癌的风险。乙肝临床治愈并非容易，这些患者是幸运儿。\n\n谁是幸运儿？如何实现乙肝临床治愈？\n\n目前，抗病毒治疗是乙肝治疗的核心手段。抗病毒药物主要包括核苷（酸）类药物和干扰素两大类。这两种药物各有优势，核苷（酸）药物可以直接抑制HBV复制，强效降低病毒载量，但不能有效抑制cccDNA产生；干扰素通过病毒学和免疫学双重机制抑制HBV。当这两者联合起来，就能大大提高HBsAg清除率。\n\n幸运儿也就是我们说的优势人群，乙肝表面抗原要低。也就是HBsAg数值。数值越低则说明体内检测到乙型肝炎病毒越少，治愈的可能性就更高。当然，对于部分非活动性的HBsAg携带者（乙肝表面抗原携带者），其HBsAg值很低的时候，特别是HBsAg值<100IU/ml，乙肝临床治愈的比例也是很高的，有研究数据表明，其治愈率可以达到60%~80%以上。其中特殊人群，如慢性乙肝儿童、青少年、产后半年的女性，因为身体免疫比较活跃，也是乙肝临床治愈的优势人群。\n\n乙肝患者和上述特殊人群快去医院感染科测测乙肝表面抗原，说不定你也是幸运儿。\n\n乙肝临床治愈的研究\n\n2018年4月19日，在北京人民大会堂正式启动的中国慢性乙型肝炎临床治愈（珠峰）工程项目得到了国家领导的高度关注和支持，，标志着我国乙肝治疗领域迈向了全新的阶段。截至2022年11月底，该项目珠峰项目已吸引了26549例患者有效入组，其广泛影响力及大量成功案例有力证明了通过科学规范的治疗手段，乙肝临床治愈已成为可能。在这之中，4573名患者成功实现了临床治愈，这一成果为乙肝患者群体带来了极大的希望与鼓舞。\n\n该项目珠峰项目数据显示【4】，随着患者基线HBsAg水平的降低，48周HBsAg清除率也呈现出逐渐增加的趋势。具体而言，当基线HBsAg水平在1500-1000 IU/mL时，清除率为33.2%至36.3%；下降到500-200 IU/mL时，清除率升至42.9%至50.6%；而当基线水平进一步降至100 IU/mL时，清除率高达56.1%。值得一提的是，即使在48周内未达到完全治愈标准的患者中，仍有66.6%的患者其HBsAg水平降到了100 IU/mL，这也意味着他们从治疗中获得了显著的病情改善。\n\n近期，石小枫教授团队有医疗科研团队发表了一项关于慢性乙型肝炎病毒（HBV）感染患者接受聚乙二醇干扰素α（PEG IFNα）治疗的研究【5】。该研究回顾性地分析了141例免疫控制期（IHCs）患者和164例核苷（酸）类似物（NA）经治患者的数据，以评估PEG IFNα治疗在实现HBsAg清除方面的疗效。\n\n研究结果显示，IHCs和NA经治患者基于PEG IFNα治疗48周的HBsAg清除率均超过50%，分别为65.5%和52.9%。这一发现表明，PEG IFNα治疗在这两类患者中均具有较高的临床治愈率。这再次表明低基线HBsAg水平可能是预测PEG IFNα治疗成功的重要因素。\n\n结语：\n\n乙肝临床治愈的时代已经到来，请大家相信，随着医学的不断进步，我们一定能够找到更有效的治疗方法，帮助更多的患者实现功能性治愈，重返健康生活！乙肝治疗并非一蹴而就的过程。患者需要保持耐心和信心，积极配合医生的治疗建议，定期进行复查和调整治疗方案。乙肝并不可怕，功能性治愈并非遥不可及。只要我们选择正确的治疗方案，坚持治疗，相信科学，就一定能够战胜乙肝，重拾健康人生。\n\n让我们一起携手，迈向乙肝功能性治愈的“逆袭”吧！'),(1003,'清明时节，听营养科医生怎么说','科普','北京中医医院怀柔医院','4月5日是清明节，也是春季的第五个节气。清明时值暮春，气候多变，应该如何养生呢？清明时节，风干燥，加上人体内肝火旺盛，内外相结合，就容易出现口干、鼻干等症状，这个时节要多饮水。饮食方面，以平肝补肾润肺为主，以健脾扶阳祛湿为食养原则，姜、葱、韭菜宜适度进食，要避免吃燥性、刺激性食物，如羊肉、辣椒等，多吃新鲜上市的果蔬，以下几种时令蔬菜就不错。','2024-04-02 03:47:03','荠菜\n\n清明前后的春天，肝阳上亢的人，特别容易出现头痛、昏眩，慢性气管炎也易在春季发作。荠菜可以降血压、健胃消食、疏通肠胃，治疗胃痉挛、胃溃疡、肠炎等。另外，荠菜还具有强筋健骨、明目养肝、润肺和中的作用。荠菜的营养价值非常高，含有蛋白质、胡萝卜素、钙、铁、磷以及维生素B1、B2、C等，有助于增强免疫功能，适合清明时节食用。\n\n香椿\n\n香椿一般在清明时节发芽，谷雨前后采摘，这种头茬椿芽，香味浓郁。香椿的嫩芽可用于制作香椿炒鸡蛋、香椿竹笋、香椿拌豆腐等。它不仅营养丰富，且具有较高的药用价值。中医记载香椿叶味苦，性平，具有消炎、解毒、杀虫的功效，也可用于治痔疮、痢疾。\n\n韭菜\n\n说到春天要吃的东西，不得不提到韭菜。韭菜属于“瘦物”，因含有较多的膳食纤维，可帮助瘦身并促进食欲。韭菜的独特辛香味源自其所含的硫化物，这些硫化物有一定的杀菌消炎作用，有助于人体提高免疫力，还能帮助人体吸收维生素B1及维生素A，因此韭菜若与维生素B1含量丰富的猪肉类食品互相搭配，是比较营养的吃法。不过，硫化物遇热易于挥发，因此烹调韭菜时需要急火快炒，若加热过火，便会失去韭菜的风味。\n\n总之，清明节虽然是一个祭祖扫墓的节日，但我们也要关注自己的健康。中医养生提倡平衡和谐的生活方式，通过合理饮食、适度运动、调节情绪、养护肝脏等方法，可以增强身体的健康和抵抗力。希望大家在清明节期间，能够将中医养生的理念融入到日常生活中，度过一个健康、愉快的节日。'),(1014,'阿萨德联发科VB缴纳说法lkfasflgkvj','','ccp','nihao','2024-04-07 22:14:09','zheshiyitiaoxinxi'),(1017,'Tips11111ab','','134','45人24','2024-04-08 15:08:16','farsv'),(1018,'Tips11111abc','','134','45人24','2024-04-08 15:08:19','farsv'),(1020,'123123','','123123123','123123123','2024-05-04 01:09:41','123123123123123'),(1021,'123123123','','123123123','123123123123123123','2024-05-04 01:15:22','1231231231231241235r134f2345wf5e gsdfvgwerfgasdgsdf'),(1022,'1231231234','','123123123','123123123123123123','2024-05-04 01:15:42','1231231231231241235r134f2345wf5e gsdfvgwerfgasdgsdf'),(1023,'如何保持心脏健康','','LBR','今天介绍一种新方法....','2024-05-04 01:22:18','今天很好谢谢...');
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `reg_date` date NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `sex` varchar(1) NOT NULL,
  `condition` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'luming','2024-01-02','123433','shandong',189378465,'男','良好'),(2,'lisi','2024-04-23','sdfghb4','shanghai',21345462,'女','很好'),(3,'xiaoming','2024-03-02','13rfd','beijing',13242,'男','一般'),(4,'zhangsan','2024-04-03','4153r2f','nanjing',12345436,'男','一般'),(5,'wangwu','2024-04-25','1243rf','changyi',14314341,'男','不太好'),(6,'tanliu','2024-04-07','1t35rgerf','weihai',12348912,'女','不好'),(7,'undefined','2024-04-07','asdfasvf','hainan',1234465,'女','良好');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `views_count`
--

DROP TABLE IF EXISTS `views_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `views_count` (
  `tid` int NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `views` int DEFAULT '0',
  PRIMARY KEY (`tid`),
  UNIQUE KEY `url` (`url`),
  CONSTRAINT `views_count_tips_tid_fk` FOREIGN KEY (`tid`) REFERENCES `tips` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `views_count`
--

LOCK TABLES `views_count` WRITE;
/*!40000 ALTER TABLE `views_count` DISABLE KEYS */;
INSERT INTO `views_count` VALUES (1001,NULL,32),(1002,NULL,56),(1003,NULL,123);
/*!40000 ALTER TABLE `views_count` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09  0:43:20
