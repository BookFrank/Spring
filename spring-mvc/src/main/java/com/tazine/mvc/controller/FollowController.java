package com.tazine.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author jiaer.ly
 * @date 2018/02/17
 */
@Controller
@SessionAttributes("articleId")
public class FollowController {

    private final String[] sensitiveWords = {"s1", "k2"};

    @ModelAttribute("comment")
    public String replace(String comment){
        if (comment != null){
            for (String sw : sensitiveWords){
                comment.replaceAll(sw, "xx");
            }
        }
        return comment;
    }

    @RequestMapping("/article/{articleId}/comment")
    public String saveComment(@PathVariable String articleId, RedirectAttributes attributes, Model model){
        attributes.addFlashAttribute("comment", model.asMap().get("comment"));
        model.addAttribute("articleId", articleId);
        // 此处将评论内容保存到数据库
        return "redirect:/showArticle";
    }

    @RequestMapping(value = "/showArticle", method = RequestMethod.GET)
    public String showArticle(Model model, SessionStatus sessionStatus){
        String articleId = (String) model.asMap().get("articleId");
        model.addAttribute("articleTitle", articleId + "号文章标题");
        model.addAttribute("article", articleId + "号文章内容");
        sessionStatus.setComplete();
        return "article";
    }
}
