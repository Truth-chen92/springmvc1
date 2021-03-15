package cn.tedu.springmvc1.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *spring 在利用Javabean传递参数时
 * 会调用get set方法进行赋值 传递参数
 * 如果没有get set方法 则无法传递
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String[] name;
}
