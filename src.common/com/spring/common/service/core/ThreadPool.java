package com.spring.common.service.core;

import org.w3c.dom.Element;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	private ThreadPoolExecutor threadPool;
	private static ThreadPool instance;

	private ThreadPool() {
		System.out.println("initiate threadpool ...");
		try {
			Element element = NetTool.LoadXml("config", "ThreadPool");
			int minThreadPool = Integer.parseInt(NetTool.getXmlProperty(
					element, "minThreadPool"));
			System.out.println("minThreadPool:" + minThreadPool);
			int maxThreadPool = Integer.parseInt(NetTool.getXmlProperty(
					element, "maxThreadPool"));
			System.out.println("maxThreadPool:" + maxThreadPool);
			long keepAliveTime = Long.parseLong(NetTool.getXmlProperty(
					element, "keepAliveTime"));
			System.out.println("keepAliveTime:" + keepAliveTime);
			LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(
					20);
			threadPool = new ThreadPoolExecutor(minThreadPool, maxThreadPool,
					keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);
			threadPool.prestartAllCoreThreads();
			element = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ThreadPool getInstance() {
		if (instance == null)
			instance = new ThreadPool();
		return instance;
	}

	public void execute(Runnable runnable) {
		threadPool.execute(runnable);
	}

}
