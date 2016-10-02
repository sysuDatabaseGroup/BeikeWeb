package utils;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener  {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		//初始化数据库连接的代码
        //and store it as a context attribute
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
        //关闭数据库连接的代码
	}

}
