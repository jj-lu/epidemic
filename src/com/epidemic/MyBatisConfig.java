package com.epidemic;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.epidemic.mapper")
public class MyBatisConfig {

    private static Logger logger = Logger.getLogger(MyBatisConfig.class);

    //配置数据源
    @Bean(name = "dataSource", destroyMethod = "close")
    public BasicDataSource basicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/epidemic");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        dataSource.setInitialSize(3);
        dataSource.setMaxActive(50);
        dataSource.setMaxIdle(1);
        dataSource.setMaxWait(4000);
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory factory = null;
        //设置xml文件中的类所在的包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.epidemic.beans");

        //为了让mybaits自动将下划线分割的列名转换未驼峰表示的属性名
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        try {
            //设置映射xml文件的路径
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/epidemic/mapper/*Mapper.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            factory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("解析映射xml文件时异常");
        }

        return factory;
    }
}
