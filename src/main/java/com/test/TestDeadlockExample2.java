package com.test;
import java.util.concurrent.locks.ReentrantLock;


public class TestDeadlockExample2 {
	public static void main(String[] args) {
		final String resource1 = "ratan jaiswal";
		final String resource2 = "vimal jaiswal";
		
		final ReentrantLock lock1 = new ReentrantLock();
		
		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread("worker-thread-1") {
			public void run() {
				try {
					lock1.lockInterruptibly();
					
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
					
					synchronized (resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted");
				} finally {
					lock1.unlock();
				}
			}
		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread("worker-thread-2") {
			public void run() {
				try {
					lock1.lockInterruptibly();
					
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
					
					synchronized (resource1) {
						System.out.println("Thread 1: locked resource 2");
					}
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted");
				} finally {
					lock1.unlock();
				}
			}
		};

		t1.start();
		t2.start();
		
		try {
			System.out.println("Simulated deadlock");
			Thread.sleep(15000);
			System.out.println("Releasing the deadlock");
			t1.interrupt();
			t2.interrupt();
		} catch (Exception e) {
		}
	}
}