
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
 * 帮扶申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpinBangfushenqing")
public class ShangpinBangfushenqingController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinBangfushenqingController.class);

    private static final String TABLE_NAME = "shangpinBangfushenqing";

    @Autowired
    private ShangpinBangfushenqingService shangpinBangfushenqingService;


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
    private NonghuService nonghuService;//农户
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
        PageUtils page = shangpinBangfushenqingService.queryPage(params);

        //字典表数据转换
        List<ShangpinBangfushenqingView> list =(List<ShangpinBangfushenqingView>)page.getList();
        for(ShangpinBangfushenqingView c:list){
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
        ShangpinBangfushenqingEntity shangpinBangfushenqing = shangpinBangfushenqingService.selectById(id);
        if(shangpinBangfushenqing !=null){
            //entity转view
            ShangpinBangfushenqingView view = new ShangpinBangfushenqingView();
            BeanUtils.copyProperties( shangpinBangfushenqing , view );//把实体数据重构到view中
            //级联表 商品
            //级联表
            ShangpinEntity shangpin = shangpinService.selectById(shangpinBangfushenqing.getShangpinId());
            if(shangpin != null){
            BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangpinId(shangpin.getId());
            }
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
    public R save(@RequestBody ShangpinBangfushenqingEntity shangpinBangfushenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpinBangfushenqing:{}",this.getClass().getName(),shangpinBangfushenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShangpinBangfushenqingEntity> queryWrapper = new EntityWrapper<ShangpinBangfushenqingEntity>()
            .eq("shangpin_id", shangpinBangfushenqing.getShangpinId())
            .in("shangpin_bangfushenqing_yesno_types", new Integer[]{1})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinBangfushenqingEntity shangpinBangfushenqingEntity = shangpinBangfushenqingService.selectOne(queryWrapper);
        if(shangpinBangfushenqingEntity==null){
            shangpinBangfushenqing.setInsertTime(new Date());
            shangpinBangfushenqing.setShangpinBangfushenqingYesnoTypes(1);
            shangpinBangfushenqing.setCreateTime(new Date());
            shangpinBangfushenqingService.insert(shangpinBangfushenqing);
            return R.ok();
        }else {
            if(shangpinBangfushenqingEntity.getShangpinBangfushenqingYesnoTypes()==1)
                return R.error(511,"该帮扶申请正在审核中,请耐心等待审核");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinBangfushenqingEntity shangpinBangfushenqing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shangpinBangfushenqing:{}",this.getClass().getName(),shangpinBangfushenqing.toString());
        ShangpinBangfushenqingEntity oldShangpinBangfushenqingEntity = shangpinBangfushenqingService.selectById(shangpinBangfushenqing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shangpinBangfushenqing.getShangpinBangfushenqingFile()) || "null".equals(shangpinBangfushenqing.getShangpinBangfushenqingFile())){
                shangpinBangfushenqing.setShangpinBangfushenqingFile(null);
        }
        if("".equals(shangpinBangfushenqing.getShangpinBangfushenqingContent()) || "null".equals(shangpinBangfushenqing.getShangpinBangfushenqingContent())){
                shangpinBangfushenqing.setShangpinBangfushenqingContent(null);
        }
        if("".equals(shangpinBangfushenqing.getShangpinBangfushenqingYesnoText()) || "null".equals(shangpinBangfushenqing.getShangpinBangfushenqingYesnoText())){
                shangpinBangfushenqing.setShangpinBangfushenqingYesnoText(null);
        }

            shangpinBangfushenqingService.updateById(shangpinBangfushenqing);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShangpinBangfushenqingEntity shangpinBangfushenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shangpinBangfushenqingEntity:{}",this.getClass().getName(),shangpinBangfushenqingEntity.toString());

        ShangpinBangfushenqingEntity oldShangpinBangfushenqing = shangpinBangfushenqingService.selectById(shangpinBangfushenqingEntity.getId());//查询原先数据

        if(shangpinBangfushenqingEntity.getShangpinBangfushenqingYesnoTypes() == 2){//通过

            ShangpinEntity shangpinEntity = shangpinService.selectById(oldShangpinBangfushenqing.getShangpinId());
            if(shangpinEntity==null)
                return R.error("查不到商品,不能通过此审核");
            shangpinEntity.setBangfuTypes(1);
            shangpinService.updateById(shangpinEntity);
        }else if(shangpinBangfushenqingEntity.getShangpinBangfushenqingYesnoTypes() == 3){//拒绝
        }
        shangpinBangfushenqingEntity.setShangpinBangfushenqingShenheTime(new Date());//审核时间
        shangpinBangfushenqingService.updateById(shangpinBangfushenqingEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShangpinBangfushenqingEntity> oldShangpinBangfushenqingList =shangpinBangfushenqingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shangpinBangfushenqingService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShangpinBangfushenqingEntity> shangpinBangfushenqingList = new ArrayList<>();//上传的东西
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
                            ShangpinBangfushenqingEntity shangpinBangfushenqingEntity = new ShangpinBangfushenqingEntity();
//                            shangpinBangfushenqingEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingUuidNumber(data.get(0));                    //帮扶申请编号 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingName(data.get(0));                    //申请标题 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingTypes(Integer.valueOf(data.get(0)));   //帮扶申请类型 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingFile(data.get(0));                    //附件 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingContent("");//详情和图片
//                            shangpinBangfushenqingEntity.setInsertTime(date);//时间
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingYesnoText(data.get(0));                    //审核附件 要改的
//                            shangpinBangfushenqingEntity.setShangpinBangfushenqingShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shangpinBangfushenqingEntity.setCreateTime(date);//时间
                            shangpinBangfushenqingList.add(shangpinBangfushenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //帮扶申请编号
                                if(seachFields.containsKey("shangpinBangfushenqingUuidNumber")){
                                    List<String> shangpinBangfushenqingUuidNumber = seachFields.get("shangpinBangfushenqingUuidNumber");
                                    shangpinBangfushenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shangpinBangfushenqingUuidNumber = new ArrayList<>();
                                    shangpinBangfushenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shangpinBangfushenqingUuidNumber",shangpinBangfushenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //帮扶申请编号
                        List<ShangpinBangfushenqingEntity> shangpinBangfushenqingEntities_shangpinBangfushenqingUuidNumber = shangpinBangfushenqingService.selectList(new EntityWrapper<ShangpinBangfushenqingEntity>().in("shangpin_bangfushenqing_uuid_number", seachFields.get("shangpinBangfushenqingUuidNumber")));
                        if(shangpinBangfushenqingEntities_shangpinBangfushenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShangpinBangfushenqingEntity s:shangpinBangfushenqingEntities_shangpinBangfushenqingUuidNumber){
                                repeatFields.add(s.getShangpinBangfushenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [帮扶申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shangpinBangfushenqingService.insertBatch(shangpinBangfushenqingList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shangpinBangfushenqingService.queryPage(params);

        //字典表数据转换
        List<ShangpinBangfushenqingView> list =(List<ShangpinBangfushenqingView>)page.getList();
        for(ShangpinBangfushenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinBangfushenqingEntity shangpinBangfushenqing = shangpinBangfushenqingService.selectById(id);
            if(shangpinBangfushenqing !=null){


                //entity转view
                ShangpinBangfushenqingView view = new ShangpinBangfushenqingView();
                BeanUtils.copyProperties( shangpinBangfushenqing , view );//把实体数据重构到view中

                //级联表
                    ShangpinEntity shangpin = shangpinService.selectById(shangpinBangfushenqing.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
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
    public R add(@RequestBody ShangpinBangfushenqingEntity shangpinBangfushenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shangpinBangfushenqing:{}",this.getClass().getName(),shangpinBangfushenqing.toString());
        Wrapper<ShangpinBangfushenqingEntity> queryWrapper = new EntityWrapper<ShangpinBangfushenqingEntity>()
            .eq("shangpin_id", shangpinBangfushenqing.getShangpinId())
            .eq("shangpin_bangfushenqing_uuid_number", shangpinBangfushenqing.getShangpinBangfushenqingUuidNumber())
            .eq("shangpin_bangfushenqing_name", shangpinBangfushenqing.getShangpinBangfushenqingName())
            .eq("shangpin_bangfushenqing_types", shangpinBangfushenqing.getShangpinBangfushenqingTypes())
            .in("shangpin_bangfushenqing_yesno_types", new Integer[]{1,2})
            .eq("shangpin_bangfushenqing_yesno_text", shangpinBangfushenqing.getShangpinBangfushenqingYesnoText())
//            .notIn("shangpin_bangfushenqing_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinBangfushenqingEntity shangpinBangfushenqingEntity = shangpinBangfushenqingService.selectOne(queryWrapper);
        if(shangpinBangfushenqingEntity==null){
            shangpinBangfushenqing.setInsertTime(new Date());
            shangpinBangfushenqing.setShangpinBangfushenqingYesnoTypes(1);
            shangpinBangfushenqing.setCreateTime(new Date());
        shangpinBangfushenqingService.insert(shangpinBangfushenqing);

            return R.ok();
        }else {
            if(shangpinBangfushenqingEntity.getShangpinBangfushenqingYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shangpinBangfushenqingEntity.getShangpinBangfushenqingYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

