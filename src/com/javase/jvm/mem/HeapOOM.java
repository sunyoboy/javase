/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: HeapOOM.java
 * Author:   DD240
 * Date:     2015-12-29 下午4:57:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError<br> 
 *  MyEclipse VM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class HeapOOM {
    static class OOMObject {
        
    }
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
