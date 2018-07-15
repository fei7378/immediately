package spider;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuickQuartz implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
		String name = detail.getJobDataMap().getString("name");
		SpriderForJson s1 = new SpriderForJson();
		if (name.equals("quick")) {
			System.out.println("first update  quick " + name + " at " + new Date());
			s1.allInOneForjinse(100);
			name = "second";
		} else {
			s1.allInOneForjinse(20);

			System.out.println("update  quick" + name + " at " + new Date());
		}
	}
}
