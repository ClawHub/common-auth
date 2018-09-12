package com.clawhub.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <Description> AuthApp启动 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@MapperScan("com.clawhub.auth.mapper")
@SpringBootApplication
@ComponentScan(basePackages = {"com.clawhub"})//swagger 使用
@EnableTransactionManagement
public class AuthApp {
    /**
     * Description: 启动springboot<br>
     *
     * @param args <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext confApp = null;
        try {
            confApp = SpringApplication.run(AuthApp.class, args);

        } finally {
            close(confApp);
        }

    }

    /**
     * Description: 优雅关闭服务 <br>
     *
     * @param confApp conf app
     * @author LiZhiming <br>
     * @taskId <br>
     */
    private static void close(ConfigurableApplicationContext confApp) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (confApp != null) {
                confApp.close();
            }
        }));
    }
}