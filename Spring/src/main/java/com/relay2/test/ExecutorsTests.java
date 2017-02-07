package com.relay2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.math.RandomUtils;

public class ExecutorsTests {

	public static void main(String[] args) throws Exception {

		//testDefaultThreadFactory();
//		testSingleThreadExecutor();
//		testSingleScheduledThreadExecutor();
//		testCachedThread();
//		testFixedThread();
		testCompletionService();
	}

	public static void testDefaultThreadFactory() {
		ThreadFactory factory = Executors.defaultThreadFactory();
//		ThreadFactory factory = new ThreadFactory() {
//			
//			@Override
//			public Thread newThread(Runnable r) {
//				return new Thread(r);
//			}
//		};
		for (int i = 0; i < 100000; i++) {
			Thread thread = factory.newThread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("test:" + Thread.currentThread().getName());
				}
			});
			thread.start();
		}
	}
	
	public static void testSingleThreadExecutor(){
		ExecutorService service = Executors.newSingleThreadExecutor();
		final AtomicInteger count = new AtomicInteger(0);
		
		for(int i=0; i< 100; i++){
			service.submit(new Runnable() {
				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int c = count.incrementAndGet();
					System.out.println("Test: " + Thread.currentThread().getName()+", total count: " + c);
					// the sub tasks will be executed even the a failure for execution a task.
					if(count.get()==50){
						throw new RuntimeException();
					}
				}
			});
		}
		service.shutdown();
	}
	
	public static void testSingleScheduledThreadExecutor() throws Exception{
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		service.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("Test: " + Thread.currentThread().getName());
			}
		}, 0, 100, TimeUnit.MILLISECONDS);
		System.out.println("wait for 10s.");
		Thread.sleep(10000);
		service.shutdown();
	}
	
	public static void testCachedThread(){
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i=0; i< 10000; i++){
			service.execute(new Runnable() {
				public void run() {
					System.out.println("Test: " + Thread.currentThread().getName());
				}
			});
		}
		service.shutdown();
	}
	
	public static void testFixedThread(){
		ExecutorService service = Executors.newFixedThreadPool(1);
		
		for(int i=0; i< 100; i++){
			final int x = i;
			@SuppressWarnings("unused")
			Future<?> submit = service.submit(new Runnable() {
				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Test: " + Thread.currentThread().getName());
					if(x==5){
						throw new RuntimeException();
					}
				}
			});
		}
		service.shutdown();
	}
	
	public static void testCompletionService(){
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		CompletionService<Integer> ecs = new ExecutorCompletionService<Integer>(service);
		List<Future<Integer>> list = new ArrayList<>();
		for(int i =0; i < 100; i=i+10){
			final int z = i;
			Future<Integer> result = ecs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(RandomUtils.nextInt(2000));
					int sum = 0;
					for(int j=0; j < 10; j++){
						sum += (j+z);
					}
					if(z == 0)
						throw new RuntimeException();
					System.out.println("sub task done, rsult: " + sum);
					return sum;
				}
			});
			list.add(result);
		}
		service.shutdown();
		int total = 0;
		for(int i =0; i<list.size(); i++){
			try {
				Integer r = list.get(i).get();
				total += r;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("result: " + total);
	}
}
