package spider;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class timer {
	public static void main(String[] args) {
		// 调用爬虫
		timerSpider(true);

	}

	public static void timerSpider(Boolean on_off) {

		try {
			// 创建scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 快讯的定时器
			// 定义一个Trigger
			Trigger quickTrigger = newTrigger().withIdentity("triggerQuick", "quick") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(simpleSchedule() // 使用SimpleTrigger
							.withIntervalInSeconds(300) // 每隔300秒执行一次
							.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();

			// 定义一个JobDetail
			JobDetail quickJob = newJob(QuickQuartz.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
					.withIdentity("triggerQuick", "quick") // 定义name/group
					.usingJobData("name", "quick") // 定义属性
					.build();

			// 政策页面的定时器

			// 定义一个Trigger
			Trigger deepTrigger = newTrigger().withIdentity("triggerDeep", "deep") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(simpleSchedule() // 使用SimpleTrigger
							.withIntervalInHours(2)// 每隔2小时执行一次
							// .withIntervalInSeconds(1) // 每隔一秒执行一次
							.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();
			// 定义一个JobDetail
			JobDetail deepJob = newJob(DeepQuartz.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
					.withIdentity("triggerDeep", "deep") // 定义name/group
					.usingJobData("name", "deep") // 定义属性
					.build();

			// 加入这个调度
			scheduler.scheduleJob(quickJob, quickTrigger);
			scheduler.scheduleJob(deepJob, deepTrigger);

			// 启动之
			if (on_off) {
				scheduler.start();
				System.out.println("爬虫已启动");
			} else {
				scheduler.shutdown(true);
			}
			// 运行一段时间后关闭
			// Thread.sleep(10000);
			// scheduler.shutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
