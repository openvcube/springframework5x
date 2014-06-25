package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 基于文件形式，读取HelloWorld所需的字符串。
 * 
 * @author worldheart
 */
public class FileHelloStrImpl implements IHelloStr {
	
    protected static final Log log = LogFactory.getLog(FileHelloStrImpl.class);

    private String propfilename;
    
    public FileHelloStrImpl(String propfilename) {
        this.propfilename = propfilename;
    }
    
    public String getContent() {
        String helloworld = "";

        try {
            Properties properties = new Properties();
            //读入输入流
            InputStream is = getClass().getClassLoader().getResourceAsStream(
                    propfilename);
            properties.load(is);
            is.close();
            //获得helloworld键对应的取值
            helloworld = properties.getProperty("helloworld");
        } catch (FileNotFoundException ex) {
            log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        }

        return helloworld;
    }
    
}