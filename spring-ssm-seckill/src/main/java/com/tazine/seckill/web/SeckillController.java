package com.tazine.seckill.web;

import com.tazine.seckill.dto.Exposer;
import com.tazine.seckill.dto.SeckillResult;
import com.tazine.seckill.entity.Seckill;
import com.tazine.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.GET)
    private SeckillResult<Exposer> exposer(Long seckillId){
        SeckillResult<Exposer> ret = new SeckillResult<Exposer>();
        
    }



}
