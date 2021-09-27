package mail;
import com.dajiangtai.djt_spider.util.EmailUtil;

public class TestMail {
	
	public static void main(String[] args) {  
		EmailUtil.sendEmail("爬虫项目节点异常", "请及时处理异常的爬虫项目！！！");
	}
}
