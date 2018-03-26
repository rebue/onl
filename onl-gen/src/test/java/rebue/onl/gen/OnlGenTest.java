package rebue.onl.gen;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import rebue.mbgx.MybatisGeneratorWrap;

/**  
* 创建时间：2018年3月26日 下午3:01:10  
* 项目名称：onl-gen  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlGenTest.java  
* 类说明：  
*/
public class OnlGenTest {

	@Test
    public void test() throws IOException, SQLException, InterruptedException, XMLParserException, InvalidConfigurationException {
        MybatisGeneratorWrap.gen(true, "conf/mbg-onl.properties");
    }
}
  

