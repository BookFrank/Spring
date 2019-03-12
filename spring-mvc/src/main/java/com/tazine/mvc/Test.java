package com.tazine.mvc;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.*;

/**
 * @author jiaer.ly
 * @date 2018/02/17
 */
public class Test {

    public static void main(String[] args) {

        Process process = null;

        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File(Test.class.getResource("/").getPath() + "/templates"));
//            cfg.setDefaultEncoding("UTF-8");

            File file = File.createTempFile("success_",".html");

            Template template = cfg.getTemplate("chart.html");

            Map<String, Object> data = new HashMap<>();
            data.put("name", "Huwei P8");

            // 生成替换后的临时文件
            template.process(data, new FileWriter(file));

//            InputStream is = new FileInputStream(file);
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
            System.out.println("临时文件路径为：" + file.getAbsolutePath());
//            String line = br.readLine();
//            while (line != null){
//                System.out.println(line);
//                line = br.readLine();
//            }
//            file.delete();
            String filePath = "/Users/jiaer.ly/Desktop/";
            List<String> cmds = new ArrayList<>();
            cmds.add("/usr/local/Cellar/phantomjs/2.1.1/bin/phantomjs");
            cmds.add(Test.class.getResource("/").getPath()+"/screen.js");
            // 第一个参数为要打开的文件路径
            cmds.add(file.getAbsolutePath());
            // 第二个参数为要保存到的路径
            cmds.add(filePath);

            System.out.println(Arrays.toString(cmds.toArray(new String[0])));
            process = Runtime.getRuntime().exec(cmds.toArray(new String[0]));
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
