package test;

import dao.ResDao;
import org.junit.Test;


public class ResTest {
    ResDao rd = new ResDao();

    @Test
    public void newRes() {
        String newRes = rd.queryNewRes();
        System.out.println(newRes);
    }
    @Test
    public void ranRes(){
        String ranRes = rd.queryRanRes(5);
        System.out.println(ranRes);
    }
    @Test
    public void res(){
        String res = rd.queryResById("63");
        System.out.println(res);
    }
    @Test
    public void search(){
        String searchList = rd.queryResByName("界面","2");
        System.out.println(searchList);
    }
    @Test
    public void searchCount(){
        Integer pages = rd.querySearchPages("tsa");
        System.out.println(pages);
    }
    @Test
    public void category(){
        String category = rd.queryResByCategory("新番放送", "1");
        System.out.println(category);
    }
}
