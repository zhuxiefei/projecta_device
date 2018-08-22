package com.bdcourtyard.business.login.rest;

import com.bdcourtyard.business.account.domain.UpdatePwdReq;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.account.model.Privilege;
import com.bdcourtyard.business.account.service.EmployeeAccountService;
import com.bdcourtyard.business.estate.model.EstateEstate;
import com.bdcourtyard.business.login.model.ChooseEstateResp;
import com.bdcourtyard.business.login.model.LoginReq;
import com.bdcourtyard.business.login.model.LoginResp;
import com.bdcourtyard.business.login.service.LoginService;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.ValidateCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by cxx on 2018/7/16.
 */
@RestController
@Api(value = "LoginController", description = "后台登录相关")
@RequestMapping("oa/common/employee")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmployeeAccountService employeeAccountService;

    @ApiOperation(value = "后台登录", notes = "后台登录")
    @RequestMapping(value = "/v1/login",method = RequestMethod.POST)
    public Response<LoginResp> login(@RequestBody LoginReq loginReq, HttpServletRequest request, HttpSession session){
        return new Response(loginService.login(loginReq,request,session));
    }

    @ApiOperation(value = "图形验证码", notes = "图形验证码")
    @RequestMapping(value = "/v1/imageCode",method = RequestMethod.GET)
    public void imageCode(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        // 设置不缓存
        resp.setHeader( "pragma", "no-cache" );
        resp.setHeader( "cache-control", "no-cache" );
        resp.setDateHeader( "expires", 0 );
        // 指定生成的图片的格式
        resp.setContentType( "image/jpeg" );
        // 验证码的张宽
        int width = 80, height = 30;
        // 图片流
        BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_BGR );

        Graphics g = image.getGraphics(); // 创建Graphics对象,其作用相当于画笔
        Graphics2D g2d = (Graphics2D) g; // 创建Grapchics2D对象
        Font mfont = new Font( "楷体", Font.BOLD, 16 ); // 定义字体样式
        g.setColor( getRandColor( 200, 250 ) );
        g.fillRect( 0, 0, width, height ); // 绘制背景
        g.setFont( mfont ); // 设置字体
        g.setColor( getRandColor( 180, 200 ) );

        // 绘制100条颜色和位置全部为随机产生的线条,该线条为2f
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt( width - 1 );
            int y = random.nextInt( height - 1 );
            int x1 = random.nextInt( 6 ) + 1;
            int y1 = random.nextInt( 12 ) + 1;
            BasicStroke bs = new BasicStroke( 2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL );
            Line2D line2d = new Line2D.Double( x, y, x + x1, y + y1 );
            g2d.setStroke( bs );
            g2d.draw( line2d );
        }

        // 输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。
        String sRand = "";
        String ctmp = "";
        int itmp = 0;
        // 制定输出的验证码为四位
        for (int i = 0; i < 4; i++) {
            // random.nextInt(2)在0-2中间去随机，不包含2，这样是为了下面不去生成中文验证码，验证出现中文时，不好判断
            switch (random.nextInt( 2 )) {
                case 1: // 生成A-Z的字母
                    itmp = random.nextInt( 26 ) + 65;
                    ctmp = String.valueOf( (char) itmp );
                    break;
                default:
                    itmp = random.nextInt( 10 ) + 48;
                    ctmp = String.valueOf( (char) itmp );
                    break;
            }
            sRand += ctmp;
            Color color = new Color( 20 + random.nextInt( 110 ), 20 + random.nextInt( 110 ), random.nextInt( 110 ) );
            g.setColor( color );
            // 将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示
            /* 将文字旋转制定角度 */
            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate( (0) * 3.14 / 180, 15 * i + 8, 7 );
            /* 缩放文字 */
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1f)
                scaleSize = 1f;
            trans.scale( scaleSize, scaleSize );
            g2d_word.setTransform( trans );
            g.drawString( ctmp, 15 * i + 18, 20 );
        }

        // 打开session，并放入验证图片
        HttpSession session = req.getSession( true );
        session.setAttribute( "imageCode", sRand );
        g.dispose(); // 释放g所占用的系统资源
        ImageIO.write( image, "JPEG", resp.getOutputStream() ); // 输出图片
    }

    @ApiOperation(value = "选择楼盘", notes = "通过楼盘id查询用户在该楼盘下拥有的系统权限")
    @RequestMapping(value = "/v1/chooseEstate",method = RequestMethod.GET)
    public Response<ChooseEstateResp> chooseEstate(@RequestParam String estateId, HttpServletRequest request){
        String acctName = request.getHeader("acctName");
        return new Response(loginService.chooseEstate(acctName,estateId));
    }

    @ApiOperation(value = "选择系统", notes = "通过系统id查询用户在该系统下拥有的菜单权限以及按钮权限")
    @RequestMapping(value = "/v1/chooseSystem",method = RequestMethod.GET)
    public Response<List<EmployeePrivilege>> chooseSystem(@RequestParam String privilegeId, HttpServletRequest request){
        String acctName = request.getHeader("acctName");
        String estateId = request.getHeader("estateId");
        return new Response(loginService.chooseSystem(acctName,estateId,privilegeId));
    }

    @ApiOperation(value = "后台登出", notes = "后台登出")
    @RequestMapping(value = "/v1/logout",method = RequestMethod.POST)
    public Response logout(HttpServletRequest request){
        String acctName = request.getHeader("acctName");
        loginService.logout(acctName);
        return new Response();
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Response<String> updatePassword(@RequestBody UpdatePwdReq pwdReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========web/account/v1/updatePassword start========pwdReq=" + pwdReq);
        }
        Response<String> response = new Response<>();
        employeeAccountService.updateAdminPwd(pwdReq,request);
        if (LOG.isInfoEnabled()) {
            LOG.info("=========web/account/v1/updatePassword  end,response=" + response);
        }
        return response;
    }

    private Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255)
            s = 255;
        if (e > 255)
            e = 255;
        int r, g, b;
        r = s + random.nextInt( e - s ); // 随机生成RGB颜色中的r值
        g = s + random.nextInt( e - s ); // 随机生成RGB颜色中的g值
        b = s + random.nextInt( e - s ); // 随机生成RGB颜色中的b值
        return new Color( r, g, b );
    }
}
