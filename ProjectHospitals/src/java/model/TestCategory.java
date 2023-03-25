package model;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class TestCategory {
    private int testCategoryid;
    private String testName;
    private String image;
    private int testPrice;
    

    public TestCategory() {
    }

    public TestCategory(int testCategoryid, String testName,String image, int testPrice) {
        this.testCategoryid = testCategoryid;
        this.testName = testName;
        this.image = image;
        this.testPrice = testPrice;
        
    }

    public int getTestCategoryid() {
        return testCategoryid;
    }

    public void setTestCategoryid(int testCategoryid) {
        this.testCategoryid = testCategoryid;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestPrice() {
        return testPrice;
    }

    public void setTestPrice(int testPrice) {
        this.testPrice = testPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TestCategory{" + "testCategoryid=" + testCategoryid + ", testName=" + testName + ", testPrice=" + testPrice + ", image=" + image + '}';
    }

  
    
}
