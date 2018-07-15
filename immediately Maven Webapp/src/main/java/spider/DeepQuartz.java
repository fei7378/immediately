package spider;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import databases.Test1;

public class DeepQuartz implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
		String name = detail.getJobDataMap().getString("name");
		System.out.println("say hello to " + name + " at " + new Date());
		SpriderForJson s1 = new SpriderForJson();
		Test1.allDeleteForCoin();// 因为比世界时间戳限制,必须进行删除
		if (name.equals("deep")) {
			System.out.println("first update  deep" + name + " at " + new Date());
			s1.allInOneForPolicy(100);
			s1.allInOneForBishijie(20);
			name = "second";
		} else {
			s1.allInOneForPolicy(50);
			s1.allInOneForBishijie(20);

			System.out.println("update  deep" + name + " at " + new Date());
		}
	}
}