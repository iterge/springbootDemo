package com.example.demo;

import com.example.demo.entity.Schedule;
import com.example.demo.service.ScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
	@Autowired
	private ScheduleService scheduleService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void ioTest(){
		List<String> data = new ArrayList<>();
		//File file = new File("F:\\历史气象数据.xlsx");
		File f = new File("F:\\");
		File file = new File(f,"aa.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line=br.readLine()) != null){
				data.add(line);
			}
			System.out.println(data.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void tt(){
		File file = new File("F:\\aa.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fds = new FileOutputStream("F:\\a.txt");
			byte[] bytes = new byte[10];
			int len;
			//fis.read(bytes);
			while ((len = fis.read(bytes)) != -1){
				System.out.println(new String(bytes,0,len));
				fds.write(bytes,0,len);
			}
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void TestJob(){
		Schedule schedule = new Schedule();
		schedule.setId("1");
		schedule.setJobCron("0/5 * * * * ? ");
		schedule.setJobGroup("Test");
		schedule.setJobName("testjob");
		schedule.setJobStatus("1");
		schedule.setTs(new Date());
		scheduleService.addJob(schedule);
	}
}

