/**************************************************************************************** 
 南京小视科技有限公司           
 ****************************************************************************************/
package com.clawhub.auth.config;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * <Description> MD5 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
public class MD5 {
    public static void main(String[] args) {
        Object obj = new SimpleHash("MD5", "123456", "0", 2);
        System.out.println(obj);
    }
}