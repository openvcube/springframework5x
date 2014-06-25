package test.ejb3;

/**
 * 
 * @author worldheart
 *
 */
public class BusinessImpl implements IBusinessInterface {

    public String getStr(String args) {
        return "Hello," + args + "!";
    }

}
