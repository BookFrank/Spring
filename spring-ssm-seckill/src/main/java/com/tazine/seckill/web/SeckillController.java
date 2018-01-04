package com.tazine.seckill.web;

import com.tazine.seckill.dto.Exposer;
import com.tazine.seckill.dto.SeckillExecution;
import com.tazine.seckill.dto.SeckillResult;
import com.tazine.seckill.entity.Seckill;
import com.tazine.seckill.exception.SeckillException;
import com.tazine.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lina on 2018/1/3.
 *
 * @author frank
 * @since 1.0.0
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        // list.jsp + Model = ModelAndView

        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        if (null == seckillId){
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    private SeckillResult<Exposer> exposer(Long seckillId){
        SeckillResult<Exposer> ret;
        try {
            Exposer exposer = seckillService.exposeSeckillUrl(seckillId);
            ret = new SeckillResult<>(true, exposer);
        } catch (Exception e) {
            e.printStackTrace();
            ret = new SeckillResult<>(false, e.getMessage());
        }
        return ret;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable Long seckillId,@PathVariable String md5, @CookieValue(value = "killPhone", required = false) Long userPhone){
        SeckillResult<SeckillExecution> ret = null;
        // springmvc valid
        if (null == userPhone){
            return new SeckillResult<>(false,"未注册");
        }
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId,userPhone,md5);
            ret = new SeckillResult<>(true, execution);
        } catch (SeckillException e) {
            e.printStackTrace();
            ret = new SeckillResult<>(false,e.getMessage());
        }
        return ret;
    }



}
