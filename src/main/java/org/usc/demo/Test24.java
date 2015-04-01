package org.usc.demo;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class Test24 {

    public static void main(String[] args) {
        List<Riddles> lists = Lists.newArrayList();
        lists.add(new Riddles("1", "谜底1"));
        lists.add(new Riddles("3", "谜底3"));
        lists.add(new Riddles("8", "谜底8"));

        System.out.println(JSON.toJSONString(lists));
    }

}

class Riddles {
    private String title;
    private String answer;

    public Riddles(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
