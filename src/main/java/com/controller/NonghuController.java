
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nonghu")
public class NonghuController {
    private static final Logger logger = LoggerFactory.getLogger(NonghuController.class);

    private static final String TABLE_NAME = "nonghu";

    @Autowired
    private NonghuService nonghuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinChatService shangpinChatService;//用户咨询
    @Autowired
    private ShangpinCollectionService shangpinCollectionService;//商品收藏
    @Autowired
    private ShangpinCommentbackService shangpinCommentbackService;//商品评价
    @Autowired
    private ShangpinOrderService shangpinOrderService;//商品订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("农户".equals(role))
            params.put("nonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = nonghuService.queryPage(params);

        //字典表数据转换
        List<NonghuView> list =(List<NonghuView>)page.getList();
        for(NonghuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NonghuEntity nonghu = nonghuService.selectById(id);
        if(nonghu !=null){
            //entity转view
            NonghuView view = new NonghuView();
            BeanUtils.copyProperties( nonghu , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NonghuEntity nonghu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nonghu:{}",this.getClass().getName(),nonghu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<NonghuEntity> queryWrapper = new EntityWrapper<NonghuEntity>()
            .eq("username", nonghu.getUsername())
            .or()
            .eq("nonghu_phone", nonghu.getNonghuPhone())
            .or()
            .eq("nonghu_id_number", nonghu.getNonghuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NonghuEntity nonghuEntity = nonghuService.selectOne(queryWrapper);
        if(nonghuEntity==null){
            nonghu.setCreateTime(new Date());
            nonghu.setPassword("123456");
            nonghuService.insert(nonghu);
            return R.ok();
        }else {
            return R.error(511,"账户或者农户手机号或者农户身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NonghuEntity nonghu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nonghu:{}",this.getClass().getName(),nonghu.toString());
        NonghuEntity oldNonghuEntity = nonghuService.selectById(nonghu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(nonghu.getNonghuPhoto()) || "null".equals(nonghu.getNonghuPhoto())){
                nonghu.setNonghuPhoto(null);
        }

            nonghuService.updateById(nonghu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NonghuEntity> oldNonghuList =nonghuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nonghuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<NonghuEntity> nonghuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NonghuEntity nonghuEntity = new NonghuEntity();
//                            nonghuEntity.setUsername(data.get(0));                    //账户 要改的
//                            nonghuEntity.setPassword("123456");//密码
//                            nonghuEntity.setNonghuUuidNumber(data.get(0));                    //农户编号 要改的
//                            nonghuEntity.setNonghuName(data.get(0));                    //农户姓名 要改的
//                            nonghuEntity.setNonghuPhone(data.get(0));                    //农户手机号 要改的
//                            nonghuEntity.setNonghuIdNumber(data.get(0));                    //农户身份证号 要改的
//                            nonghuEntity.setNonghuPhoto("");//详情和图片
//                            nonghuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            nonghuEntity.setNonghuEmail(data.get(0));                    //农户邮箱 要改的
//                            nonghuEntity.setNewMoney(data.get(0));                    //余额 要改的
//                            nonghuEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            nonghuEntity.setCreateTime(date);//时间
                            nonghuList.add(nonghuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //农户编号
                                if(seachFields.containsKey("nonghuUuidNumber")){
                                    List<String> nonghuUuidNumber = seachFields.get("nonghuUuidNumber");
                                    nonghuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nonghuUuidNumber = new ArrayList<>();
                                    nonghuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nonghuUuidNumber",nonghuUuidNumber);
                                }
                                //农户手机号
                                if(seachFields.containsKey("nonghuPhone")){
                                    List<String> nonghuPhone = seachFields.get("nonghuPhone");
                                    nonghuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> nonghuPhone = new ArrayList<>();
                                    nonghuPhone.add(data.get(0));//要改的
                                    seachFields.put("nonghuPhone",nonghuPhone);
                                }
                                //农户身份证号
                                if(seachFields.containsKey("nonghuIdNumber")){
                                    List<String> nonghuIdNumber = seachFields.get("nonghuIdNumber");
                                    nonghuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nonghuIdNumber = new ArrayList<>();
                                    nonghuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("nonghuIdNumber",nonghuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<NonghuEntity> nonghuEntities_username = nonghuService.selectList(new EntityWrapper<NonghuEntity>().in("username", seachFields.get("username")));
                        if(nonghuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NonghuEntity s:nonghuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //农户编号
                        List<NonghuEntity> nonghuEntities_nonghuUuidNumber = nonghuService.selectList(new EntityWrapper<NonghuEntity>().in("nonghu_uuid_number", seachFields.get("nonghuUuidNumber")));
                        if(nonghuEntities_nonghuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NonghuEntity s:nonghuEntities_nonghuUuidNumber){
                                repeatFields.add(s.getNonghuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农户编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //农户手机号
                        List<NonghuEntity> nonghuEntities_nonghuPhone = nonghuService.selectList(new EntityWrapper<NonghuEntity>().in("nonghu_phone", seachFields.get("nonghuPhone")));
                        if(nonghuEntities_nonghuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NonghuEntity s:nonghuEntities_nonghuPhone){
                                repeatFields.add(s.getNonghuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [农户手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //农户身份证号
                        List<NonghuEntity> nonghuEntities_nonghuIdNumber = nonghuService.selectList(new EntityWrapper<NonghuEntity>().in("nonghu_id_number", seachFields.get("nonghuIdNumber")));
                        if(nonghuEntities_nonghuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NonghuEntity s:nonghuEntities_nonghuIdNumber){
                                repeatFields.add(s.getNonghuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农户身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nonghuService.insertBatch(nonghuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        NonghuEntity nonghu = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("username", username));
        if(nonghu==null || !nonghu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(nonghu.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(nonghu.getId(),username, "nonghu", "农户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","农户");
        r.put("username",nonghu.getNonghuName());
        r.put("tableName","nonghu");
        r.put("userId",nonghu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody NonghuEntity nonghu, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<NonghuEntity> queryWrapper = new EntityWrapper<NonghuEntity>()
            .eq("username", nonghu.getUsername())
            .or()
            .eq("nonghu_phone", nonghu.getNonghuPhone())
            .or()
            .eq("nonghu_id_number", nonghu.getNonghuIdNumber())
            ;
        NonghuEntity nonghuEntity = nonghuService.selectOne(queryWrapper);
        if(nonghuEntity != null)
            return R.error("账户或者农户手机号或者农户身份证号已经被使用");
        nonghu.setNonghuUuidNumber(String.valueOf(new Date().getTime()));
        nonghu.setNewMoney(0.0);
        nonghu.setJinyongTypes(1);//启用
        nonghu.setCreateTime(new Date());
        nonghuService.insert(nonghu);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        NonghuEntity nonghu = nonghuService.selectById(id);
        nonghu.setPassword("123456");
        nonghuService.updateById(nonghu);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        NonghuEntity nonghu = nonghuService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(nonghu.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(nonghu.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        nonghu.setPassword(newPassword);
		nonghuService.updateById(nonghu);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        NonghuEntity nonghu = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("username", username));
        if(nonghu!=null){
            nonghu.setPassword("123456");
            nonghuService.updateById(nonghu);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrNonghu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        NonghuEntity nonghu = nonghuService.selectById(id);
        if(nonghu !=null){
            //entity转view
            NonghuView view = new NonghuView();
            BeanUtils.copyProperties( nonghu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nonghuService.queryPage(params);

        //字典表数据转换
        List<NonghuView> list =(List<NonghuView>)page.getList();
        for(NonghuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NonghuEntity nonghu = nonghuService.selectById(id);
            if(nonghu !=null){


                //entity转view
                NonghuView view = new NonghuView();
                BeanUtils.copyProperties( nonghu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NonghuEntity nonghu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nonghu:{}",this.getClass().getName(),nonghu.toString());
        Wrapper<NonghuEntity> queryWrapper = new EntityWrapper<NonghuEntity>()
            .eq("username", nonghu.getUsername())
            .or()
            .eq("nonghu_phone", nonghu.getNonghuPhone())
            .or()
            .eq("nonghu_id_number", nonghu.getNonghuIdNumber())
//            .notIn("nonghu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NonghuEntity nonghuEntity = nonghuService.selectOne(queryWrapper);
        if(nonghuEntity==null){
            nonghu.setCreateTime(new Date());
            nonghu.setPassword("123456");
        nonghuService.insert(nonghu);

            return R.ok();
        }else {
            return R.error(511,"账户或者农户手机号或者农户身份证号已经被使用");
        }
    }

}

