//package vip.incolor;
//
//import net.coobird.thumbnailator.Thumbnails;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.DigestUtils;
//import vip.incolor.constant.Constants;
//import vip.incolor.entity.User;
//import vip.incolor.mapper.ProductStyleMapper;
//import vip.incolor.mapper.ShoppingMapper;
//import vip.incolor.mapper.UserMapper;
//import vip.incolor.utils.PhotoUtil;
//import vip.incolor.utils.QiniuUtil;
//import vip.incolor.vo.PropertyVO;
//
//import javax.annotation.Resource;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.sql.Timestamp;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class IncolorApplicationTests {
//
//    @Resource
//    private UserMapper userMapper;
//
//    @Resource
//    private ProductStyleMapper productStyleMapper;
//
//    @Resource
//    private ShoppingMapper shoppingMapper;
//
//    @Test
//    public void contextLoads() {
//    }
//
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Test
//    public void sendSimpleMail() throws Exception {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("incolor_china@163.com");
//        message.setTo("lzhabc2016@163.com");
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//        mailSender.send(message);
//    }
//
//    @Test
//    public void sendHtmlMail() {
//        MimeMessage message = null;
//        try {
//            message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom("incolor_china@163.com");
//            //helper.setTo("leafyunjim@qq.com");
//            helper.setTo("806812616@qq.com");
//            //helper.setTo("lzhabc2016@163.com");
//            helper.setSubject("标题：发送Html内容");
//
//            StringBuffer sb = new StringBuffer();
//            sb.append("<p style='text-align:left'>请勿回复本邮件.点击下面的链接,验证邮箱</p>")
//                    .append("<a href=http://www.incolor.vip/incolor/html/login-manage.html?" + "sid=")
//                    .append("cascsdcsiuvhwewjfjwwevdvwdv").append("&email=")
//                    .append("806812616@qq.com")
//                    .append(" target='_BLANK'>点击我验证邮箱</a>")
//                    .append("<br/><br/><p>tips:本邮件超过30分钟,链接将会失效，需要重新申请邮箱验证</p>");
//            helper.setSubject("incolor：邮箱验证");
//            helper.setText(sb.toString(), true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mailSender.send(message);
//    }
//
////    @Test
////    public void compress() throws Exception {
////        File dest = new File("G:/phototest/dest.jpg");
////        Thumbnails.of(dest)
////                .scale(1.0f)
////                .outputQuality(0.5f)
////                .toFile(dest);
////    }
//
//    @Test
//    public void md5() {
//        String password = "123456";
//        String digest = DigestUtils.md5DigestAsHex(password.getBytes());
//        System.out.println("digest: " + digest);
//    }
//
//    @Test
//    public void timestamp() throws ParseException {
//        long ms = System.currentTimeMillis();
//        Date now1 = new Date(ms);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now1);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date now2 = calendar.getTime();
//        System.out.println("ms:" + now1.getTime());
//        System.out.println("s:" + now2.getTime());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
//        Date now3 = df.parse(date);
//        System.out.println("other s:" + now3.getTime());
//        System.out.println("in 10 :" + String.valueOf(now2.getTime()).substring(0, 10));
//    }
//
//    @Test
//    public void email() {
//        User user1 = userMapper.selectByAccount("806812616@qq.com");
//        System.out.println(user1.toString());
//    }
//

//    @Test
//    public void modifyEmail() {
//        String passwordMd5 = DigestUtils.md5DigestAsHex(("526756656" + Constants.STATIC_SALT).getBytes());
//        User user1 = userMapper.getByIdAndPassword(78, passwordMd5);
//        System.out.println(user1.toString());
//    }

//    @Test
//    public void modifyPsw() {
//        User user = userMapper.selectByAccountAndPassword("526756656@qq.com", "540d387a6a1a6ca6a9c4296744a85148");
//        System.out.println(user.toString());
//    }
//
//    @Test
//    public void testNormal() {
//        // 设置 30 分钟后过期
//        Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);
//        long date = outDate.getTime() / 100000 * 100000;
//        System.out.println("date: " + date);
//        String secretKey = "806812616@qq.com" + "$" + Constants.STATIC_SALT + "$" + "2d92941c1eb9d88ea9fae02e85c1b6e9";
//        // 产生数字签名
//        String digitalSignature = DigestUtils.md5DigestAsHex(secretKey.getBytes());
//        System.out.println("digitalSignature: " + digitalSignature);
//    }
//
//
//    @Test
//    public void test() throws Exception {
//        PropertyVO vo = new PropertyVO();
//        vo.setProductId(1);
//        vo.setPropertyId(37);
//        vo.setPropertyName("外观颜色");
//        vo.setPropertyValue("黑");
//        vo.setShoppingId(622);
//        shoppingMapper.insertDetail(vo);
//
//        System.out.println("date:  " + vo.getShoppingDetailId());
//
//
//    }
//
//
//    @Test
//    public void test1() {
//        float s = 10.15f;
//        int orderTotalPrice = 1015;
//        if(s*100==orderTotalPrice){
//            System.out.println("55555");
//        }
//        System.out.println("44444"+(s*100-orderTotalPrice));
//        System.out.println(Math.abs(orderTotalPrice-s*100)<0.01);
//    }
//
//    @Test
//    public void test2(){
//        Calendar calendar = Calendar.getInstance();
//        int year = Integer.parseInt("2018");
//        int month = Integer.parseInt("3") - 1;// 2 月，其实是三月，从 0 开始算
//        calendar.set(year, month, 1);
//        int maxDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        for (int j = 1; j <= maxDay; j++) {
//            calendar.set(year, month, j);
//            String time = sdf.format(calendar.getTime());
//            System.out.println(time);
//
//        }
//    }
//
//
//}
