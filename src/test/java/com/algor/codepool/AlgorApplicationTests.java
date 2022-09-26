package com.algor.codepool;

import com.algor.codepool.common.utils.QueryUtils;
import com.algor.codepool.mvc.bean.ProjectInformation;
import com.algor.codepool.mvc.dao.ProjectInformationDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class AlgorApplicationTests {


    @Test
    void contextLoads() {
        ProjectInformation pro = new ProjectInformation();
        pro.setCompanyName("test");
        Example<ProjectInformation> example = Example.of(pro);
    }

}
