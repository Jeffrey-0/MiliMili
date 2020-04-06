package servlet;

import model.Resource;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Resource res = new Resource();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(res, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat time2 = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = time2.format(date);
        Part part = request.getPart("img");
        String img = upload(part, request);
        part = request.getPart("code");
        String code = upload(part, request);
        String sql = "insert into src(uploader,up,name,descn,img,code,date,category) values(?,?,?,?,?,?,?,?)";
//        Integer s = (Integer) request.getSession().getAttribute("userId");
        String up = (String) request.getSession().getAttribute("username");
        Integer uploader = (Integer) request.getSession().getAttribute("userId");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        int update = template.update(sql, uploader,up, res.getName(), res.getDescn(), img, code, date2,"用户分享");
        System.out.println("update = " + update);
        response.sendRedirect("upload.jsp");
    }


    protected String upload(Part part, HttpServletRequest request) throws IOException, ServletException {
        try {
            // 获取请求的信息
            String name = part.getHeader("content-disposition");
            System.out.println(name);
            if (name.lastIndexOf(".") != -1) {
                // 获取上传文件的目录
                String root = request.getServletContext().getRealPath("/img");
                System.out.println("测试上传文件的路径：" + root);
                // 获取文件的后缀
                String str = name.substring(name.lastIndexOf("."), name.length() - 1);
                System.out.println("测试获取文件的后缀：" + str);
                // 生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
                String imgName = System.currentTimeMillis() + "" + (int) (Math.random() * 1000000) + str;
                String filename = root + "\\" + imgName;
                System.out.println("测试产生新的文件名：" + imgName);
                // 上传文件到指定目录，不想上传文件就不调用这个
                part.write(filename);
                System.out.println("测试产生文件的相对目录：" + "/img/" + imgName);
                return "img/"+imgName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
